package com.pinyougou.cart.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.pinyougou.cart.service.CartService;
import com.pinyougou.order.service.OrderService;
import com.pinyougou.pay.service.WeixinPayService;
import com.pinyougou.pojo.TbPayLog;
import entity.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pojogroup.Cart;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/cart")
public class CartController {
    @Reference(timeout = 6000)
    private CartService cartService;
    @Autowired
    private HttpServletRequest request;
    @Autowired
    private HttpServletResponse response;


    @RequestMapping("/addGoodsToCartList")
    @CrossOrigin(origins = "http://localhost:9105",allowCredentials = "true")
    public Result addGoodsToCartList(HttpSession session, Long itemId, Integer num){
        try {
            String key = session.getId();
            String username = SecurityContextHolder.getContext().getAuthentication().getName();
            if(!"anonymousUser".equals(username)){
                key = username;
            }
            List<Cart> cartListFromRedis = cartService.findCartListFromRedis(key);
            List<Cart> cartList = cartService.addGoodsToCartList(cartListFromRedis, itemId, num);
            cartService.saveCartListToRedis(key, cartList);
            return new Result(true, "添加成功");
        }catch (Exception e){
            e.printStackTrace();
            return new Result(false, "添加失败");
        }
    }

    @RequestMapping("/findCartList")
    public List<Cart> findCartList(HttpSession session){
        String key = session.getId();
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        List<Cart> cartList_session = cartService.findCartListFromRedis(key);
        if("anonymousUser".equals(username)){
            return cartList_session;
        }
        List<Cart> cartList = cartService.findCartListFromRedis(username);
        if (cartList_session.size() > 0){
            cartList = cartService.mergeCartList(cartList, cartList_session);
            cartService.delCartListToRedis(key);
            cartService.saveCartListToRedis(username, cartList);
        }
        return cartList;
    }


}
