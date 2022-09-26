package com.yyd.blog_back.contoller;

import com.yyd.blog_back.common.Result;
import com.yyd.blog_back.common.annotation.SaveRedisData;
import com.yyd.blog_back.common.util.PrintfMessage;
import com.yyd.blog_back.entity.Article;
import com.yyd.blog_back.service.ArticleService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
public class ArticleController {
    @Autowired
    private ArticleService articleService;

    @RequestMapping("articles")
    @PreAuthorize("hasAuthority('VISITOR')")
    public Result getAllArticles(){
        List<Article> articles = articleService.getAllArticles();
        if (articles.size() == 0){
            return Result.error("文章查询失败");
        }
        return Result.success(articles);
    }

    @RequestMapping("getArticleById")
    @PreAuthorize("hasAuthority('VISITOR')")
    @SaveRedisData
    public Result getArticleById(@Param("id") Integer id){
        Article article = articleService.getArticleById(id);
        System.out.println(id);
        if (article == null){
            return Result.error("id不存在");
        }
        return Result.success(article);
    }

    @RequestMapping("getArticlesByAuthor")
    @PreAuthorize("hasAuthority('VISITOR')")
    public Result getArticlesByAuthor(@Param("author") String author){
        List<Article> articles = articleService.getArticlesByAuthor(author);
        if (articles.size() == 0){
            return Result.error("没有该作者写的文章哦");
        }
        return Result.success(articles);
    }

    @RequestMapping(value = "addArticle", method = RequestMethod.POST, produces = "application/json")
    @PreAuthorize("hasAuthority('USER')")
    public Result addArticle(@RequestBody Article article){
        PrintfMessage.logRequest("addArticle");
        if (!articleService.addArticle(article)){
            return Result.error("添加文章失败");
        }
        return Result.success("添加文章成功");
    }

    @RequestMapping("clickLike")
    @PreAuthorize("hasAuthority('USER')")
    public Result clickLike(Integer userId,  Integer articleId){
        articleService.clickLike(userId, articleId);
        return Result.success("点赞+1");
    }

    @RequestMapping("cancelLike")
    @PreAuthorize("hasAuthority('USER')")
    public Result cancelLike(Integer userId,  Integer articleId){
        articleService.cancelLike(userId, articleId);
        return Result.success("点赞-1");
    }

    @RequestMapping("readArticle")
    @PreAuthorize("hasAuthority('USER')")
    public Result readArticle(Integer userId,  Integer articleId){
        articleService.readArticle(userId, articleId);
        return Result.success("文章阅读量+1");
    }

    @RequestMapping("getPageArticles")
    @PreAuthorize("hasAuthority('VISITOR')")
    @SaveRedisData
    public Result getPageArticles(@Param("pageNum") Integer pageNum){
        return Result.success(articleService.getArticlesByPage(pageNum));
    }

    @RequestMapping("getArticlesCount")
    @PreAuthorize("hasAuthority('VISITOR')")
    public Result getArticlesCount(){
        return Result.success(articleService.getArticlesCount());
    }

    @RequestMapping("getHotArticles")
    @PreAuthorize("hasAuthority('VISITOR')")
    public Result getHotArticles(){
        return Result.success(articleService.getHotArticles());
    }

    @RequestMapping("getNewArticles")
    @PreAuthorize("hasAuthority('VISITOR')")
    public Result getNewArticles(){
        return Result.success(articleService.getNewArticles());
    }





}
