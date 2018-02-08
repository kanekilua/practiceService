package com.miduodai.loanService;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


/**
 * Author: Kane
 * Description: 入口
 * Date: Create on 2018/1/4
 */
@SpringBootApplication
@MapperScan(basePackages = "com.miduodai.loanService.dao")
@ComponentScan(basePackages = "com.miduodai.loanService.service")
@ComponentScan(basePackages = "com.miduodai.loanService.interceptor")
@ComponentScan(basePackages = "com.miduodai.loanService.controller")
public class Application {
    public static void main(String args[]) {
        SpringApplication.run(Application.class, args);
    }
}
