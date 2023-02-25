package com.yyd.blog_back;

import com.huaban.analysis.jieba.JiebaSegmenter;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

@SpringBootApplication
@MapperScan("com.yyd.blog_back.mapper")
public class BlogBackApplication {


	public static void main(String[] args) throws IOException {
		SpringApplication.run(BlogBackApplication.class, args);
	}

	@Bean
	public JiebaSegmenter getJiebaSegmenter(){
		return new JiebaSegmenter();
	}
}
