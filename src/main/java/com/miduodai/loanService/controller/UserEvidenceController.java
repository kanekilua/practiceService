package com.miduodai.loanService.controller;

import com.miduodai.loanService.annotation.Authorization;
import com.miduodai.loanService.beans.entity.UserEvidence;
import com.miduodai.loanService.beans.model.JsonResult;
import com.miduodai.loanService.service.IUserEvidenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.websocket.server.PathParam;
import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: Kane
 * @Description:
 * @Date: Create in 下午2:22 18-1-12
 */
@RestController
@CrossOrigin("*")
public class UserEvidenceController {

    @Autowired
    private IUserEvidenceService iUserEvidenceService;

    @Value ("${upload-path}")
    private String uploadPath;

    // 单文件上传
    @PostMapping ("user/{userId}/userEvidence")
    @Authorization
    public JsonResult fileUpload (@PathVariable(value="userId") int userId, @PathParam("type") int fileType,@RequestParam("file") MultipartFile file) {
        boolean success ;
        Map data = new HashMap();
        String message;

        if(file.isEmpty()){
            success = false;
            message = "文件不能为空!";
            return new JsonResult(success,data,message);
        }

        String fileName = file.getOriginalFilename();
        String filePath = uploadPath + "miduodai-" + userId + "/" + fileName;
        File dest = new File(filePath);
        if (!dest.getParentFile().exists()) {
            dest.getParentFile().mkdirs();
        }
        try {
            file.transferTo(dest);

            UserEvidence userEvidence = new UserEvidence();
            userEvidence.setUsersId(userId);
            if(fileType == 1){
                userEvidence.setFrontIdPicture(filePath);
            }else if(fileType == 2){
                userEvidence.setBackIdPicture(filePath);
            }else if (fileType == 3){
                userEvidence.setHoldIdPicture(filePath);
            }else {
                userEvidence.setBankCardPicture(filePath);
            }

            int insertFlag = iUserEvidenceService.insertUserEvidence(userEvidence);
            if(insertFlag != -1 ) {
                success = true;
                data.put("url",filePath);
                message = "上传文件成功!";
            }else {
                success = false;
                message = "上传文件失败!";
            }

            return new JsonResult(success,data,message);
        } catch (IllegalStateException e) {
            e.printStackTrace();
            success = false;
            message = "上传文件失败!";
            return new JsonResult(success,data,message);
        } catch (IOException e) {
            e.printStackTrace();
            success = false;
            message = "上传文件失败!";
            return new JsonResult(success,data,message);
        }
    }

    //多文件上传
//    @PostMapping ("user/{userId}/userEvidence")
//    @Authorization
//    public JsonResult handleFileUpload(@PathVariable(value="userId") int userId, HttpServletRequest request) {
//        JsonResult jsonResult = new JsonResult();
//        boolean success;
//        Map data = new HashMap();
//        String message;
//
//        UserEvidence userEvidence = new UserEvidence();
//        userEvidence.setUsersId(userId);
//
//        String filePath = uploadPath + "miduodai-" + userId + "/";
//        List<MultipartFile> files = ((MultipartHttpServletRequest) request)
//                .getFiles("file");
//        MultipartFile file;
//        BufferedOutputStream stream;
//        for (int i = 0; i < files.size(); ++i) {
//            file = files.get(i);
//            if (!file.isEmpty()) {
//                try {
//                    String savePath = filePath + file.getOriginalFilename();
//                    byte[] bytes = file.getBytes();
//
//                    File dest = new File(savePath);
//                    if(!dest.getParentFile().exists()){
//                        dest.getParentFile().mkdirs();
//                    }
//
//                    stream = new BufferedOutputStream(new FileOutputStream(dest));
//                    stream.write(bytes);
//                    stream.close();
//
//                    if(i == 0) {
//                        userEvidence.setFrontIdPicture(savePath);
//                    }else if (i == 1) {
//                        userEvidence.setBackIdPicture(savePath);
//                    }else if (i ==2) {
//                        userEvidence.setHoldIdPicture(savePath);
//                    }else if (i ==3) {
//                        userEvidence.setBankCardPicture(savePath);
//                    }
//                } catch (Exception e) {
//                    success = false;
//                    message = e.getMessage();
//                    jsonResult.setSuccess(success);
//                    jsonResult.setData(data);
//                    jsonResult.setMessage(message);
//                    return jsonResult;
//                }
//            } else {
//                success = false;
//                message = "文件不能为空!!";
//                jsonResult.setSuccess(success);
//                jsonResult.setData(data);
//                jsonResult.setMessage(message);
//                return jsonResult;
//            }
//        }
//
//        int resultFlag = iUserEvidenceService.insertUserEvidence(userEvidence);
//        if(resultFlag > 0) {
//            success = true;
//            data.put("userId",userId);
//            message = "添加照片资料成功!";
//        }else {
//            success = false;
//            message = "添加照片资料失败";
//        }
//
//        jsonResult.setSuccess(success);
//        jsonResult.setData(data);
//        jsonResult.setMessage(message);
//        return jsonResult;
//    }

}
