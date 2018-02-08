package com.miduodai.loanService.service.Impl;

import com.miduodai.loanService.beans.entity.UserEvidence;
import com.miduodai.loanService.dao.UserEvidenceMapper;
import com.miduodai.loanService.service.IUserEvidenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: Kane
 * @Description:
 * @Date: Create in 下午2:24 18-1-12
 */
@Service
public class UserEvidenceService implements IUserEvidenceService{

    @Autowired
    private UserEvidenceMapper userEvidenceMapper;

    @Override
    public int insertUserEvidence(UserEvidence userEvidence) {
        int result = -1;
        int flag = userEvidenceMapper.insertSelective(userEvidence);
        if(flag != -1) {
            result = userEvidence.getUsersId();
        }
        return result;
    }
}
