package com.yyd.blog_back.dto;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.yyd.blog_back.common.BaseObj.BaseSearchObject;
import com.yyd.blog_back.entity.Article;
import com.yyd.blog_back.entity.Tag;
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
@Document(indexName = "tag")
public class TagSearchDto extends BaseSearchObject {
    @Id
    private Integer id;
    @Field(type = FieldType.Text)
    private String name;
    @Field(type = FieldType.Text)
    private String description;

    public TagSearchDto(Tag tag) {
        this.id = tag.getId();
        this.description = tag.getDescription();
        this.name = tag.getName();
    }

    @Override
    public String getSearchContent() {
        return this.name + this.description;
    }

    public int getHot() {
        return 0;
    }
}