package com.yyd.blog_back.dto;

import com.yyd.blog_back.entity.User;
import com.yyd.blog_back.entity.UserData;
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
@Document(indexName = "user")
public class UserSearchDto {
    @Id
    private Integer id;
    @Field(type = FieldType.Text)
    private String nickname;
    @Field(type = FieldType.Integer)
    private Integer gender;
    @Field(type = FieldType.Text)
    private String des;
    @Field(type = FieldType.Integer)
    private Integer numOfFan;
    @Field(type = FieldType.Integer)
    private Integer numOfArticle;
    @Field(type = FieldType.Text)
    private String avatar;
    @Field(type = FieldType.Text)
    private String createTime;

    UserSearchDto(User user, UserData userData){
        this.id = user.getId();
        this.nickname = user.getNickname();
        this.createTime= user.getCreateTime();
        this.gender = userData.getGender();
        this.des = userData.getDes();
        this.avatar = userData.getAvatar();
        this.numOfArticle = user.getNumOfArticle();
        this.numOfFan = user.getNumOfFan();

    }
}
