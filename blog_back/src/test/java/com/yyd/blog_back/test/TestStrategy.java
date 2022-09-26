package com.yyd.blog_back.test;

import com.yyd.blog_back.search.context.MySearchContext;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.Map;

@SpringBootTest
public class TestStrategy {

    @Autowired
    private MySearchContext mySearchContext;


    @Test
    public void test1(){
      mySearchContext.searchByStrategy("ABCD", 1, "Article");
    }

}
