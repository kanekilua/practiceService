package com.miduodai.loanService.service.Impl;

import com.miduodai.loanService.beans.entity.User;
import com.miduodai.loanService.dao.UserMapper;
import com.miduodai.loanService.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: Kane
 * @Description:
 * @Date: Create in 下午2:52 18-1-8
 */
@Service
public class UserService implements IUserService{

    @Autowired
    private UserMapper userMapper;

    @Override
    public int insertUser(User user) {
        int result = 0;
        if(userMapper.insert(user) > 0){
            result = user.getId();
        }
        return result;
    }

    @Override
    public User getUserById(int userId) {
        User result = userMapper.selectByPrimaryKey(userId);
        return result;
    }

    @Override
    public User getUserByPhone(String phone) {
        User result = userMapper.selectByPhone(phone);
        return result;
    }

    @Override
    public int updateUser(User user) {
        int result = -1;
        int flag = userMapper.updateByPrimaryKeySelective(user);
        if(flag != -1) {
            result = user.getId();
        }
        return result;
    }
}
