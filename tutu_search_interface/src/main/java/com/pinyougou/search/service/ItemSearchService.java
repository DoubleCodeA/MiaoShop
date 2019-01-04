package com.pinyougou.search.service;

import com.pinyougou.pojo.TbItem;

import java.util.List;
import java.util.Map;

public interface ItemSearchService {
    public Map search(Map searchMap);
    public void importItems(Long[] ids);
    public void removeItems(Long[] ids);
}
