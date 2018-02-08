package com.miduodai.loanService.beans.entity;

import java.io.Serializable;

public class UserRelative implements Serializable {
    private Integer id;

    private Integer usersId;

    private String fatherName;

    private String fatherPhone;

    private String motherName;

    private String motherPhone;

    private String friendName;

    private String friendPhone;

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

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName == null ? null : fatherName.trim();
    }

    public String getFatherPhone() {
        return fatherPhone;
    }

    public void setFatherPhone(String fatherPhone) {
        this.fatherPhone = fatherPhone == null ? null : fatherPhone.trim();
    }

    public String getMotherName() {
        return motherName;
    }

    public void setMotherName(String motherName) {
        this.motherName = motherName == null ? null : motherName.trim();
    }

    public String getMotherPhone() {
        return motherPhone;
    }

    public void setMotherPhone(String motherPhone) {
        this.motherPhone = motherPhone == null ? null : motherPhone.trim();
    }

    public String getFriendName() {
        return friendName;
    }

    public void setFriendName(String friendName) {
        this.friendName = friendName == null ? null : friendName.trim();
    }

    public String getFriendPhone() {
        return friendPhone;
    }

    public void setFriendPhone(String friendPhone) {
        this.friendPhone = friendPhone == null ? null : friendPhone.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", usersId=").append(usersId);
        sb.append(", fatherName=").append(fatherName);
        sb.append(", fatherPhone=").append(fatherPhone);
        sb.append(", motherName=").append(motherName);
        sb.append(", motherPhone=").append(motherPhone);
        sb.append(", friendName=").append(friendName);
        sb.append(", friendPhone=").append(friendPhone);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}