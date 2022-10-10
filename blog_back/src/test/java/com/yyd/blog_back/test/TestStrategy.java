package com.yyd.blog_back.test;

import com.yyd.blog_back.search.context.MySearchContext;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest
public class TestStrategy {

    @Autowired
    private MySearchContext mySearchContext;

    @Autowired
    private RedisTemplate redisTemplate;


    @Test
    public void test1(){
      List<Object> objectList = mySearchContext.searchByStrategy("Linux", 1, "Article");
        System.out.println(".......");
    }

    @Test
    public void test2(){
        redisTemplate.delete(redisTemplate.keys("*"));
    }

}
