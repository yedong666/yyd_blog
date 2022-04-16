package com.yyd.blog_back.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("comment")
public class Comment {
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    private String content;
    @TableField("observerId")
    private Integer observerId;
    @TableField("articleId")
    private Integer articleId;
    @TableField("replyId")
    private String date;
    @TableField("numberOfLike")
    private Integer numberOfLike;
    @TableField("numberOfReply")
    private Integer numberOfReply;
    @TableField("numberOfView")
    private Integer numberOfView;
}
