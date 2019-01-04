package com.pinyougou.search.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.pinyougou.mapper.TbItemMapper;
import com.pinyougou.pojo.TbItem;
import com.pinyougou.pojo.TbItemExample;
import com.pinyougou.search.service.ItemSearchService;
import org.junit.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.domain.Sort;
import org.springframework.data.solr.core.SolrTemplate;
import org.springframework.data.solr.core.query.*;
import org.springframework.data.solr.core.query.result.HighlightEntry;
import org.springframework.data.solr.core.query.result.HighlightPage;
import org.springframework.data.solr.core.query.result.ScoredPage;

import java.io.File;
import java.lang.reflect.Array;
import java.util.*;

@Service(timeout = 10000)
public class ItemSearchServiceImpl implements ItemSearchService {
    @Autowired
    private SolrTemplate solrTemplate;

    @Autowired
    private TbItemMapper itemMapper;


    @Override
    public Map search(Map searchMap) {
        System.out.println("========");
        String keywords = (String) searchMap.get("keywords");

        HighlightOptions options = new HighlightOptions();
        options.addField("item_title");
        options.setSimplePrefix("<em style='color:red'>");
        options.setSimplePostfix("</em>");

        SimpleHighlightQuery query = new SimpleHighlightQuery();
        query.setHighlightOptions(options);

        //关键字查询
        Criteria criteria = new Criteria("item_keywords");
        if (keywords != null && !"".equals(keywords)){

            criteria = criteria.is(keywords);
        }
        query.addCriteria(criteria);

        HighlightPage<TbItem> page = solrTemplate.queryForHighlightPage(query, TbItem.class);
        List<TbItem> itemList = page.getContent();

        for (TbItem item : itemList) {
            if (page.getHighlights(item)!=null
                    && page.getHighlights(item).size()>0){
                HighlightEntry.Highlight highlight =
                        page.getHighlights(item).get(0);
                List<String> snipplets = highlight.getSnipplets();
                if (snipplets!=null && snipplets.size()>0){
                    item.setTitle(snipplets.get(0));
                }
            }
        }

        String category = (String) searchMap.get("category");
        if (category != null && !"".equals(category)){
            Criteria filterCriteria = new Criteria("item_category").is(category);
            SimpleFilterQuery filterQuery = new SimpleFilterQuery(filterCriteria);
            query.addFilterQuery(filterQuery);
        }

        String brand = (String) searchMap.get("brand");
        if (brand != null && !"".equals(brand)){
            Criteria filterCriteria = new Criteria("item_brand").is(brand);
            SimpleFilterQuery filterQuery = new SimpleFilterQuery(filterCriteria);
            query.addFilterQuery(filterQuery);
        }

        String price = (String) searchMap.get("price");
        if (price != null && !"".equals(price)){
            String[] prices = price.split("-");
            if (!prices[0].equals("0")){
                Criteria filterCriteria = new Criteria("item_price").greaterThanEqual(prices[0]);
                SimpleFilterQuery filterQuery = new SimpleFilterQuery(filterCriteria);
                query.addFilterQuery(filterQuery);
            }
            if (!prices[1].equals("*")){
                Criteria filterCriteria = new Criteria("item_price").lessThanEqual(prices[1]);
                SimpleFilterQuery filterQuery = new SimpleFilterQuery(filterCriteria);
                query.addFilterQuery(filterQuery);
            }
        }


        Map<String,String> specMap = (Map<String, String>) searchMap.get("spec");
        if (specMap != null){
            Set<String> specKey = specMap.keySet();
            for (String key : specKey) {
                Criteria filterCriteria = new Criteria("item_spec_" + key).is(specMap.get(key));
                SimpleFilterQuery filterQuery = new SimpleFilterQuery(filterCriteria);
                query.addFilterQuery(filterQuery);
            }
        }

        String sort = (String) searchMap.get("sort");
        if (sort != null && !sort.equals("")){
            if ("ASC".equals(sort)){
                Sort orders = new Sort(Sort.Direction.ASC, "item_price");
                query.addSort(orders);
            }
            if ("DESC".equals(sort)){
                Sort orders = new Sort(Sort.Direction.DESC, "item_price");
                query.addSort(orders);
            }
        }

        Integer pageNo = (Integer) searchMap.get("pageNo");
        if (pageNo == null){
            pageNo = 1;
        }
        Integer pageSize = (Integer) searchMap.get("pageSize");// 每页记录数
        if (pageSize == null) {
            pageSize = 10;// 默认10
        }
        query.setOffset((pageNo -1)*pageSize);
        query.setRows(pageSize);

        HashMap resultMap = new HashMap();
        resultMap.put("rows", page.getContent());
        resultMap.put("total", page.getTotalElements());

        return resultMap;
    }

    @Override
    public void importItems(Long[] ids) {
        TbItemExample example = new TbItemExample();
        example.createCriteria().andGoodsIdIn(Arrays.asList(ids));
        List<TbItem> itemList = itemMapper.selectByExample(example);
        solrTemplate.saveBeans(itemList);
        solrTemplate.commit();
    }

    @Override
    public void removeItems(Long[] ids) {
        TbItemExample example = new TbItemExample();
        example.createCriteria().andGoodsIdIn(Arrays.asList(ids));
        List<TbItem> itemList = itemMapper.selectByExample(example);
        for (TbItem tbItem : itemList) {
            solrTemplate.deleteById(tbItem.getId().toString());
        }
    }


}
