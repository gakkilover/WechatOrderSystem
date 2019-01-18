package com.zwk.weibo.config;

import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ Author     ：zwk
 * @ Email      ：zwk0@qq.com
 * @ Date       ：Created in 2019-01-18 15:05
 * @ Description：quartz 配置
 */
@Configuration
public class QuartzConfig {

    @Bean
    public JobDetail testQuartzDetail(){
        return JobBuilder.newJob(TestSquartz.class).withIdentity("testQuartz").storeDurably().build();
    }

    @Bean
    public Trigger testQuartzTrigger(){
        SimpleScheduleBuilder builder=SimpleScheduleBuilder.simpleSchedule()
                .withIntervalInSeconds(11)
                .repeatForever();
        return TriggerBuilder.newTrigger().forJob(testQuartzDetail())
                .withIdentity("testQuartz")
                .withSchedule(builder)
                .build();

    }
}
