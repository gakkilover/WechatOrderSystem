package com.zwk.weibo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@MapperScan("com.zwk.weibo.dao")
@ServletComponentScan("com.zwk.weibo.filter")
//@ComponentScan("com.zwk.weibo.config")
@EnableCaching
@EnableScheduling
public class ApiApplication {
    public static void main(String[] args){
        SpringApplication springApplication=new SpringApplication(ApiApplication.class);
        springApplication.setBannerMode(Banner.Mode.CONSOLE);
        springApplication.run(args);
    }

}
