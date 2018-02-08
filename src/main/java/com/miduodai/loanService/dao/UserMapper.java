package com.miduodai.loanService.dao;

import com.miduodai.loanService.beans.entity.User;

import java.util.List;

public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    User selectByPhone(String phone);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}