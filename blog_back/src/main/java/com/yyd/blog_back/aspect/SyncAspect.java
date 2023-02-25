package com.yyd.blog_back.aspect;

import com.yyd.blog_back.common.annotation.SynchronousData;
import com.yyd.blog_back.common.constValue.SyncAspectConstVal;
import com.yyd.blog_back.service.ControlRecordService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;


/**
 * 在访问某些接口前先同步各存储源(mysql、redis、es)的数据
 * 同步Redis与Mysql数据
 */

@Aspect
@Component
public class SyncAspect {
    @Autowired
    private ControlRecordService controlRecordService;

    @Pointcut("@annotation(com.yyd.blog_back.common.annotation.SynchronousData)")
    public void optRedisPointCut() {}

    @Before(value = "optRedisPointCut()")
    public void saveToMysql(JoinPoint joinPoint){

        // 获取切入点方法名
        String methodName = joinPoint.getSignature().getName();

        // 获取注解中的参数值
        MethodSignature methodSignature = (MethodSignature)joinPoint.getSignature();
        Method method = methodSignature.getMethod();
        // 获取注解Action
        SynchronousData annotation = method.getAnnotation(SynchronousData.class);

        String value = annotation.value();
        String type = annotation.type();

        if(value.equals(SyncAspectConstVal.redisToMysql)){
            //同步Redis数据到Mysql
            syncRedisToMysql(type);
        } else if(value.equals(SyncAspectConstVal.mysqlToRedis)){
            //同步Mysql数据到Redis
            syncMysqlToRedis(type);
        } else if(value.equals(SyncAspectConstVal.mysqlToEs)){
            //同步Es数据到Mysql
            syncMysqlToEs(type);
        }
    }

    private void syncRedisToMysql(String type){
        if(type.equals(SyncAspectConstVal.updateArticleDataByControlRecord)){
            controlRecordService.updateArticleDataByControlRecord();
        }
    }

    private void syncMysqlToRedis(String type){

    }

    private void syncMysqlToEs(String type){

    }




}
