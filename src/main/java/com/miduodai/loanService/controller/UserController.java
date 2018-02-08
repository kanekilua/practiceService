package com.miduodai.loanService.controller;

import com.miduodai.loanService.annotation.Authorization;
import com.miduodai.loanService.beans.entity.User;
import com.miduodai.loanService.beans.model.JsonResult;
import com.miduodai.loanService.service.ISmsService;
import com.miduodai.loanService.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: Kane
 * @Description:
 * @Date: Create in 下午1:53 18-1-8
 */
@RestController
@RequestMapping("/user")
@CrossOrigin("*")
public class UserController {

    @Autowired
    private IUserService iUserService;

    @PostMapping
    public JsonResult insertUser (@RequestBody @Valid User user){
        JsonResult jsonResult = new JsonResult();
        boolean success;
        Map dataMap = new HashMap();
        String message;
        User existUser = iUserService.getUserByPhone(user.getPhone());
        if(existUser ==  null) {
            user.setQuotaTotal(0);
            user.setQuotaRemain(0);
            int userId = iUserService.insertUser(user);
            dataMap.put("userId",userId);
            if(userId > 0){
                success = true;
                message = "该手机可以使用!";
            }else {
                success = false;
                message = "添加用户失败";
            }
        }else{
            boolean flag = existUser.getPassword() != null && existUser.getPassword() != "" && existUser.getQuotaTotal() != 0;
            dataMap.put("userId",existUser.getId());
            if(flag){
                success = true;
                message = "该手机已注册,请直接登录!";
            }else {
                success = true;
                message = "该手机可以使用!";
            }
        }
        jsonResult.setSuccess(success);
        jsonResult.setData(dataMap);
        jsonResult.setMessage(message);
        return jsonResult;
    }

    @PutMapping
    @Authorization
    public JsonResult updateUser (@RequestBody @Valid User user){
        JsonResult jsonResult = new JsonResult();
        boolean success;
        Map dataMap = new HashMap();
        String message;
        int userId = iUserService.updateUser(user);
        dataMap.put("userId",userId);
        if(userId > 0){
            success = true;
            message = "更新用户信息成功!";
        }else {
            success = false;
            message = "更新用户信息失败";
        }

        jsonResult.setSuccess(success);
        jsonResult.setData(dataMap);
        jsonResult.setMessage(message);
        return jsonResult;
    }



}
