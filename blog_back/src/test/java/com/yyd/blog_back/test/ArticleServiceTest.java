package com.yyd.blog_back.test;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yyd.blog_back.entity.Article;
import com.yyd.blog_back.mapper.ArticleMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ArticleServiceTest {

    @Autowired
    private ArticleMapper articleMapper;

    @Test
    public void test(){
        QueryWrapper<Article> queryWrapper = new QueryWrapper<>();
        Page<Article> page = new Page(1, 4);
        Page<Article> iPage = articleMapper.selectPage(page, queryWrapper);
        for(Article map : page.getRecords()) {
            System.out.println(map);
        }
    }


}

