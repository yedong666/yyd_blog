package com.yyd.blog_back.service;

import com.yyd.blog_back.entity.User;
import com.yyd.blog_back.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    public List<User> getAllUsersData(){
        return userMapper.selectList(null);
    }
}
