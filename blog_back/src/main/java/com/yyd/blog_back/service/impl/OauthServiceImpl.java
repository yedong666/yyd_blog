package com.yyd.blog_back.service.impl;

import cn.hutool.http.HttpUtil;
import com.yyd.blog_back.common.constValue.ThirdlyLoginTypeVal;
import com.yyd.blog_back.config.GiteeConfig;
import com.yyd.blog_back.service.OauthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * @author: Ning Zaichun
 * @date: 2022年08月28日 12:42
 */
@Service
public class OauthServiceImpl implements OauthService {

    @Autowired
    GiteeConfig giteeProperties;

    @Override
    public String choiceLoginType(String loginType) {
        String url = "";
        if (ThirdlyLoginTypeVal.GITEE.equals(loginType)) {
            url = ThirdlyLoginTypeVal.GITEE_URL
                    .replace("{client_id}", giteeProperties.getClientId())
                    .replace("{redirect_uri}", giteeProperties.getRedirectUri());
        }
        return url;
    }

    @Override
    public String getOauthToken(String loginType, String code) {
        Map<String, Object> map = new HashMap<>();
        String result = "";
        if (ThirdlyLoginTypeVal.GITEE.equals(loginType)) {
            String url = ThirdlyLoginTypeVal.GITEE_OAUTH_TOKEN_URL;
            map.put("grant_type", "authorization_code");
            map.put("code", code);
            map.put("client_id", giteeProperties.getClientId());
            map.put("client_secret", giteeProperties.getClientSecret());
            map.put("redirect_uri", giteeProperties.getRedirectUri());
            //发送get请求并接收响应数据
            result = HttpUtil.createPost(url).form(map).execute().body();
        }
        return result;
    }

    @Override
    public String getUserInfo(String loginType, String accessToken) {
        String userInfo = "";
        if (ThirdlyLoginTypeVal.GITEE.equals(loginType)) {
            String userInfoUrl = "https://gitee.com/api/v5/user?access_token=" + accessToken;
            userInfo = HttpUtil.createGet(userInfoUrl).execute().body();
        }
        return userInfo;
    }
}