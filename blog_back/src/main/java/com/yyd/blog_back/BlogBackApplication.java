package com.yyd.blog_back;

import com.huaban.analysis.jieba.JiebaSegmenter;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@MapperScan("com.yyd.blog_back.mapper")
public class BlogBackApplication {

	public static void main(String[] args) {
		SpringApplication.run(BlogBackApplication.class, args);
	}

	@Bean
	public JiebaSegmenter getJiebaSegmenter(){
		return new JiebaSegmenter();
	}
}
