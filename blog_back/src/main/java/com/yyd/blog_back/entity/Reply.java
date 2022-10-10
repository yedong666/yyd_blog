package com.yyd.blog_back.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;

public class Reply {
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    private String content;
    @TableField("observerId")
    private Integer observerId;
    @TableField("commentId")
    private Integer articleId;
    @TableField("replyId")
    private String date;
    @TableField("numberOfLike")
    private Integer numberOfLike;
    @TableField("numberOfView")
    private Integer numberOfView;
}
