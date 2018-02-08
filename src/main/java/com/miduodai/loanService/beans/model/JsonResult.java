package com.miduodai.loanService.beans.model;

/**
 * @Author: Kane
 * @Description:
 * @Date: Create in 下午1:51 18-1-8
 */
public class JsonResult<T> {
    private boolean success;
    private T data;
    private String message;

    public JsonResult () {}

    public JsonResult (boolean success,T data , String message){
        this.setSuccess(success);
        this.setData(data);
        this.setMessage(message);
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
