package com.yyd.blog_back.test;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yyd.blog_back.dto.ArticleHotDto;
import com.yyd.blog_back.dto.ArticleNewDto;
import com.yyd.blog_back.entity.Article;
import com.yyd.blog_back.mapper.ArticleMapper;
import com.yyd.blog_back.service.ArticleService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class ArticleServiceTest {

    @Autowired
    private ArticleMapper articleMapper;

    @Autowired
    private ArticleService articleService;

    @Test
    public void test1(){
        QueryWrapper<Article> queryWrapper = new QueryWrapper<>();
        Page<Article> page = new Page(1, 4);
        Page<Article> iPage = articleMapper.selectPage(page, queryWrapper);
        for(Article map : page.getRecords()) {
            System.out.println(map);
        }
    }

    @Test
    public void test2(){
        List<ArticleHotDto> list = articleMapper.getArticlesOrderByHot(10);
        for(ArticleHotDto map : list) {
            System.out.println("标题: " + map.getTitle()+"  热度:" + map.getHotValue());
        }
    }

    @Test
    public void test3(){
        List<ArticleNewDto> list = articleService.getNewArticles();
        for(ArticleNewDto map : list) {
            System.out.println("标题: " + map.getTitle()+"  日期:" + map.getCreateTime());
        }
    }

    @Test
    public void test4(){
//        articleService.clickLike();
    }


}

