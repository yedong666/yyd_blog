package com.yyd.blog_back.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.yyd.blog_back.common.util.JWTUtil;
import com.yyd.blog_back.config.JwtConfig;
import com.yyd.blog_back.entity.MyUserDetail;
import com.yyd.blog_back.entity.User;
import com.yyd.blog_back.entity.UserRole;
import com.yyd.blog_back.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.TimeUnit;


@Service
public class MyUserDetailService implements UserDetailsService {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private JwtConfig jwtConfig;

    @Autowired
    private JWTUtil jwtUtil;

    @Autowired
    private UserRoleService userRoleService;

    @Override
    public UserDetails loadUserByUsername(String account){
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("account", account);
        User user = userMapper.selectOne(queryWrapper);
        List<SimpleGrantedAuthority> authorities = new ArrayList<>(1);
        //用于添加用户的权限。将用户权限添加到authorities
        List<UserRole> roles = userRoleService.findUserRoles(user.getRolesId());
        for (UserRole role : roles) {
            authorities.add(new SimpleGrantedAuthority(role.getName()));
        }
        return new MyUserDetail(user, authorities);
    }

    /**
     * 从token中提取信息
     *
     * @param authHeader
     * @return
     */
    public UserDetails loadUserByToken(String authHeader) {
        final String authToken = authHeader.substring(jwtConfig.getPrefix().length());//除去前缀，获取token

        String username = jwtUtil.getUsernameFromToken(authToken);
        //token非法
        if (null == username) {
            return null;
        }

        String redisToken = (String) redisTemplate.opsForValue().get(JwtConfig.REDIS_TOKEN_KEY_PREFIX + username);
        //从redis中取不到值 或 值 不匹配
        if (!authHeader.equals(redisToken)) {
            return null;
        }

        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("account", username);
        User user = userMapper.selectOne(queryWrapper);

        List<String> roles = jwtUtil.getRolesFromToken(authToken);

        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        for (String role : roles) {
            authorities.add(new SimpleGrantedAuthority(role));
        }

        return new MyUserDetail(user, authorities);
    }


}
