package com.zwk.weibo.config;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @ Author     ：zwk
 * @ Email      ：zwk0@qq.com
 * @ Date       ：Created in 2019-01-21 14:39
 * @ Description：mq 生产者
 */
@Component
public class MqTestSender {

    //RabbitTemplate是AmqpTemplate的实例
    @Autowired
    private AmqpTemplate amqpTemplate;

    public void send(){
       String content="安销测试开始喽 "+LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
       amqpTemplate.convertAndSend("阿尼哦",content);
    }
}
