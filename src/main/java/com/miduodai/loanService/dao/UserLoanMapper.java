package com.miduodai.loanService.dao;

import com.miduodai.loanService.beans.entity.UserLoan;

import java.util.List;

public interface UserLoanMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserLoan record);

    int insertSelective(UserLoan record);

    UserLoan selectByPrimaryKey(Integer id);

    List<UserLoan> selectByUserId (Integer userId);

    int updateByPrimaryKeySelective(UserLoan record);

    int updateByPrimaryKey(UserLoan record);
}