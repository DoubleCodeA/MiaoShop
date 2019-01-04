package com.pinyougou.page.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.pinyougou.mapper.TbGoodsDescMapper;
import com.pinyougou.mapper.TbGoodsMapper;
import com.pinyougou.mapper.TbItemCatMapper;
import com.pinyougou.mapper.TbItemMapper;
import com.pinyougou.page.service.ItemPageService;
import com.pinyougou.pojo.*;
import freemarker.core.ParseException;
import freemarker.template.Configuration;
import freemarker.template.MalformedTemplateNameException;
import freemarker.template.Template;
import freemarker.template.TemplateNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfig;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.HashMap;
import java.util.List;

@Service
public class ItemPageServiceImpl implements ItemPageService {
    @Value("${pagedir}")
    private String pagedir;
    @Autowired
    private TbGoodsMapper goodsMapper;
    @Autowired
    private TbGoodsDescMapper goodsDescMapper;
    @Autowired
    private TbItemCatMapper itemCatMapper;
    @Autowired
    private TbItemMapper itemMapper;
    @Autowired
    private FreeMarkerConfig freeMarkerConfig;

    @Override
    public boolean createItemHtml(Long goodsId) {
        Configuration config = freeMarkerConfig.getConfiguration();
        try {
            Template template = config.getTemplate("item.ftl");

            TbGoods goods = goodsMapper.selectByPrimaryKey(goodsId);
            TbGoodsDesc goodsDesc = goodsDescMapper.selectByPrimaryKey(goodsId);

            String catOne = itemCatMapper.selectByPrimaryKey(goods.getCategory1Id()).getName();
            String catTwo = itemCatMapper.selectByPrimaryKey(goods.getCategory2Id()).getName();
            String catThree = itemCatMapper.selectByPrimaryKey(goods.getCategory3Id()).getName();

            TbItemExample example = new TbItemExample();
            example.createCriteria().andGoodsIdEqualTo(goodsId)
                    .andStatusEqualTo("1");
            List<TbItem> itemList = itemMapper.selectByExample(example);

            HashMap map = new HashMap();

            map.put("goods", goods);
            map.put("goodsDesc", goodsDesc);
            map.put("itemCat1", catOne);
            map.put("itemCat2", catTwo);
            map.put("itemCat3", catThree);
            map.put("itemList", itemList);

            FileWriter fileWriter = new FileWriter(pagedir + goodsId + ".html");
            template.process(map, fileWriter);

            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean removeItemHtml(Long[] goodsIds) {
        try {
            for (Long goodsId : goodsIds){
                new File(pagedir+goodsId+".html").delete();
            }
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }


}
