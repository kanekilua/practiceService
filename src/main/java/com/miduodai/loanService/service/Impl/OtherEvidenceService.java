package com.miduodai.loanService.service.Impl;

import com.miduodai.loanService.beans.entity.OtherEvidence;
import com.miduodai.loanService.dao.OtherEvidenceMapper;
import com.miduodai.loanService.service.IOtherEvidenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: Kane
 * @Description:
 * @Date: Create in 下午2:16 18-1-10
 */
@Service
public class OtherEvidenceService implements IOtherEvidenceService{

    @Autowired
    private OtherEvidenceMapper otherEvidenceMapper;


    @Override
    public int insertOtherEvidence(OtherEvidence otherEvidence) {
        int result = -1;
        int flag = otherEvidenceMapper.insertSelective(otherEvidence);
        if(flag != -1) {
            result = otherEvidence.getUsersId();
        }
        return result;
    }
}
