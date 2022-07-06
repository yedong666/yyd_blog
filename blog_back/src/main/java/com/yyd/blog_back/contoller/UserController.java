package com.yyd.blog_back.contoller;

import com.yyd.blog_back.common.Result;
import com.yyd.blog_back.common.util.PrintfMessage;
import com.yyd.blog_back.entity.People;
import com.yyd.blog_back.entity.User;
import com.yyd.blog_back.service.LoginService;
import com.yyd.blog_back.service.MyUserDetailService;
import com.yyd.blog_back.service.UserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private LoginService loginService;

    @RequestMapping("check_users")
    @PreAuthorize("hasAuthority('ROOT')")
    public Result checkUsers(){
        return Result.success(userService.getAllUsersData());
    }

    @RequestMapping("getUserById")
    @PreAuthorize("hasAuthority('VISITOR')")
    public Result getUserById(@Param("id") Integer id){
        User user = userService.getUserById(id);
        if (user == null){
            return Result.error("此用户id不存在");
        }
        return Result.success(user);
    }


    @RequestMapping("login")
    @PreAuthorize("hasAuthority('VISITOR')")
    public Result login(@Param("account") String account, @Param("password") String password){
        PrintfMessage.logRequest("login");
        Map<String, Object> map = loginService.login(account, password);
        if(map == null){
            return Result.error();
        }
        return Result.success(map);
    }

    @RequestMapping(value = "logout", method = RequestMethod.POST, produces = "application/json")
    @PreAuthorize("hasAuthority('VISITOR')")
    public Result logout(@RequestBody User userData){
        System.out.println(userData.getNickname());
        PrintfMessage.logRequest("logout");
        return Result.success("允许退出");
    }

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
