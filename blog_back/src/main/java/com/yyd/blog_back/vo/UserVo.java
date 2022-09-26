package com.yyd.blog_back.vo;

import com.yyd.blog_back.entity.User;
import lombok.Data;

import java.io.Serializable;

@Data
public class UserVo implements Serializable {
    private Integer id;
    private String account;
    private String nickname;
    private String phoneNumber;
    private String email;
    private String role;
    private String status;
    private String isOnline;

    public UserVo(User user, boolean isOnline){
        this.id = user.getId();
        this.account = user.getAccount();
        this.nickname = user.getNickname();
        this.phoneNumber = user.getPhoneNumber();
        this.email = user.getEmail();

        if(user.getRolesId().charAt(0) == '1') this.role = "站长";
        else if(user.getRolesId().charAt(0) == '2') this.role = "管理员";
        else if(user.getRolesId().charAt(0) == '3') this.role = "普通用户";
        else System.out.println("id为" + this.id + "的用户权限设置出现问题");

        if(user.getStatus() == 1) this.status = "正常";
        else if(user.getStatus() == 0) this.status = "禁用";

        this.isOnline = isOnline ? "在线" : "离线";
    }
}
