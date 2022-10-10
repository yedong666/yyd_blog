package com.yyd.blog_back.aspect;

import com.baomidou.mybatisplus.core.conditions.interfaces.Join;
import com.yyd.blog_back.common.RedisData.ControlRecordStore;
import com.yyd.blog_back.common.annotation.SaveRedisData;
import com.yyd.blog_back.common.util.DateUtil;
import com.yyd.blog_back.entity.ControlRecord;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class RedisAspect {
    @Autowired
    private ControlRecordStore controlRecordStore;

    @Pointcut("@annotation(com.yyd.blog_back.common.annotation.SaveRedisData)")
    public void optRedisPointCut() {}

    @Before(value = "optRedisPointCut()")
    public void saveToMysql(JoinPoint joinPoint){
        controlRecordStore.saveToMysql();
    }


}
