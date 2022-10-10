package com.yyd.blog_back.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@TableName("tag")
@NoArgsConstructor
@AllArgsConstructor
public class Tag {
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    private String name;
    @TableField("imgUrl")
    private String imgUrl;
    private String description;
    private String classify;
}
