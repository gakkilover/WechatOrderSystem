package com.zwk.weibo;


import com.zwk.weibo.service.FoodService;
import com.zwk.weibo.service.UserService;
import com.zwk.weibo.utils.CacheData;
import com.zwk.weibo.utils.CacheUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @ Author     ：zwk
 * @ Email      ：zwk0@qq.com
 * @ Date       ：Created in 2019-01-02 09:13
 * @ Description：
 */
@Component
public class InitApplicationRunner implements ApplicationRunner {

    @Autowired
    private UserService userService;

    @Autowired
    private FoodService foodService;
    @Override
    public void run(ApplicationArguments args) throws Exception {
        CacheData cacheData=new CacheData();
        cacheData.refreshCache();
    }


}
