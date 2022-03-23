package com.yyd.blog_back.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;


@Data
@TableName("user")
public class User implements Serializable {
    @JsonProperty(value = "id")
    private Integer id;

    @JsonProperty(value = "account")
    @TableField("account")
    private String account;

    @JsonProperty(value = "password")
    @TableField("password")
    private String password;

    @JsonProperty(value = "nickname")
    @TableField("nickname")
    private String nickname;

    @JsonProperty(value = "phoneNumber")
    @TableField("phoneNumber")
    private String phoneNumber;

    @JsonProperty(value = "email")
    @TableField("email")
    private String email;

    @JsonProperty(value = "status")
    @TableField("status")
    private Integer status;
}

