package com.yyd.blog_back.contoller;

import com.yyd.blog_back.common.Result;
import com.yyd.blog_back.entity.User;
import com.yyd.blog_back.service.UserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("check_users")
    private Result checkUsers(){
        return Result.success(userService.getAllUsersData());
    }


    @RequestMapping("login")
    private Result login(@Param("account") String account, @Param("password") String password){
        User user = userService.login(account, password);
        if(user == null){
            return Result.error();
        }
        return Result.success(user);
    }
}
