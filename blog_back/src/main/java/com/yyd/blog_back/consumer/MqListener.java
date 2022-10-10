package com.yyd.blog_back.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MqListener {
    @RabbitListener(queues = "testqueue")
    public void testListener(String msg){
        System.out.println("已成功接收消息: " + msg);
    }

}
