package com.yyd.blog_back.test;

import com.yyd.blog_back.common.util.AuthCode;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.*;

@SpringBootTest
public class AuthCodeTest {

    @Test
    public void test1() throws IOException {
        AuthCode authCode = new AuthCode();

        OutputStream outputStream = new FileOutputStream("src/main/resources/static/imgs/authCodeImg/test.jpeg");

        AuthCode.output(authCode.getImage(),outputStream);
    }

}
