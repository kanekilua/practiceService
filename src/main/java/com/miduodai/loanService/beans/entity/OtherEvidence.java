package com.miduodai.loanService.beans.entity;

import java.io.Serializable;

public class OtherEvidence implements Serializable {
    private Integer id;

    private Integer usersId;

    private String city;

    private String gongjijinAccount;

    private String gongjijinPwd;

    private String xuexinAccount;

    private String xuexinPwd;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUsersId() {
        return usersId;
    }

    public void setUsersId(Integer usersId) {
        this.usersId = usersId;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city == null ? null : city.trim();
    }

    public String getGongjijinAccount() {
        return gongjijinAccount;
    }

    public void setGongjijinAccount(String gongjijinAccount) {
        this.gongjijinAccount = gongjijinAccount == null ? null : gongjijinAccount.trim();
    }

    public String getGongjijinPwd() {
        return gongjijinPwd;
    }

    public void setGongjijinPwd(String gongjijinPwd) {
        this.gongjijinPwd = gongjijinPwd == null ? null : gongjijinPwd.trim();
    }

    public String getXuexinAccount() {
        return xuexinAccount;
    }

    public void setXuexinAccount(String xuexinAccount) {
        this.xuexinAccount = xuexinAccount == null ? null : xuexinAccount.trim();
    }

    public String getXuexinPwd() {
        return xuexinPwd;
    }

    public void setXuexinPwd(String xuexinPwd) {
        this.xuexinPwd = xuexinPwd == null ? null : xuexinPwd.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", usersId=").append(usersId);
        sb.append(", city=").append(city);
        sb.append(", gongjijinAccount=").append(gongjijinAccount);
        sb.append(", gongjijinPwd=").append(gongjijinPwd);
        sb.append(", xuexinAccount=").append(xuexinAccount);
        sb.append(", xuexinPwd=").append(xuexinPwd);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}