package com.yyd.blog_back.config;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;


@Component
public class JwtConfig {
    public static final String REDIS_TOKEN_KEY_PREFIX = "TOKEN_";
    private long time = 432000;     // 5天(以秒s计)过期时间
    private String secret = "BlogSecret";// JWT密码
    private String prefix = "Bearer ";         // Token前缀
    private String header = "Authorization"; // 存放Token的Header Key

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }
}