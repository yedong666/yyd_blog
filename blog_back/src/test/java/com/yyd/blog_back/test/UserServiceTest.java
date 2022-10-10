package com.yyd.blog_back.test;

import com.yyd.blog_back.service.UserService;
import com.yyd.blog_back.vo.UserVo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    public void test(){

        List<UserVo> userVoList = userService.getUserVoList();
        System.out.println("over");
    }

}
