package com.pinyougou.sellergoods.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.pinyougou.mapper.*;
import com.pinyougou.pojo.*;
import entity.Goods;
import entity.Result;
import org.springframework.beans.factory.annotation.Autowired;
import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.pinyougou.pojo.TbGoodsExample.Criteria;
import com.pinyougou.sellergoods.service.GoodsService;

import entity.PageResult;
import org.springframework.transaction.annotation.Transactional;

/**
 * 服务实现层
 *
 * @author Administrator
 */
@Service
@Transactional
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    private TbGoodsMapper goodsMapper;
    @Autowired
    private TbGoodsDescMapper goodsDescMapper;
    @Autowired
    private TbItemMapper itemMapper;
    @Autowired
    private TbBrandMapper brandMapper;
    @Autowired
    private TbItemCatMapper itemCatMapper;
    @Autowired
    private TbSellerMapper sellerMapper;

    /**
     * 查询全部
     */
    @Override
    public List<TbGoods> findAll() {
        return goodsMapper.selectByExample(null);
    }

    /**
     * 按分页查询
     */
    @Override
    public PageResult findPage(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        Page<TbGoods> page = (Page<TbGoods>) goodsMapper.selectByExample(null);
        return new PageResult(page.getTotal(), page.getResult());
    }

    /**
     * 增加
     */
    @Override
    public void add(Goods goods) {
        goods.getGoods().setAuditStatus("0");
        goodsMapper.insert(goods.getGoods()); // 插入商品表
        goods.getGoodsDesc().setGoodsId(goods.getGoods().getId());
        goodsDescMapper.insert(goods.getGoodsDesc());// 插入商品扩展数据
        System.out.println("========================add==================add=======================");
        saveItemList(goods);
    }


    /**
     * 修改
     */
    @Override
    public void update(Goods goods) {
        goods.getGoods().setAuditStatus("0");// 设置未审核状态:如果是经过修改的商品，需要新审核
        goodsMapper.updateByPrimaryKey(goods.getGoods());// 保存商品表
        goodsDescMapper.updateByPrimaryKey(goods.getGoodsDesc());// 保存商品扩展表
        // 删除原有的 sku 列表数据
        TbItemExample example = new TbItemExample();
        com.pinyougou.pojo.TbItemExample.Criteria criteria = example.createCriteria();
        criteria.andGoodsIdEqualTo(goods.getGoods().getId());
        itemMapper.deleteByExample(example);
        // 添加新的 sku 列表数据
        saveItemList(goods);// 插入商品 SKU 列表数据
    }

    private void saveItemList(Goods goods) {
        if("1".equals(goods.getGoods().getIsEnableSpec())){
            System.out.println("========================saveItemList==================saveItemList=======================");
            for (TbItem item : goods.getItemList()) {
                // 标题
                String title = goods.getGoods().getGoodsName();
                Map<String, Object> specMap = JSON.parseObject(item.getSpec());
                for (String key : specMap.keySet()) {
                    title += " " + specMap.get(key);
                }
                item.setTitle(title);

                setItemValue(goods,item);

                itemMapper.insert(item);
            }
        }else{
            TbItem item=new TbItem();
            item.setTitle(goods.getGoods().getGoodsName());//SKU名称
            item.setPrice( goods.getGoods().getPrice() );//价格
            item.setStatus("1");//状态
            item.setIsDefault("1");//是否默认
            item.setNum(99999);//库存数量

            setItemValue(goods,item);
            itemMapper.insert(item);
        }
    }

    private void setItemValue(Goods goods,TbItem tbItem){
        System.out.println("========================setItemValue==================setItemValue=======================");

        tbItem.setGoodsId(goods.getGoods().getId());
        tbItem.setSellerId(goods.getGoods().getSellerId());
        tbItem.setCategoryid(goods.getGoods().getCategory3Id());
        tbItem.setCreateTime(new Date());
        tbItem.setUpdateTime(new Date());

        TbBrand brand = brandMapper.selectByPrimaryKey(goods.getGoods().getBrandId());
        tbItem.setBrand(brand.getName());

        TbItemCat itemCat = itemCatMapper.selectByPrimaryKey(goods.getGoods().getCategory3Id());
        tbItem.setCategory(itemCat.getName());

        TbSeller seller = sellerMapper.selectByPrimaryKey(goods.getGoods().getSellerId());
        tbItem.setSeller(seller.getName());

        List<Map> imageList = JSON.parseArray(goods.getGoodsDesc().getItemImages(),Map.class);
        if(imageList.size() > 0){
            tbItem.setImage(imageList.get(0).get("url").toString());
        }
    }

    /**
     * 根据ID获取实体
     *
     * @param id
     * @return
     */
    @Override

    public Goods findOne(Long id) {
        Goods goods = new Goods();
        TbGoods tbGoods = goodsMapper.selectByPrimaryKey(id);
        goods.setGoods(tbGoods);
        TbGoodsDesc tbGoodsDesc = goodsDescMapper.selectByPrimaryKey(id);
        goods.setGoodsDesc(tbGoodsDesc);

        TbItemExample example = new TbItemExample();
        example.createCriteria().andGoodsIdEqualTo(id);
        List<TbItem> itemList = itemMapper.selectByExample(example);
        goods.setItemList(itemList);
        return goods;
    }

    /**
     * 批量删除
     */
    @Override
    public void delete(Long[] ids) {
        for (Long id : ids) {
            //goodsMapper.deleteByPrimaryKey(id);
            TbGoods goods = goodsMapper.selectByPrimaryKey(id);
            goods.setIsDelete("1");
            goods.setAuditStatus("8");
            goodsMapper.updateByPrimaryKey(goods);
        }
    }


    @Override
    public PageResult findPage(TbGoods goods, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);

        TbGoodsExample example = new TbGoodsExample();
        Criteria criteria = example.createCriteria();
        criteria.andIsDeleteIsNull();

        if(goods!=null){
            if(goods.getSellerId()!=null && goods.getSellerId().length()>0){
                criteria.andSellerIdEqualTo(goods.getSellerId());
            }
            if(goods.getGoodsName()!=null && goods.getGoodsName().length()>0){
                criteria.andGoodsNameLike("%"+goods.getGoodsName()+"%");
            }
            if(goods.getAuditStatus()!=null && goods.getAuditStatus().length()>0){
                criteria.andAuditStatusLike("%"+goods.getAuditStatus()+"%");
            }
            if(goods.getIsMarketable()!=null && goods.getIsMarketable().length()>0){
                criteria.andIsMarketableLike("%"+goods.getIsMarketable()+"%");
            }
            if(goods.getCaption()!=null && goods.getCaption().length()>0){
                criteria.andCaptionLike("%"+goods.getCaption()+"%");
            }
            if(goods.getSmallPic()!=null && goods.getSmallPic().length()>0){
                criteria.andSmallPicLike("%"+goods.getSmallPic()+"%");
            }
            if(goods.getIsEnableSpec()!=null && goods.getIsEnableSpec().length()>0){
                criteria.andIsEnableSpecLike("%"+goods.getIsEnableSpec()+"%");
            }
            if(goods.getIsDelete()!=null && goods.getIsDelete().length()>0){
                criteria.andIsDeleteLike("%"+goods.getIsDelete()+"%");
            }

        }
        Page<TbGoods> page = (Page<TbGoods>) goodsMapper.selectByExample(example);

        return new PageResult(page.getTotal(), page.getResult());
    }

    @Override
    public void updateStatus(Long[] ids, String status) {
        for (Long id : ids) {
            TbGoods goods = goodsMapper.selectByPrimaryKey(id);
            if ("4".equals(goods.getAuditStatus())){
                int i=1/0;
            }
            goods.setAuditStatus(status);
            goodsMapper.updateByPrimaryKey(goods);
        }
    }

    @Override
    public void soldOut(Long[] ids){
        for (Long id : ids) {
            TbGoods goods = goodsMapper.selectByPrimaryKey(id);
            if ("5".equals(goods.getAuditStatus())){
                goods.setAuditStatus("6");
                goodsMapper.updateByPrimaryKey(goods);
            }
        }
    }

    @Override
    public void goodsOnline(Long[] ids){
        for (Long id : ids) {
            TbGoods goods = goodsMapper.selectByPrimaryKey(id);
            if ("2".equals(goods.getAuditStatus()) || "6".equals(goods.getAuditStatus())){
                goods.setAuditStatus("5");
                goodsMapper.updateByPrimaryKey(goods);
            }
        }
    }
}
