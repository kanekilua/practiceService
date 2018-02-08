package com.miduodai.loanService.util;

import java.util.Random;

/**
 * @Author: Kane
 * @Description:
 * @Date: Create in 上午11:00 18-1-9
 */
public class CommonUtil {
    public String randomCode () {
        String result = "";
        Random random = new Random();
        for (int i=0;i<6;++i){
            result += random.nextInt(10);
        }
        return result;
    }

}
