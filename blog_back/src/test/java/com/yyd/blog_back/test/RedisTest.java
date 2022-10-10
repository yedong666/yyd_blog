package com.yyd.blog_back.test;

import com.alibaba.fastjson.JSON;
import com.yyd.blog_back.common.RedisData.ControlRecordStore;
import com.yyd.blog_back.common.util.DateUtil;
import com.yyd.blog_back.entity.ControlRecord;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

import java.io.Serializable;

@SpringBootTest
public class RedisTest {

    @Autowired
    RedisTemplate redisTemplate;

    @Autowired
    private ControlRecordStore controlRecordStore;

    @Test
    public void test1(){
        ControlRecord controlRecord = ControlRecord.builder().
                            id(2).userId(5).articleId(3).controlType("clickLike").controlTime(DateUtil.getTime()).build();
        controlRecordStore.addControlRecord(controlRecord);
        controlRecordStore.saveToMysql();
    }

    @Test
    public void testRedis(){
        Student student = new Student();
        student.age = 10;
        student.name = "jack";
        redisTemplate.opsForValue().set("user", JSON.toJSONString(student));
//        String stuStr = redisTemplate.opsForValue().get("user").toString();
        Student stuStr = (Student) redisTemplate.opsForValue().get("user");
        System.out.println(stuStr.name);
//        System.out.println(stuStr);
//        Student stu = JSON.parseObject(stuStr, Student.class);
//        System.out.println(stu.age);
//        System.out.println(stu.name);
    }
}

class Student implements Serializable{
    public String name;
    public int age;
}
