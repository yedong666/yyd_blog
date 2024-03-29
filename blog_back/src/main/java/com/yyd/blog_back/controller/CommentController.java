package com.yyd.blog_back.controller;

import com.yyd.blog_back.common.Result;
import com.yyd.blog_back.entity.Comment;
import com.yyd.blog_back.service.CommentService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CommentController {
    @Autowired
    CommentService commentService;

    @RequestMapping("getCommentsByArticleId")
    @PreAuthorize("hasAuthority('VISITOR')")
    public Result getCommentByArticleId(@Param("articleId") Integer articleId){ 
        List<Comment> comments = commentService.getCommentByArticleId(articleId);
        return Result.suc(comments);
    }

//    @CrossOrigin
    @RequestMapping(value = "addComment", method = RequestMethod.POST, produces = "application/json")
    @PreAuthorize("hasAuthority('USER')")
    public Result addComment(@RequestBody Comment comment){
        if (!commentService.addComment(comment)){
            return Result.fail();
        }
        return Result.suc("添加评论成功");
    }

}
