package com.tfswufe.resume.utils;

import java.util.UUID;

public class RandomUtil {

    /**
     * 生成指定长度的随机的字符串
     * @param len
     * @return
     */
    public static String genString(int len){
        return UUID.randomUUID().toString().replaceAll("-","").substring(0,len);
    }
}
