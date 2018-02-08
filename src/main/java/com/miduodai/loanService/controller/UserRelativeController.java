package com.miduodai.loanService.controller;

import com.miduodai.loanService.annotation.Authorization;
import com.miduodai.loanService.beans.entity.UserRelative;
import com.miduodai.loanService.beans.model.JsonResult;
import com.miduodai.loanService.service.IUserRelativeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: Kane
 * @Description:
 * @Date: Create in 下午1:50 18-1-10
 */
@RestController
@RequestMapping ("/userRelative")
@CrossOrigin("*")
public class UserRelativeController {

    @Autowired
    private IUserRelativeService iUserRelativeService;

    @PostMapping
    @Authorization
    public JsonResult insertUserRelative (@RequestBody @Valid UserRelative userRelative) {
        JsonResult jsonResult = new JsonResult();
        boolean success;
        Map dataMap = new HashMap();
        String message;
        int userId = iUserRelativeService.insertUserRelative(userRelative);
        if(userId > 0) {
            success = true;
            dataMap.put("userId",userId);
            message = "添加亲友信息成功!";
        }else {
            success = false;
            message = "添加亲友信息失败";
        }
        jsonResult.setSuccess(success);
        jsonResult.setData(dataMap);
        jsonResult.setMessage(message);
        return jsonResult;
    }
}
