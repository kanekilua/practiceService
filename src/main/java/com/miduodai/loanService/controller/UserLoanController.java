package com.miduodai.loanService.controller;

import com.miduodai.loanService.beans.entity.UserLoan;
import com.miduodai.loanService.beans.model.JsonResult;
import com.miduodai.loanService.service.IUserLoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: Kane
 * @Description:
 * @Date: Create in 上午11:25 18-2-6
 */
@RestController
@RequestMapping("/loan")
@CrossOrigin("*")
public class UserLoanController {

    @Autowired
    private IUserLoanService iUserLoanService;

    @PostMapping
    public JsonResult insertUserLoan (@RequestBody @Valid UserLoan userLoan) {
        boolean success;
        Map data = new HashMap();
        String message;

        int insertFlag = iUserLoanService.insertUserLoan(userLoan);
        if ( insertFlag > 0) {
            success = true;
            message = "添加贷款记录成功!";
        }else {
            success = false;
            message = "添加贷款记录失败!";
        }
        return new JsonResult(success,data,message);
    }

}
