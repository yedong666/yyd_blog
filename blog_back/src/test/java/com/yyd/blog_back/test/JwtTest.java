package com.yyd.blog_back.test;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.yyd.blog_back.common.util.JWTUtil;
import com.yyd.blog_back.entity.User;
import com.yyd.blog_back.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootTest
public class JwtTest {

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    private UserMapper userMapper;

    @Test
    public void testJwt(){
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("account", "20223020");
        User dbUser = userMapper.selectOne(queryWrapper);
        System.out.println(bCryptPasswordEncoder.matches("12345678", dbUser.getPassword()));
    }
}
