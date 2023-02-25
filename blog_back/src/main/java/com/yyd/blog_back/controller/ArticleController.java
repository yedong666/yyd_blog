package com.yyd.blog_back.controller;

import com.yyd.blog_back.common.Result;
import com.yyd.blog_back.common.annotation.SynchronousData;
import com.yyd.blog_back.common.constValue.SyncAspectConstVal;
import com.yyd.blog_back.common.emum.ResultCodeEnum;
import com.yyd.blog_back.common.util.PrintUtil;
import com.yyd.blog_back.entity.Article;
import com.yyd.blog_back.service.ArticleService;
import com.yyd.blog_back.service.ControlRecordService;
import io.swagger.annotations.Api;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(tags = "文章管理接口")
@RestController
public class ArticleController {
    @Autowired
    private ArticleService articleService;
    @Autowired
    private ControlRecordService controlRecordService;

    @RequestMapping("articles")
    @PreAuthorize("hasAuthority('VISITOR')")
    public Result<List<Article>> getAllArticles(){
        List<Article> articles = articleService.getAllArticles();
        if (articles.size() == 0){
            return Result.fail();
        }
        return Result.suc(articles);
    }

    @RequestMapping("getArticleById")
    @PreAuthorize("hasAuthority('VISITOR')")
    @SynchronousData(type = SyncAspectConstVal.updateArticleDataByControlRecord)
    public Result<Article> getArticleById(@Param("id") Integer id){
        Article article = articleService.getArticleById(id);
        System.out.println(id);
        if (article == null){
            return Result.fail();
        }
        return Result.suc(article);
    }

    @RequestMapping("getArticlesByAuthor")
    @PreAuthorize("hasAuthority('VISITOR')")
    public Result<List<Article>> getArticlesByAuthor(@Param("author") String author){
        List<Article> articles = articleService.getArticlesByAuthor(author);
        if (articles.size() == 0){
            return Result.fail();
        }
        return Result.suc(articles);
    }

    @RequestMapping(value = "addArticle", method = RequestMethod.POST, produces = "application/json")
    @PreAuthorize("hasAuthority('USER')")
    public Result addArticle(@RequestBody Article article){
        PrintUtil.logRequest("addArticle");
        if (!articleService.addArticle(article)){
            return Result.fail();
        }
        return Result.suc("添加文章成功");
    }

    @RequestMapping("clickLike")
    @PreAuthorize("hasAuthority('USER')")
    public Result clickLike(Integer userId,  Integer articleId){
        controlRecordService.clickLike(userId, articleId);
        return Result.suc("点赞+1");
    }

    @RequestMapping("cancelLike")
    @PreAuthorize("hasAuthority('USER')")
    public Result cancelLike(Integer userId,  Integer articleId){
        controlRecordService.cancelLike(userId, articleId);
        return Result.suc("点赞-1");
    }

    @RequestMapping("readArticle")
    @PreAuthorize("hasAuthority('USER')")
    public Result readArticle(Integer userId,  Integer articleId){
        controlRecordService.readArticle(userId, articleId);
        return Result.suc("文章阅读量+1");
    }

    @RequestMapping("getPageArticles")
    @PreAuthorize("hasAuthority('VISITOR')")
    @SynchronousData(type = SyncAspectConstVal.updateArticleDataByControlRecord)
    public Result getPageArticles(@Param("pageNum") Integer pageNum){
        return Result.suc(articleService.getArticlesByPage(pageNum));
    }

    @RequestMapping("getArticlesCount")
    @PreAuthorize("hasAuthority('VISITOR')")
    public Result getArticlesCount(){
        return Result.suc(articleService.getArticlesCount());
    }

    @RequestMapping("getHotArticles")
    @PreAuthorize("hasAuthority('VISITOR')")
    public Result getHotArticles(){
        return Result.suc(articleService.getHotArticles());
    }

    @RequestMapping("getNewArticles")
    @PreAuthorize("hasAuthority('VISITOR')")
    public Result getNewArticles(){
        return Result.suc(articleService.getNewArticles());
    }





}
