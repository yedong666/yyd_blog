package com.yyd.blog_back.contoller;

import com.yyd.blog_back.common.Result;
import com.yyd.blog_back.entity.Comment;
import com.yyd.blog_back.service.CommentService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CommentController {
    @Autowired
    CommentService commentService;

    @RequestMapping("getCommentsByArticleId")
    public Result getCommentByArticleId(@Param("articleId") Integer articleId){
        List<Comment> comments = commentService.getCommentByArticleId(articleId);
        return Result.success(comments);
    }
}
