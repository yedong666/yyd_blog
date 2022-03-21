package com.yyd.blog_back.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
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

    public boolean login(String account, String password){
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        //根据查询的结果集中id排序
        queryWrapper.orderByAsc("account");
        User user = userMapper.selectOne(queryWrapper);
        //该账号存在且密码正确
        return (user!= null && user.getPassword() == password);
    }
}
