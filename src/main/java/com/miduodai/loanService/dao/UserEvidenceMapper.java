package com.miduodai.loanService.dao;

import com.miduodai.loanService.beans.entity.UserEvidence;

public interface UserEvidenceMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserEvidence record);

    int insertSelective(UserEvidence record);

    UserEvidence selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserEvidence record);

    int updateByPrimaryKey(UserEvidence record);
}