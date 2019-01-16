package com.zwk.weibo.utils;

import com.zwk.weibo.service.FoodService;
import com.zwk.weibo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @ Author     ：zwk
 * @ Email      ：zwk0@qq.com
 * @ Date       ：Created in 2019-01-14 17:16
 * @ Description：
 */

public class CacheData {


    private UserService userService=(UserService) SpringContextUtils.getBean("userService");


    private FoodService foodService=(FoodService) SpringContextUtils.getBean("foodService");

    /**
     * 数据存入缓存（更新操作）
     */

    public void refreshCache(){
        List userList=userService.selectAllUser();
        CacheUtil.set(CacheUtil.Table.USER.getKey(),userList);

        List foodList=foodService.selectAllFood();
        CacheUtil.set(CacheUtil.Table.FOOD.getKey(),foodList);
    }


}
