package com.yyd.blog_back.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


import java.util.Collections;

/**
 * 关于跨域问题踩的坑
 * 1.不同springBoot版本的跨域相关配置可能不同，例如springBoot2.2.x与sprigBoot2.5。x
 * 2.对于vue+springBoot项目, 在服务端配置跨域后还需在前端添加相关配置(vue.config.js)
 */

@Configuration
public class MvcConfig implements WebMvcConfigurer {

    //资源文件地址
    @Value("${project.file.path}")
    private String filepath;

    /**
     * 跨域配置
     * @return
     */
    @Bean
    public CorsFilter corsFilter() {
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        //1,允许任何来源
        corsConfiguration.setAllowedOriginPatterns(Collections.singletonList("*"));
        //2,允许任何请求头
        corsConfiguration.addAllowedHeader(CorsConfiguration.ALL);
        //3,允许任何方法
        corsConfiguration.addAllowedMethod(CorsConfiguration.ALL);
        //4,允许凭证
        corsConfiguration.setAllowCredentials(true);

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();

        source.registerCorsConfiguration("/**", corsConfiguration);
        return new CorsFilter(source);
    }

    /**
     * 配置虚拟路径映射访问
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // 映射图片保存地址
        //文章封面
        registry.addResourceHandler("/imgs/articleCoverImg/**")
                .addResourceLocations("file:" + filepath + "imgs/articleCoverImg/");
        //标签封面
        registry.addResourceHandler("/imgs/tagImg/**")
                .addResourceLocations("file:" + filepath + "imgs/tagImg/");
        //头像
        registry.addResourceHandler("/imgs/avaterImg/**")
                .addResourceLocations("file:" + filepath + "imgs/avaterImg/");
    }
}
