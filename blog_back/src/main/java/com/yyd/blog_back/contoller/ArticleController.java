package com.yyd.blog_back.contoller;

import com.yyd.blog_back.common.Result;
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
}
