package com.yyd.blog_back.test;

import com.yyd.blog_back.common.util.JWTUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootTest
public class JwtTest {

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Test
    public void testJwt(){
       String s =  bCryptPasswordEncoder.encode("12345678");
        System.out.println(s);
    }
}
