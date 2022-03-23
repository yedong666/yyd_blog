package com.yyd.blog_back.vo;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserVo implements Serializable {
    private String password;
    private String nickname;
    private Integer phoneNumber;
    private String email;
}
