package com.miduodai.loanService.service;

import com.miduodai.loanService.beans.entity.Sms;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author: Kane
 * @Description:
 * @Date: Create in 上午10:10 18-1-9
 */
public interface ISmsService {
    boolean sendMessage(Sms sms, HttpServletRequest request);

    int validateCode(Sms sms, HttpServletRequest request);
}
