package com.miduodai.loanService.dao;

import com.miduodai.loanService.beans.entity.UserRelative;

public interface UserRelativeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserRelative record);

    int insertSelective(UserRelative record);

    UserRelative selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserRelative record);

    int updateByPrimaryKey(UserRelative record);
}