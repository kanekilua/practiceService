package com.miduodai.loanService.service.Impl;

import com.miduodai.loanService.beans.entity.UserRelative;
import com.miduodai.loanService.dao.UserRelativeMapper;
import com.miduodai.loanService.service.IUserRelativeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: Kane
 * @Description:
 * @Date: Create in 下午2:04 18-1-10
 */
@Service
public class UserRelativeService implements IUserRelativeService {

    @Autowired
    private UserRelativeMapper userRelativeMapper;

    @Override
    public int insertUserRelative(UserRelative userRelative) {
        int result = -1;
        int flag = userRelativeMapper.insertSelective(userRelative);
        if(flag != -1) {
            result = userRelative.getUsersId();
        }
        return result;
    }
}
