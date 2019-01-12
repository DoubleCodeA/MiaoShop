package com.pinyougou.pay.service.impl;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.dubbo.config.annotation.Service;
import com.github.wxpay.sdk.WXPayUtil;
import com.pinyougou.order.service.OrderService;
import com.pinyougou.pay.service.WeixinPayService;
import org.springframework.beans.factory.annotation.Value;
import util.HttpClient;


import java.util.HashMap;
import java.util.Map;

@Service
public class WeixinPayServiceImpl implements WeixinPayService {

    @Value("{appid")
    private String appid;
    @Value("${partner}")
    private String partner;
    @Value("${partnerkey}")


    @Override
    public Map createNative(String out_trade_no, String total_fee) {
        HashMap<String, String> param = new HashMap<>();
        param.put("appid", appid);
        param.put("mch_id", partner);
        param.put("nonce_str", WXPayUtil.generateNonceStr());
        param.put("body", "兔兔购");
        param.put("out_trade_no", out_trade_no);
        param.put("total_fee", total_fee);
        param.put("spbill_create_ip", "127.0.0.1");
        param.put("notif_url", "http://test.itcast.cn");
        param.put("trade_type", "NATIVE");
        try {
            String xmlParam = WXPayUtil.generateSignedXml(param, partner);
            HttpClient client = new HttpClient("https://api.mch.weixin.qq.com/pay/unifiedorder");
            client.setHttps(true);
            client.setXmlParam(xmlParam);
            client.post();
            String result = client.getContent();
            Map<String,String> resultMap = WXPayUtil.xmlToMap(result);
            Map<String,String> map = new HashMap<>();
            map.put("code_url", resultMap.get("code_url"));
            map.put("total_fee", total_fee);
            map.put("out_trade_no", out_trade_no);
            return map;
        } catch (Exception e) {
            e.printStackTrace();
            return new HashMap();
        }

    }

    @Override
    public Map queryPayStatus(String out_trade_no) {
        Map param = new HashMap();
        param.put("appid", appid);
        param.put("mch_id", partner);
        param.put("out_trade_no", out_trade_no);
        param.put("nonce_str", WXPayUtil.generateNonceStr());
        String url = "https://api.mch.weixin.qq.com/pay/orderquery";

        try {
            String xmlParam = WXPayUtil.generateSignedXml(param, partner);
            HttpClient httpClient = new HttpClient(url);
            httpClient.setHttps(true);
            httpClient.setXmlParam(xmlParam);
            httpClient.post();
            String result = httpClient.getContent();
            Map<String, String> map = WXPayUtil.xmlToMap(result);
            return map;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
