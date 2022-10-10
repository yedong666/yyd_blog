package com.yyd.blog_back.common.util;

import org.aspectj.lang.JoinPoint;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.Date;

public class PrintfMessage {
    public static void logRequest(String controllerName) {
        RequestAttributes requestAttributes;//这个RequestContextHolder是Springmvc提供来获得请求的东西
        requestAttributes = RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = ((ServletRequestAttributes)requestAttributes).getRequest();
        System.out.println("----------------------------------------------------------------------------------------");
        // 记录下请求内容
        System.out.println("REQUEST API NAME : " + controllerName);
        System.out.println("DATE : " + new Date());
        System.out.println("URL : " + request.getRequestURL().toString());
        System.out.println("HTTP_METHOD : " + request.getMethod());
        System.out.println("IP : " + request.getRemoteAddr());
        System.out.println("----------------------------------------------------------------------------------------");
        System.out.println();
    }
}
