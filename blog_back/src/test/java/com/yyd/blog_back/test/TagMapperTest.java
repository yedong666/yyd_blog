package com.yyd.blog_back.test;

import com.yyd.blog_back.entity.Tag;
import com.yyd.blog_back.mapper.TagMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TagMapperTest {

    @Autowired
    private TagMapper tagMapper;

    @Test
    public void test(){
        Tag  tag = tagMapper.getTagById(1);
        System.out.println(tag.getName());
    }

}
