package com.miduodai.loanService.service.Impl;

import com.miduodai.loanService.util.CommonUtil;
import com.miduodai.loanService.util.HttpClientUtil;
import com.miduodai.loanService.beans.entity.Sms;
import com.miduodai.loanService.service.ISmsService;
import org.apache.catalina.Pipeline;
import org.apache.ibatis.jdbc.Null;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @Author: Kane
 * @Description:
 * @Date: Create in 上午10:11 18-1-9
 */
@Service
public class SmsService implements ISmsService{

    @Value("${uid}")
    private String Uid;

    @Value("${key}")
    private String Key;

    @Value("${smsContent}")
    private String smsContent;

    @Override
    public boolean sendMessage(Sms sms, HttpServletRequest request) {
        boolean result;
        HttpClientUtil client = HttpClientUtil.getInstance();
        CommonUtil commonUtil = new CommonUtil();
        String codeValue =  commonUtil.randomCode();
        String messageContent = smsContent + codeValue;
        String phoneNumber = sms.getPhone();

        request.getSession().setAttribute(phoneNumber,codeValue);

        //UTF发送
        int flag = client.sendMsgUtf8(Uid, Key, messageContent,phoneNumber );
        if(flag>0){
            result = true;
        }else{
            result = false;
        }
        return result;
    }

    @Override
    public int validateCode(Sms sms, HttpServletRequest request) {
        int result;
        String correctCode = (String)request.getSession().getAttribute(sms.getPhone());
        try {
            if (correctCode.equals(sms.getCodeValue())) {
                result = 1;
            } else {
                result = 0;
            }
        }catch (NullPointerException e){
            result = 2;
            return result;
        }

        return result;
    }
}
