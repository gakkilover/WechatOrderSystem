package com.zwk.weibo.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * @ Author     ：zwk
 * @ Email      ：zwk0@qq.com
 * @ Date       ：Created in 2019-01-21 14:55
 * @ Description：mq 配置类
 */
@Configuration
public class MqTestConfig {

    @Bean
    public Queue testQuue(){
        return new Queue("hello");
    }
}
