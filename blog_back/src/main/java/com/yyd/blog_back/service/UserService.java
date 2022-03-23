package com.yyd.blog_back.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.yyd.blog_back.common.util.CreateAccount;
import com.yyd.blog_back.entity.User;
import com.yyd.blog_back.mapper.UserMapper;
import com.yyd.blog_back.vo.UserVo;
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

    public User login(String account, String password){
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("account", account);
        User user = userMapper.selectOne(queryWrapper);
        if (!user.getPassword().equals(password)){
            return null;
        }
        return user;
    }

    public User register(User newUser){
        newUser.setAccount(CreateAccount.createAccount());
        newUser.setStatus(0);
        userMapper.insert(newUser);
        return newUser;
    }
}
