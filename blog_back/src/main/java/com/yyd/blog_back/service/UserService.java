package com.yyd.blog_back.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.yyd.blog_back.common.util.CreateAccount;
import com.yyd.blog_back.common.util.JWTUtil;
import com.yyd.blog_back.entity.User;
import com.yyd.blog_back.mapper.UserMapper;
import com.yyd.blog_back.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.neo4j.Neo4jProperties;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

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

    public User login(String account, String password){
//        //获取Authentication接口实现类对象实例
//        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(account,password);
//        Authentication authentication = authenticationManager.authenticate(authenticationToken);
//
//        if (Objects.isNull(authentication)){
//            throw new RuntimeException("登录失败");
//        }

//        //认证成功则生成JWT存入ResponseResult
//        String jwtStr = JWTUtil.createToken(account, "user", true);

//        //将用户完整信息存入Redis
//        redisTemplate.opsForValue().set(account, authentication);

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
}
