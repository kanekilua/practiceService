package com.miduodai.loanService.beans.entity;

import java.io.Serializable;

public class User implements Serializable {
    private Integer id;

    private String phone;

    private String password;

    private String inviterCode;

    private Integer quotaTotal;

    private Integer quotaRemain;

    private static final long serialVersionUID = 1L;
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getInviterCode() {
        return inviterCode;
    }

    public void setInviterCode(String inviterCode) {
        this.inviterCode = inviterCode == null ? null : inviterCode.trim();
    }

    public Integer getQuotaTotal() {
        return quotaTotal;
    }

    public void setQuotaTotal(Integer quotaTotal) {
        this.quotaTotal = quotaTotal;
    }

    public Integer getQuotaRemain() {
        return quotaRemain;
    }

    public void setQuotaRemain(Integer quotaRemain) {
        this.quotaRemain = quotaRemain;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", phone=").append(phone);
        sb.append(", password=").append(password);
        sb.append(", inviterCode=").append(inviterCode);
        sb.append(", quotaTotal=").append(quotaTotal);
        sb.append(", quotaRemain=").append(quotaRemain);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}