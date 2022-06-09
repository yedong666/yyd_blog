package com.yyd.blog_back.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.yyd.blog_back.entity.User;
import com.yyd.blog_back.entity.UserDetail;
import com.yyd.blog_back.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.Objects;


@Service
public class UserDetailService implements UserDetailsService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String account){
        System.out.println(account);
        //查询用户信息
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("account", account);
        User user = userMapper.selectOne(queryWrapper);

        if (Objects.isNull(user)){
            throw new RuntimeException("The account is error");
        }

        //TODO 查询对应的权限信息

        return new UserDetail(user);
    }
}
