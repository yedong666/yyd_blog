package com.yyd.blog_back.dto;


import lombok.Data;

@Data
public class ControlRecordOverDto {
    //用户id
    private Integer userId;
    //操作记录数量
    private Integer count;
}
