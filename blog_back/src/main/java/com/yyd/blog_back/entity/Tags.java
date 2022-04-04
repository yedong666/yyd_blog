package com.yyd.blog_back.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("tags")
public class Tags{
    private Integer id;
    private String name;
    @TableField("imgUrl")
    private String imgUrl;
    private String description;
}
