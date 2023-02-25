package com.yyd.blog_back.entity;


import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.models.auth.In;
import lombok.Data;

/**
 * 用户数据信息
 */
@Data
@TableName("user_data")
@ApiModel(value = "UserData",description = "用户数据信息类")
public class UserData {
    @ApiModelProperty(value = "主键")
    private Integer id;
    //头像图片地址
    @ApiModelProperty(value = "头像图片地址")
    private String avatar;
    //性别
    @ApiModelProperty(value = "性别")
    private Integer gender;
    //年龄
    @ApiModelProperty(value = "出生日期")
    private String birthdate;
    //介绍
    @ApiModelProperty(value = "个人介绍")
    private String des;

    @ApiModelProperty(value = "个性签名")
    private String signature;

    @ApiModelProperty(value = "无痕浏览，0关闭，1开启")
    private Integer incognito;

    @ApiModelProperty(value = "用户兴趣标签")
    private String tags;

}
