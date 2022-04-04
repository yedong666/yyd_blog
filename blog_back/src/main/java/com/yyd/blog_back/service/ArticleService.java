package com.yyd.blog_back.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.yyd.blog_back.entity.Article;
import com.yyd.blog_back.mapper.ArticleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleService {
    @Autowired
    private ArticleMapper articleMapper;

    /**
     * 查询所有文章
     * @return List<Article>
     */
    public List<Article>  getAllArticles(){
        return articleMapper.selectList(null);
    }

    /**
     * 根据作者查询文章
     * @return List<Article>
     */
    public List<Article> getArticlesByAuthor(String arthor){
        QueryWrapper<Article> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("author", arthor);
        return articleMapper.selectList(queryWrapper);
    }

    /**
     * 添加文章
     * @return boolean
     */
    public boolean addArticle(Article article){
        try{
            articleMapper.insert(article);
            return true;
        }catch (Exception e){
            System.out.println(e);
            return false;
        }
    }
}
