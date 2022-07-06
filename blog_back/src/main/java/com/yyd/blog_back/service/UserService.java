package com.yyd.blog_back.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.yyd.blog_back.common.util.CreateAccount;
import com.yyd.blog_back.common.util.JWTUtil;
import com.yyd.blog_back.config.JwtConfig;
import com.yyd.blog_back.entity.MyUserDetail;
import com.yyd.blog_back.entity.User;
import com.yyd.blog_back.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.TimeUnit;


@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    RedisTemplate<String,Object> redisTemplate;

    public List<User> getAllUsersData(){
        return userMapper.selectList(null);
    }

    public User login(String account, String password, String temp){
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

    public User getUserById(Integer id){
        return userMapper.selectById(id);
    }

    /**
     * 根据账号查找用户
     * @param account
     * @return
     */
    public User getUserByAccount(String account){
        return userMapper.selectOne(this.getQueryWrapper("account", account));
    }


    public QueryWrapper<User> getQueryWrapper(String name, String value){
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        return queryWrapper.eq(name, value);
    }
}
