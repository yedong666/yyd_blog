package com.yyd.blog_back.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.yyd.blog_back.entity.Comment;
import com.yyd.blog_back.mapper.CommentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {
    @Autowired
    private CommentMapper commentMapper;

    public List<Comment> getCommentByArticleId(Integer artileId){
        QueryWrapper<Comment> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("articleId", artileId);
        return commentMapper.selectList(queryWrapper);
    }

    public boolean addComment(Comment comment){
        try {
            commentMapper.insert(comment);
            return true;
        }catch (Exception e){
            System.out.println("发表评论出现异常");
            return false;
        }
    }
}
