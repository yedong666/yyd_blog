package com.yyd.blog_back.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.yyd.blog_back.common.BaseObj.BaseEntityObject;
import com.yyd.blog_back.dto.ArticleSearchDto;
import lombok.Data;

@Data
@TableName("article")
public class Article extends BaseEntityObject<ArticleSearchDto> {
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    private String title;
    private String content;
    private String summarize;
    private String author;
    @TableField("coverImage")
    private String coverImage;
    private String type;
    private String tags;
    @TableField("numberOfComment")
    private Integer numberOfComment;
    @TableField("numberOfLike")
    private Integer numberOfLike;
    @TableField("numberOfView")
    private Integer numberOfView;
    @TableField("isView")
    private Boolean isView;
    @TableField("isPublicCommentArea")
    private Boolean isPublicCommentArea;
    @TableField("isAllowedTurn")
    private Boolean isAllowedTurn;
    @TableField("createTime")
    private String createTime;



    @Override
    public ArticleSearchDto turn() {
        return ArticleSearchDto.builder().id(this.getId()).articleTitle(this.getTitle()).articleContent(this.getContent())
                .numberOfComment(this.getNumberOfComment()).numberOfLike(this.getNumberOfLike()).numberOfView(this.getNumberOfView())
                .createTime(this.getCreateTime()).build();

    }
}
