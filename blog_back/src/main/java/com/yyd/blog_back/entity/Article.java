package com.yyd.blog_back.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.yyd.blog_back.common.BaseObj.BaseEntityObject;
import com.yyd.blog_back.dto.ArticleSearchDto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel(value = "Article", description = "文章类")
@Data
@TableName("article")
public class Article extends BaseEntityObject<ArticleSearchDto> {
    @ApiModelProperty(value = "主键")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    @ApiModelProperty(value = "文章标题")
    private String title;
    @ApiModelProperty(value = "文章内容")
    private String content;
    @ApiModelProperty(value = "文章概述")
    private String summarize;
    @ApiModelProperty(value = "文章作者")
    private String author;
    @ApiModelProperty(value = "文章封面图片地址")
    @TableField("coverImage")
    private String coverImage;
    @ApiModelProperty(value = "文章类型")
    private String type;
    @ApiModelProperty(value = "文章标签集")
    private String tags;
    @ApiModelProperty(value = "文章评论数")
    @TableField("numberOfComment")
    private Integer numberOfComment;
    @ApiModelProperty(value = "文章点赞数")
    @TableField("numberOfLike")
    private Integer numberOfLike;
    @ApiModelProperty(value = "文章浏览数")
    @TableField("numberOfView")
    private Integer numberOfView;
    @ApiModelProperty(value = "文章是否公开, 1是， 0否")
    @TableField("isView")
    private Boolean isView;
    @ApiModelProperty(value = "文章是否开发评论区, 1是， 0否")
    @TableField("isPublicCommentArea")
    private Boolean isPublicCommentArea;
    @ApiModelProperty(value = "文章是否允许转发, 1是， 0否")
    @TableField("isAllowedTurn")
    private Boolean isAllowedTurn;
    @ApiModelProperty(value = "文章发布时间")
    @TableField("createTime")
    private String createTime;



    @Override
    public ArticleSearchDto turn() {
        return ArticleSearchDto.builder().id(this.getId()).articleTitle(this.getTitle()).articleContent(this.getContent())
                .numberOfComment(this.getNumberOfComment()).numberOfLike(this.getNumberOfLike()).numberOfView(this.getNumberOfView())
                .createTime(this.getCreateTime()).build();

    }
}
