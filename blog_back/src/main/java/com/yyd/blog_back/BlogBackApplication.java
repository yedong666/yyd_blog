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
		// 向服务器端发送请求，服务器IP地址和服务器监听的端口号
		Socket client = new Socket("116.62.242.203", 4560);

		// 通过printWriter 来向服务器发送消息
		PrintWriter printWriter = new PrintWriter(client.getOutputStream());
		System.out.println("连接已建立...");
		for(int i=0;i<10;i++) {
			// 发送消息
			printWriter.println("hello logstash , 这是第" + i + " 条消息");

			printWriter.flush();
		}
		SpringApplication.run(BlogBackApplication.class, args);
	}

	@Bean
	public JiebaSegmenter getJiebaSegmenter(){
		return new JiebaSegmenter();
	}
}
