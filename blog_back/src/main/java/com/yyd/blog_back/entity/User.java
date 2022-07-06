package com.yyd.blog_back.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;


@Data
@TableName("user")
public class User implements Serializable {
    @JsonProperty(value = "id")
    @TableId(value = "id", type = IdType.AUTO)
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

    @JsonProperty(value = "rolesId")
    @TableField("rolesId")
    private String rolesId; //用户权限，用逗号分割

    @JsonProperty(value = "email")
    @TableField("email")
    private String email;

    @JsonProperty(value = "status")
    @TableField("status")
    private Integer status;
}

