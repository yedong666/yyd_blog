package com.yyd.blog_back.dto;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class ArticleHotDto {
    private Integer id;
    private String title;
    private Integer hotValue;
}
