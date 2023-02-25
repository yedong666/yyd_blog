package com.yyd.blog_back.vo;

import com.yyd.blog_back.entity.User;
import com.yyd.blog_back.entity.UserData;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import static jdk.nashorn.internal.runtime.Debug.id;

@Data
public class UserDataVo implements Serializable {
    private Integer id;
    private String nickname;
    private String avatar;
    private Integer gender;
    private String birthdate;
    private String[] tags;
    private String des;
    private String phoneNumber;
    private String email;
    private Integer status;
    private String signature;

    public UserDataVo(User user, UserData userData){
        this.id = user.getId();
        this.status = user.getStatus();
        this.nickname = user.getNickname();
        this.phoneNumber = user.getPhoneNumber();
        this.email = user.getEmail();
        this.avatar = userData.getAvatar();
        this.des = userData.getDes();
        this.birthdate = userData.getBirthdate();
        this.signature = userData.getSignature();
        this.tags = userData.getTags().split(",");
    }



}
