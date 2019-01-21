package com.zwk.weibo.config;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @ Author     ：zwk
 * @ Email      ：zwk0@qq.com
 * @ Date       ：Created in 2019-01-21 14:47
 * @ Description：mq 消费者
 */
@RabbitListener(queues = "hello")
@Component
public class MqTestReceiver {

    @RabbitHandler
    public void handler(String content){
        System.out.println("接收到的消息"+content);
    }
}
