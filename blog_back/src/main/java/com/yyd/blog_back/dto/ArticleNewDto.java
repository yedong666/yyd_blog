package com.yyd.blog_back.dto;

import com.yyd.blog_back.entity.Article;
import lombok.Data;

@Data
public class ArticleNewDto {
    private Integer id;
    private String title;
    private String createTime;

    public ArticleNewDto(Article article){
        this.id = article.getId();
        this.title = article.getTitle();
        this.createTime = article.getCreateTime();

    }
}
