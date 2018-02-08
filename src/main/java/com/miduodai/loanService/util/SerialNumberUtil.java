package com.miduodai.loanService.util;

import java.util.Random;

/**
 * @Author: Kane
 * @Description:
 * @Date: Create in 下午1:57 18-1-11
 */
public class SerialNumberUtil {

    /**自定义进制(0,1没有加入,容易与o,l混淆)*/
    private static char[] r = new char[] { 'Q', 'w', 'E', '8', 'a', 'S', '2', 'd', 'Z', 'x', '9', 'c', '7', 'p', 'O', '5', 'i', 'K', '3', 'm', 'j', 'U', 'f', 'r', '4', 'V', 'y', 'L', 't', 'N', '6', 'b', 'g', 'H' };
    /**自动补全组(不能与自定义进制有重复)*/
    private static char[] b = new char[] { 'q', 'W', 'e', 'A', 's', 'D', 'z', 'X', 'C', 'P', 'o', 'I', 'k', 'M', 'J', 'u', 'F', 'R', 'v', 'Y', 'T', 'n', 'B', 'G', 'h' };
    /**进制长度*/
    private static int l = r.length;
    /**序列最小长度*/
    private static int s = 7;
    public static String toSerialNumber(int num)
    {
        char[] buf = new char[32];
        int charPos = 32;
        while ((num / l) > 0)
        {
            buf[--charPos] = r[(int)(num % l)];
            num /= l;
        }
        buf[--charPos] = r[(int)(num % l)];
        String str = new String(buf, charPos, (32 - charPos));
        //不够长度的自动随机补全
        if (str.length()< s)
        {
            StringBuilder sb = new StringBuilder();
            Random rnd = new Random();
            for (int i = 0; i < s - str.length(); i++)
            {
                sb.append(b[rnd.nextInt(24)]);
            }
            str += sb.toString();
        }
        return str;
    }
}
