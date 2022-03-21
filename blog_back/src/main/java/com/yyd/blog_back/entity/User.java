package com.yyd.blog_back.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("user")
public class User {
    @TableField("id")
    private Long id;
    @TableField("account")
    private String account;
    @TableField("password")
    private String password;
    @TableField("nickname")
    private String nickname;
    @TableField("status")
    private int status;
}

