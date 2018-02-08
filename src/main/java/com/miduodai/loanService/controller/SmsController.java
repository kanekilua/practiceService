package com.miduodai.loanService.controller;

import com.miduodai.loanService.beans.entity.Sms;
import com.miduodai.loanService.beans.entity.TokenModel;
import com.miduodai.loanService.beans.model.JsonResult;
import com.miduodai.loanService.service.ISmsService;
import com.miduodai.loanService.service.ITokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: Kane
 * @Description:
 * @Date: Create in 上午10:02 18-1-9
 */
@RestController
@RequestMapping("/sms")
@CrossOrigin("*")
public class SmsController {

    @Autowired
    private ISmsService iSmsService;

    @Autowired
    private ITokenService iTokenService;

    @PostMapping
    public JsonResult sendMessage(@RequestBody @Valid Sms sms , HttpServletRequest request){
        JsonResult jsonResult = new JsonResult();
        Map dataMap = new HashMap();
        boolean flag = iSmsService.sendMessage(sms,request);
        jsonResult.setSuccess(flag);
        jsonResult.setData(dataMap);
        if(flag){
            jsonResult.setMessage("发送短信成功!");
        }else {
            jsonResult.setMessage("发送短信失败!");
        }
        return jsonResult;
    }

    @PostMapping( value = "/validate" )
    public JsonResult validateCode (@RequestBody @Valid Sms sms , HttpServletRequest request){
        JsonResult jsonResult = new JsonResult();
        boolean success;
        Map dataMap = new HashMap();
        String message;
        int validate = iSmsService.validateCode(sms , request);
        if(validate == 1) {
            TokenModel tokenModel = iTokenService.createToken(sms.getPhone());
            String token = tokenModel.getPhone() + "_" + tokenModel.getToken();

            success = true;
            dataMap.put("token",token);
            message = "验证码正确!";
        }else if (validate == 2) {
            success = false;
            message = "验证码已失效!";
        }else{
            success = false;
            message = "验证码错误,请重新输入!";
        }
        jsonResult.setSuccess(success);
        jsonResult.setData(dataMap);
        jsonResult.setMessage(message);
        return jsonResult;

    }
}
