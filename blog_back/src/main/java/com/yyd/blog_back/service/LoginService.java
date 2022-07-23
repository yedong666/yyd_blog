package com.yyd.blog_back.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.yyd.blog_back.common.util.JWTUtil;
import com.yyd.blog_back.config.JwtConfig;
import com.yyd.blog_back.entity.MyUserDetail;
import com.yyd.blog_back.entity.User;
import com.yyd.blog_back.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.TimeUnit;

@Service
public class LoginService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private JwtConfig jwtConfig;

    @Autowired
    private JWTUtil jwtUtil;

    @Autowired
    private UserRoleService userRoleService;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private RedisTemplate redisTemplate;

    public Map<String, Object> login(String account, String password){
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("account", account);
        User dbUser = userMapper.selectOne(queryWrapper);
        System.out.println(bCryptPasswordEncoder.matches(password, dbUser.getPassword()));
        //此用户不存在 或 密码错误
        if (null == dbUser || !bCryptPasswordEncoder.matches(password, dbUser.getPassword())) {
            System.out.println(password + ":" + dbUser.getPassword());
            return null;
        }

        //用户名 密码 匹配 签发token
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(account, password);
        Authentication authentication = authenticationManager.authenticate(authenticationToken);
        if(authentication==null){
            System.out.println("认证失败");
            return null;
        }

        MyUserDetail myUserDetail = (MyUserDetail) authentication.getPrincipal();

        final String token = jwtUtil.generateToken(myUserDetail);

        Collection<? extends GrantedAuthority> authorities = myUserDetail.getAuthorities();
        List<String> roles = new ArrayList<>();
        for (GrantedAuthority authority : authorities) {
            roles.add(authority.getAuthority());
        }

        Map<String, Object> map = new HashMap<>(3);

        map.put("token", jwtConfig.getPrefix() + token);
        map.put("user", dbUser);
        map.put("roles", roles);

        //将token存入redis 过期时间 jwtConfig.time 单位[s]
        redisTemplate.opsForValue().
                set(JwtConfig.REDIS_TOKEN_KEY_PREFIX + dbUser.getAccount(), jwtConfig.getPrefix() + token, jwtConfig.getTime(), TimeUnit.SECONDS);

        return map;
    }
}
