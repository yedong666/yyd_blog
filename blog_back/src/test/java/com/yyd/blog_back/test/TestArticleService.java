package com.yyd.blog_back.test;

import com.yyd.blog_back.service.ArticleService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class TestArticleService {
    @Autowired
    private ArticleService articleService;

    @Test
    public void test(){
        if (articleService.getAllArticles() == null){
            System.out.println("列表为空");
        }
    }
}
