package com.yyd.blog_back;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.yyd.blog_back.mapper")
public class BlogBackApplication {

	public static void main(String[] args) {
		SpringApplication.run(BlogBackApplication.class, args);
	}

}
