package com.yyd.blog_back.common.util;

import java.text.SimpleDateFormat;
import java.util.Date;



public class DateUtil {
    private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

    public static String getTime(){
        return simpleDateFormat.format(new Date());
    }

    public static String getTime(String pattern){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        return simpleDateFormat.format(new Date());
    }

    public static void main(String[] args) {
        System.out.println(DateUtil.getTime("hh:mm"));
    }
}
