package com.yyd.blog_back.dto;

import com.yyd.blog_back.common.BaseObj.BaseSearchObject;
import com.yyd.blog_back.entity.Article;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document(indexName = "article")
public class ArticleSearchDto extends BaseSearchObject {
    /**
     * 文章id
     */
    @Id
    private Integer id;

    /**
     * 文章标题
     */
    @Field(type = FieldType.Text)
    private String articleTitle;

    /**
     * 文章内容
     */
    @Field(type = FieldType.Text)
    private String articleContent;
    @Field(type = FieldType.Integer)
    private Integer numberOfComment;
    @Field(type = FieldType.Integer)
    private Integer numberOfLike;
    @Field(type = FieldType.Integer)
    private Integer numberOfView;
    @Field(type = FieldType.Text)
    private String createTime;
    /**
     * 是否允许他人访问
     */
    @Field(type = FieldType.Boolean)
    private Boolean isView;

    public ArticleSearchDto(Article article){
        this.id = article.getId();
        this.articleContent = article.getContent();
        this.articleTitle = article.getTitle();
        this.isView = article.getIsView();
        this.numberOfComment = article.getNumberOfComment();
        this.numberOfLike = article.getNumberOfLike();
        this.numberOfView = article.getNumberOfView();
        this.createTime = article.getCreateTime();
    }

    @Override
    public String getSearchContent() {
        return this.articleTitle + this.getArticleContent();
    }

    public int getHot(){
        return numberOfView + numberOfLike*10 + numberOfComment*10;
    }
}
