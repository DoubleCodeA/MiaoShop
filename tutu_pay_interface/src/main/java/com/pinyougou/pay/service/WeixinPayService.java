package com.pinyougou.pay.service;

import org.springframework.jca.cci.object.MappingRecordOperation;

import java.util.Map;

public interface WeixinPayService {
    public Map createNative(String out_trade_no, String total_fee);

    public Map queryPayStatus(String out_trade_no);
}
