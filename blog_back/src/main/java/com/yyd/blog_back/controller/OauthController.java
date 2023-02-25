package com.yyd.blog_back.controller;

import com.alibaba.fastjson.JSON;
import com.yyd.blog_back.common.ThirdlyResult;
import com.yyd.blog_back.service.OauthService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
@RequestMapping("/oauth")
@RestController
public class OauthController {


    @Autowired
    OauthService oauthService;

    /**
     * 1、用户点击使用 Gitee 作为第三方登录，后台重定向至gitee认证页面
     *
     * @param loginType
     * @param response
     * @throws IOException
     */
    @GetMapping("/login/{loginType}")
    public void thirdlyLogin(@PathVariable("loginType") String loginType, HttpServletResponse response) throws IOException {
        String url = oauthService.choiceLoginType(loginType);
        log.info(url);
        response.sendRedirect(url);
    }


    /**
     * 回调地址 这里就对应着我们在gitee创建第三方应用时填写的回调地址 这里会传回一个 code ，这个code 就是用户认证通过的授权码
     * <p>
     * http://127.0.0.1:8089/oauth/gitee/callback?code=xxxxebe2a67ba13xxxx925615aa89041
     * 其中 code 为用户授权码，由gitee授权服务器调用回调地址携带而来
     *
     * @param loginType
     * @param code
     * @param state     它并非是必填项，gitee调用回调地址时，其实没有携带这个参数，但是在oauth中有讲到，当时就写上去了。
     * @return
     */
    @ResponseBody
    @GetMapping("/{loginType}/callback")
    public String redirectUri(@PathVariable("loginType") String loginType, String code, String state) {
        log.info("code==>{}", code);
        //1、拿到这个code之后，我们要再向 gitee 服务起请求，获取 access_token 请注意这是一个post 请求
        // https://gitee.com/oauth/token?grant_type=authorization_code&code={code}&client_id={client_id}&redirect_uri={redirect_uri}&client_secret={client_secret}
        String result = oauthService.getOauthToken(loginType, code);
        ThirdlyResult thirdlyResult = JSON.parseObject(result, ThirdlyResult.class);
        /**
         * {
         * "access_token":"f7d851b2cdxx1fd491b",
         * "token_type":"bearer",
         * "expires_in":86400,
         * "refresh_token":"9f3098c7a8be09cd15xxcc38fb3dxxxb8e40f0800ced8",
         * "scope":"user_info",
         * "created_at":1661659283
         * }
         */
        // 2、拿到 access_token 以后发送一个get 请求，获取用户信息
        String userInfo = oauthService.getUserInfo(loginType, thirdlyResult.getAccessToken());
        return userInfo;
    }
}