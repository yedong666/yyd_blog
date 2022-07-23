package com.yyd.blog_back.test;

import com.yyd.blog_back.entity.Tag;
import com.yyd.blog_back.service.TagService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Map;

@SpringBootTest
public class TagServiceTest {

    @Autowired
    private TagService tagService;

    @Test
    public void test(){
        //Map<String, List<Tag>> map = tagService.getTagsByGroup();
        System.out.println("success");
    }
}

