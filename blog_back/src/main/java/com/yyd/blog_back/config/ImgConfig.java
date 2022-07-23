package com.yyd.blog_back.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class ImgConfig implements WebMvcConfigurer {
    @Value("${file.location}")
    private String filelocation;
    // 配置虚拟路径映射访问
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // 映射图片保存地址
        //文章封面
        registry.addResourceHandler("/imgs/articleCoverImg/**")
                .addResourceLocations("file:" + filelocation + "imgs\\articleCoverImg\\");
        //标签封面
        registry.addResourceHandler("/imgs/tagImg/**")
                .addResourceLocations("file:" + filelocation + "imgs\\tagImg\\");
        //头像
        registry.addResourceHandler("/imgs/avaterImg/**")
                .addResourceLocations("file:" + filelocation + "imgs\\avaterImg\\");
    }
}
