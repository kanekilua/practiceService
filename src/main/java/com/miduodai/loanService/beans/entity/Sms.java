package com.miduodai.loanService.beans.entity;

/**
 * @Author: Kane
 * @Description:
 * @Date: Create in 上午9:54 18-1-9
 */
public class Sms {
    //手机号码，多个号码如13800000000,13800000001,13800000002
    private String phone;

    private String codeValue ;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCodeValue() {
        return codeValue;
    }

    public void setCodeValue(String codeValue) {
        this.codeValue = codeValue;
    }
}
