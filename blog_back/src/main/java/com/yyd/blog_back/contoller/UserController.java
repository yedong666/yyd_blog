package com.yyd.blog_back.contoller;

import com.alibaba.fastjson.JSONObject;
import com.yyd.blog_back.common.Result;
import com.yyd.blog_back.common.util.PrintfMessage;
import com.yyd.blog_back.entity.People;
import com.yyd.blog_back.entity.User;
import com.yyd.blog_back.service.UserService;
import com.yyd.blog_back.vo.UserVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

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
        PrintfMessage.logRequest("login");
        User user = userService.login(account, password);
        if(user == null){
            return Result.error();
        }
        return Result.success(user);
    }

    /**
     * @Param("nickname") String nickname, @Param("password") String password,
     *                              @Param("phoneNumber") String phoneNumber, @Param("email") String email
     * @param
     * @return
     */
    @RequestMapping(value = "register", method = RequestMethod.POST, produces = "application/json")
    private Result reginster(@RequestBody User userData){
        System.out.println(userData.toString());
        PrintfMessage.logRequest("register");
        User newUser = userService.register(userData);
        if(newUser == null){
            return Result.error();
        }
        return Result.success(newUser);
    }

    @RequestMapping(value = "test",  method = RequestMethod.POST, produces = "application/json")
    private Result reginsterx(@RequestBody People people){
        System.out.println(people.toString());
        return Result.success(people);
    }

}
