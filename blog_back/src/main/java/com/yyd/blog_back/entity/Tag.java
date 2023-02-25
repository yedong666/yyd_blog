package com.yyd.blog_back.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel(value = "Tag",description = "文章标签类")
@Data
@TableName("tag")
@NoArgsConstructor
@AllArgsConstructor
public class Tag {
    @ApiModelProperty(value = "主键")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    @ApiModelProperty(value = "标签名")
    private String name;
    @ApiModelProperty(value = "标签封面图存储地址")
    @TableField("imgUrl")
    private String imgUrl;
    @ApiModelProperty(value = "标签描述")
    private String description;
    @ApiModelProperty(value = "标签分类")
    private String classify;
}
