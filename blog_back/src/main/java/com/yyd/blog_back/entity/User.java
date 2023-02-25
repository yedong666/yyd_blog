package com.yyd.blog_back.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.io.Serializable;

/**
 * 用户管理信息
 */
@Data
@TableName("user")
@ApiModel(value = "User",description = "用户管理信息类")
public class User implements Serializable {
    @JsonProperty(value = "id")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField("userDataId")
    private Integer userDataId;

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

    @TableField("numOfFan")
    private Integer numOfFan;
    @TableField("numOfArticle")
    private Integer numOfArticle;

    @JsonProperty(value = "status")
    @TableField("status")
    private Integer status;

    @TableField("createTime")
    private String createTime;
}

