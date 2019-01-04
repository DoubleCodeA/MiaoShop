package com.pinyougou.sms.controller;

import com.sun.tools.javac.jvm.Code;
import org.jasig.cas.client.session.SingleSignOutFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;
import java.io.Serializable;
import java.util.HashMap;

@Component
public class SmsRegListener implements MessageListener {
    @Autowired
    private SmsController smsController;
    @Override
    public void onMessage(Message message) {
        try {
            ObjectMessage objectMessage = (ObjectMessage) message;
            HashMap<String,String> map = (HashMap) objectMessage.getObject();
            System.out.println(map);
            smsController.sendSms(map.get("phone"), map.get("code"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
