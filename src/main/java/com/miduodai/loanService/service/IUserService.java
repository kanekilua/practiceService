package com.miduodai.loanService.service;

import com.miduodai.loanService.beans.entity.User;

/**
 * @Author: Kane
 * @Description:
 * @Date: Create in 下午2:51 18-1-8
 */
public interface IUserService {
    User getUserByPhone (String phone);
    User getUserById (int userId);
    int insertUser (User user);
    int updateUser (User user);
}
