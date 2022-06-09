package com.yyd.blog_back.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("userRole")
public class UserRole {
    private Integer id;
    private String role;
}
