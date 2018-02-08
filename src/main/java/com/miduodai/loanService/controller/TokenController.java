package com.miduodai.loanService.controller;

import com.miduodai.loanService.annotation.Authorization;
import com.miduodai.loanService.annotation.CurrentUser;
import com.miduodai.loanService.beans.entity.TokenModel;
import com.miduodai.loanService.beans.entity.User;
import com.miduodai.loanService.beans.model.JsonResult;
import com.miduodai.loanService.service.ITokenService;
import com.miduodai.loanService.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: Kane
 * @Description:
 * @Date: Create in 上午11:06 18-1-17
 */
@RestController
@RequestMapping("/token")
@CrossOrigin("*")
public class TokenController {

    @Autowired
    private IUserService iUserService;

    @Autowired
    private ITokenService iTokenService;

    @PostMapping
    public JsonResult login (@RequestBody @Valid User user) {
        JsonResult jsonResult = new JsonResult();
        boolean success;
        Map data = new HashMap();
        String message;

        if(user.getPhone() == null || user.getPhone().equals("") ){
            success = false;
            message = "手机号码不能为空!!";
        }else if (user.getPassword() == null || user.getPassword().equals("") ){
            success = false;
            message = "密码不能为空!!";
        }else {
            User existUser = iUserService.getUserByPhone(user.getPhone());
            if(existUser.getPassword().equals(user.getPassword())) {
                TokenModel tokenModel = iTokenService.createToken(user.getPhone());
                String token = tokenModel.getPhone() + "_" + tokenModel.getToken();
                success = true;
                data.put("token",token);
                message = "登录成功!!";
            }else {
                success = false;
                message = "密码错误!!";
            }
        }

        jsonResult.setSuccess(success);
        jsonResult.setData(data);
        jsonResult.setMessage(message);
        return jsonResult;
    }

    @DeleteMapping
    @Authorization
    public JsonResult logout (@CurrentUser User user) {
        JsonResult jsonResult = new JsonResult();
        boolean success;
        Map data = new HashMap();
        String message;
        boolean flag = iTokenService.deleteToken(user.getPhone());

        if(flag) {
            success = true;
            message = "登出成功!!";
        }else {
            success = false;
            message = "登出失败!!";
        }
        jsonResult.setSuccess(success);
        jsonResult.setData(data);
        jsonResult.setMessage(message);
        return jsonResult;
    }


    @PostMapping("/checkToken")
    public JsonResult checkToken (@RequestBody @Valid TokenModel tokenModel) {
        boolean success;
        Map data = new HashMap();
        String message;
        boolean checkFlag = iTokenService.checkToken(tokenModel);
        if(checkFlag) {
            success = true;
            message = "token验证正确!";
        }else {
            success = false;
            message = "token验证失败";
        }
        return new JsonResult(success,data,message);
    }

}
