package com.yyd.blog_back.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("comment")
public class Comment {
    private Integer id;
    private String content;
    @TableField("observerId")
    private Integer observerId;
    @TableField("articleId")
    private Integer articleId;
    private String date;
    @TableField("numberOfLike")
    private Integer numberOfLike;

}
