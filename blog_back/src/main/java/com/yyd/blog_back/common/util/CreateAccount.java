package com.yyd.blog_back.common.util;

import java.util.Date;

/**
 * 根据日期生成账号
 */
public class CreateAccount {
    public static String createAccount(){
        Date date = new Date();
        String[] strs1 = (date.toString()).split(" ");
        String[] strs2 = (strs1[3]).split(":");
        return strs1[5] + strs2[0] + strs2[1] + strs2[2] + strs1[2];
    }
}
