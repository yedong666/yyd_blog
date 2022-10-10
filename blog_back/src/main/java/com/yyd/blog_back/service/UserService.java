package com.yyd.blog_back.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.yyd.blog_back.common.util.CreateAccount;
import com.yyd.blog_back.config.JwtConfig;
import com.yyd.blog_back.entity.User;
import com.yyd.blog_back.mapper.UserMapper;
import com.yyd.blog_back.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;


@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private RedisTemplate<String,Object> redisTemplate;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public List<User> getAllUsersData(){
        return userMapper.selectList(null);
    }

    public List<UserVo> getUserVoList(){
        List<UserVo> userVoList = new ArrayList<>();
        getAllUsersData().stream().forEach(user -> {
            userVoList.add(new UserVo(user, redisTemplate.opsForValue().get(JwtConfig.REDIS_TOKEN_KEY_PREFIX + user.getAccount()) != null));

        });
        return userVoList;
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
        newUser.setPassword(bCryptPasswordEncoder.encode(newUser.getPassword()));
        newUser.setStatus(0);
        newUser.setRolesId("2,3");
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
