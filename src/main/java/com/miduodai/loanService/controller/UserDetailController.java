package com.miduodai.loanService.controller;


import com.miduodai.loanService.annotation.Authorization;
import com.miduodai.loanService.beans.entity.UserDetail;
import com.miduodai.loanService.beans.model.JsonResult;
import com.miduodai.loanService.service.IUserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: Kane
 * @Description:
 * @Date: Create in 上午11:18 18-1-10
 */
@RestController
@RequestMapping("/userDetail")
@CrossOrigin("*")
public class UserDetailController {

    @Autowired
    private IUserDetailService iUserDetailService;

    @PostMapping
    @Authorization
    public JsonResult insertUserDetail(@RequestBody @Valid UserDetail userDetail){
        JsonResult jsonResult = new JsonResult();
        boolean success;
        Map dataMap = new HashMap();
        String message;
        int userId = iUserDetailService.insertUserDetail(userDetail);
        if(userId > 0) {
            success = true;
            dataMap.put("userId",userId);
            message = "添加个人信息成功!";
        }else {
            success = false;
            message = "添加个人信息失败";
        }
        jsonResult.setSuccess(success);
        jsonResult.setData(dataMap);
        jsonResult.setMessage(message);
        return jsonResult;
    }
}
