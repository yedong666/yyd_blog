package com.yyd.blog_back.controller;

import com.yyd.blog_back.common.Result;
import com.yyd.blog_back.common.util.PrintUtil;
import com.yyd.blog_back.entity.User;
import com.yyd.blog_back.entity.UserData;
import com.yyd.blog_back.service.LoginService;
import com.yyd.blog_back.service.UserDataService;
import com.yyd.blog_back.service.UserService;
import com.yyd.blog_back.vo.UserDataVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


@Api(tags = "用户管理接口")
@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private UserDataService userDataService;

    @Autowired
    private LoginService loginService;

    @ApiOperation("获取所有用户的所有信息")
    @ApiResponse(code = 200, message = "request suc!", response = Result.class)
    @RequestMapping("check_users")
    @PreAuthorize("hasAuthority('ROOT')")
    public Result checkUsers(){
        return Result.suc(userService.getAllUsers());
    }

    @ApiOperation("获取所有用户公开信息")
    @ApiResponse(code = 200, message = "request suc!", response = Result.class)
    @RequestMapping("getUsers")
    @PreAuthorize("hasAuthority('MANAGER')")
    public Result getUsers(){
        return Result.suc(userService.getUserVoList());
    }

    @ApiOperation("根据Id获取用户")
    @RequestMapping("getUserById")
    @PreAuthorize("hasAuthority('VISITOR')")
    public Result getUserById(@Param("id") Integer id){
        User user = userService.getUserById(id);
        if (user == null){
            return Result.fail();
        }
        return Result.suc(user);
    }

    @ApiOperation("根据账号密码登录")
    @RequestMapping("login")
    @PreAuthorize("hasAuthority('VISITOR')")
    public Result login(@Param("account") String account, @Param("password") String password){
        Map<String, Object> map = loginService.login(account, password);
        if(map == null){
            return Result.fail();
        }
        return Result.suc(map);
    }

    @ApiOperation("注销登录状态")
    @RequestMapping(value="logout", method = RequestMethod.POST, produces = "application/json")
    @PreAuthorize("hasAuthority('USER')")
    public Result logout(@RequestBody User userData){
        System.out.println(userData.getNickname());
        PrintUtil.logRequest("logout");
        return Result.suc("允许退出");
    }

    @ApiOperation("注册账号")
    @RequestMapping(value = "register", method = RequestMethod.POST, produces = "application/json")
    public Result register(@RequestBody User userData){
        System.out.println(userData.toString());
        PrintUtil.logRequest("register");
        User newUser = userService.register(userData);
        if(newUser == null){
            return Result.fail();
        }
        return Result.suc(newUser);
    }

    @ApiOperation("获取展示在用户主页的个人信息")
    @RequestMapping(value = "getUserHomeData", method = RequestMethod.GET, produces = "application/json")
    public Result getUserData(Integer id){
        User user = userService.getUserById(id);
        UserData userData = userDataService.getUserDataById(user.getUserDataId());
        UserDataVo userDataVo = userDataVo = new UserDataVo(user, userData);
        return Result.suc(userDataVo);
    }

    @ApiOperation("设置用户主页的个人信息")
    @RequestMapping(value = "getUserHomeData", method = RequestMethod.POST, produces = "application/json")
    public Result getUserData(UserDataVo userDataVo){
        return Result.suc(userService.updateUser(userDataVo));
    }

}
