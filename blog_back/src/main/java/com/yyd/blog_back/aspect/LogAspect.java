package com.yyd.blog_back.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

@Aspect
@Component
public class LogAspect {
    private final Logger logger = LoggerFactory.getLogger(LogAspect.class);

    @Pointcut("execution(public * com.yyd.blog_back.controller.*.*(..))")//切入点描述 这个是controller包的切入点
    public void controllerLog(){}//签名，可以理解成这个切入点的一个名称

    @Before("controllerLog()") //在切入点的方法run之前要干的
    public void logBeforeController(JoinPoint joinPoint) {
        RequestAttributes requestAttributes;//这个RequestContextHolder是Springmvc提供来获得请求的东西
        requestAttributes = RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = ((ServletRequestAttributes)requestAttributes).getRequest();
        System.out.println("--------------------");
        // 记录下请求内容
        logger.info("URL : " + request.getRequestURL().toString());
        logger.info("HTTP_METHOD : " + request.getMethod());
        logger.info("IP : " + request.getRemoteAddr());
        logger.info("THE ARGS OF THE CONTROLLER : " + Arrays.toString(joinPoint.getArgs()));
        //下面这个getSignature().getDeclaringTypeName()是获取包+类名的,然后后面的joinPoint.getSignature.getName()获取了方法名
        logger.info("CLASS_METHOD : " + joinPoint.getSignature().getDeclaringTypeName() +
                "." + joinPoint.getSignature().getName());
    }
}
