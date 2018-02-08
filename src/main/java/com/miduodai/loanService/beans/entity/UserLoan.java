package com.miduodai.loanService.beans.entity;

import java.io.Serializable;
import java.util.Date;

public class UserLoan implements Serializable {
    private Integer id;

    private Integer usersId;

    private Integer funds;

    private Integer times;

    private Date loanDate;

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

    public Integer getFunds() {
        return funds;
    }

    public void setFunds(Integer funds) {
        this.funds = funds;
    }

    public Integer getTimes() {
        return times;
    }

    public void setTimes(Integer times) {
        this.times = times;
    }

    public Date getLoanDate() {
        return loanDate;
    }

    public void setLoanDate(Date loanDate) {
        this.loanDate = loanDate;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", usersId=").append(usersId);
        sb.append(", funds=").append(funds);
        sb.append(", times=").append(times);
        sb.append(", loanDate=").append(loanDate);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}