package com.yyd.blog_back.test;


import com.yyd.blog_back.dto.ArticleSearchDto;
import com.yyd.blog_back.entity.Article;
import com.yyd.blog_back.search.impl.SearchByES;
import com.yyd.blog_back.service.ArticleService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * ES 搜索引擎测试
 */

@SpringBootTest
public class ESTest {

    @Autowired
    private SearchByES searchByES;

    @Autowired
    private ArticleService articleService;

    @Test
    public void test1(){
        searchByES.initData();
        Object obj = searchByES.search("文章");
        System.out.println("搜索完成");
    }


    /**
     * 同步 mysql 与 es数据
     */
    @Test
    public void test2(){

        // 查询数据库数据文章
        List<Article> articleList = articleService.getAllArticles();

        List<ArticleSearchDto> articleSearchDtoList = articleList.stream().map(ArticleSearchDto::new).collect(Collectors.toList());

        searchByES.initData(articleSearchDtoList);

        Object result = searchByES.search("java");

        System.out.println("搜索完成");

    }

    @Test
    public void test3(){
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println(simpleDateFormat.format(date));
        System.out.println(date);
    }
}
