package com.yyd.blog_back.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Swagger2API文档的配置
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket createApi(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                //配置分组
                .groupName("yyd")
                //配置是否启动
                .enable(true)
                .select()
                /**
                 RequestHandlerSelectors：配置要扫描接口的方式
                 basePackage：指定要扫描的包
                 any()：扫描全部
                 none()：不扫描
                 withClassAnnotation：扫描类上的注解
                 withMethodAnnotation：扫描方法上的注解
                 **/
                .apis(RequestHandlerSelectors.basePackage("com.yyd.blog_back.controller"))
                //path()：过滤的路径
                //.path(PathSelectors.ant("/xxx/*"))
                .build();
    }

    private ApiInfo apiInfo(){
        return new ApiInfoBuilder()
                .title("Swagger2")
                .description("RestFul API接口")
                .version("1.0")
                .build();
    }


}