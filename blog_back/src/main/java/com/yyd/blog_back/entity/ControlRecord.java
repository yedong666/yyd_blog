package com.yyd.blog_back.entity;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName("controlRecord")
public class ControlRecord {
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    @TableField("userId")
    private Integer userId;
    @TableField("articleId")
    private Integer articleId;
    @TableField("controlType")
    private String controlType;
    @TableField("controlTime")
    private String controlTime;

    @Override
    public String toString(){
        return JSON.toJSONString(this);
    }
}
