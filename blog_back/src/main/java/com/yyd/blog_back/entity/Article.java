package com.yyd.blog_back.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("article")
public class Article {
    private Integer id;
    private String title;
    private String content;
    private String summarize;
    private String author;
    @TableField("coverImage")
    private String coverImage;
    private String tags;
    @TableField("numberOfComment")
    private Integer numberOfComment;
    @TableField("numberOfLike")
    private Integer numberOfLike;
    @TableField("numberOfView")
    private Integer numberOfView;
}
