package com.yyd.blog_back.test;

import com.yyd.blog_back.common.util.JWTUtil;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class JwtTest {
    @Test
    public void testJwt(){
        String jwtStr = JWTUtil.createToken("20223020", "common", false);
        System.out.println(jwtStr);
        System.out.println(JWTUtil.getUsername(jwtStr));
        System.out.println(JWTUtil.getUserRole(jwtStr));

    }
}
