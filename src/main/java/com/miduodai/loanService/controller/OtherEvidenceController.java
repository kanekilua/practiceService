package com.miduodai.loanService.controller;

import com.miduodai.loanService.annotation.Authorization;
import com.miduodai.loanService.beans.entity.OtherEvidence;
import com.miduodai.loanService.beans.model.JsonResult;
import com.miduodai.loanService.service.IOtherEvidenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: Kane
 * @Description:
 * @Date: Create in 下午2:15 18-1-10
 */
@RestController
@RequestMapping ("/otherEvidence")
@CrossOrigin("*")
public class OtherEvidenceController {

    @Autowired
    private IOtherEvidenceService iOtherEvidenceService;

    @PostMapping
    @Authorization
    public JsonResult insertOtherEvidence (@RequestBody @Valid OtherEvidence otherEvidence) {
        JsonResult jsonResult = new JsonResult();
        boolean success;
        Map dataMap = new HashMap();
        String message;
        int userId = iOtherEvidenceService.insertOtherEvidence(otherEvidence);
        if(userId > 0) {
            success = true;
            dataMap.put("userId",userId);
            message = "添加其他资料成功!";
        }else {
            success = false;
            message = "添加其他资料失败";
        }
        jsonResult.setSuccess(success);
        jsonResult.setData(dataMap);
        jsonResult.setMessage(message);
        return jsonResult;
    }
}
