package com.zwk.weibo.config;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @ Author     ：zwk
 * @ Email      ：zwk0@qq.com
 * @ Date       ：Created in 2019-01-18 14:17
 * @ Description：使用注解形式编写定时任务（Spring Task）
 */
@Component
public class TestScheduler {

    /**
     * 秒 分 时 天  月 星期 年
     * 0/10 *  *   *  *   ?
     */
    @Scheduled(cron="0/10 * * * * ?")
    public void show(){
        System.out.println("OtherScheduler：" + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss:SSS")));
    }
}
