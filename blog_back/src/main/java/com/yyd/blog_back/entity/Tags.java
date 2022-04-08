package com.yyd.blog_back.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("tags")
public class Tags{
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    private String name;
    @TableField("imgUrl")
    private String imgUrl;
    private String description;
}
