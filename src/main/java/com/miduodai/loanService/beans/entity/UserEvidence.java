package com.miduodai.loanService.beans.entity;

import java.io.Serializable;

public class UserEvidence implements Serializable {
    private Integer id;

    private Integer usersId;

    private String frontIdPicture;

    private String backIdPicture;

    private String holdIdPicture;

    private String bankCardPicture;

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

    public String getFrontIdPicture() {
        return frontIdPicture;
    }

    public void setFrontIdPicture(String frontIdPicture) {
        this.frontIdPicture = frontIdPicture == null ? null : frontIdPicture.trim();
    }

    public String getBackIdPicture() {
        return backIdPicture;
    }

    public void setBackIdPicture(String backIdPicture) {
        this.backIdPicture = backIdPicture == null ? null : backIdPicture.trim();
    }

    public String getHoldIdPicture() {
        return holdIdPicture;
    }

    public void setHoldIdPicture(String holdIdPicture) {
        this.holdIdPicture = holdIdPicture == null ? null : holdIdPicture.trim();
    }

    public String getBankCardPicture() {
        return bankCardPicture;
    }

    public void setBankCardPicture(String bankCardPicture) {
        this.bankCardPicture = bankCardPicture == null ? null : bankCardPicture.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", usersId=").append(usersId);
        sb.append(", frontIdPicture=").append(frontIdPicture);
        sb.append(", backIdPicture=").append(backIdPicture);
        sb.append(", holdIdPicture=").append(holdIdPicture);
        sb.append(", bankCardPicture=").append(bankCardPicture);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}