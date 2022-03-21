package com.yyd.blog_back.contoller;

import com.yyd.blog_back.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("check_users")
    private String checkUsers(){
        return userService.getAllUsersData().toString();
    }

    @RequestMapping("login")
    private String login(){
        return userService.getAllUsersData().toString();
    }
}
