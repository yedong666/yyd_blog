package com.yyd.blog_back.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("user")
public class User {
    private Long id;
    private String account;
    private String password;
    private String nickname;
    private int status;
}

