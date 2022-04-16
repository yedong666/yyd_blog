package com.yyd.blog_back.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class ImgConfig implements WebMvcConfigurer {

    // 配置虚拟路径映射访问
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // 映射图片保存地址
        registry.addResourceHandler("/imgs/articleCoverImg/**")
                .addResourceLocations("file:C:\\Users\\lee\\Desktop\\myblog\\blog_back\\src\\main\\resources\\static\\imgs\\articleCoverImg\\");
    }
}
