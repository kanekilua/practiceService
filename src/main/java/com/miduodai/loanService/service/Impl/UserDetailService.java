package com.miduodai.loanService.service.Impl;

import com.miduodai.loanService.beans.entity.UserDetail;
import com.miduodai.loanService.dao.UserDetailMapper;
import com.miduodai.loanService.service.IUserDetailService;
import com.miduodai.loanService.util.SerialNumberUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: Kane
 * @Description:
 * @Date: Create in 上午11:19 18-1-10
 */
@Service
public class UserDetailService implements IUserDetailService{

    @Autowired
    private UserDetailMapper userDetailMapper;

    @Override
    public int insertUserDetail(UserDetail userDetail) {
        int result = -1;
        String recommendCode = SerialNumberUtil.toSerialNumber(userDetail.getUsersId());
        userDetail.setRecommendCode(recommendCode);
        int flag = userDetailMapper.insertSelective(userDetail);
        if(flag != -1) {
            result = userDetail.getUsersId();
        }
        return result;
    }
}
