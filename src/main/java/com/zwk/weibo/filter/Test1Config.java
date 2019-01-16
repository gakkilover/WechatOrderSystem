package com.zwk.weibo.filter;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ Author     ：zwk
 * @ Email      ：zwk0@qq.com
 * @ Date       ：Created in 2019-01-15 14:04
 * @ Description：
 */
@Configuration
public class Test1Config {

    @Bean
    public FilterRegistrationBean registFilter(){
        FilterRegistrationBean registration=new FilterRegistrationBean();
        registration.setFilter(new Test1Filter());
        registration.addUrlPatterns("/userList");
        registration.setName("Test1Filter");
        registration.setOrder(1);
        return registration;
    }
}
