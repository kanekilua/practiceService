package com.miduodai.loanService.dao;

import com.miduodai.loanService.beans.entity.OtherEvidence;

public interface OtherEvidenceMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(OtherEvidence record);

    int insertSelective(OtherEvidence record);

    OtherEvidence selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(OtherEvidence record);

    int updateByPrimaryKey(OtherEvidence record);
}