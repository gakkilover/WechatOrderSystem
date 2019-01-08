package com.zwk.weibo.service;

import com.baomidou.mybatisplus.service.IService;
import com.zwk.weibo.entity.FoodEntity;
import com.zwk.weibo.entity.vo.FoodVO;

import java.util.List;
import java.util.Map;

/**
 * @ Author     ：zwk
 * @ Email      ：zwk0@qq.com
 * @ Date       ：Created in 2018-12-25 15:24
 * @ Description：菜品的操作
 */
public interface FoodService extends IService<FoodEntity> {

    void insertFood(Map<String,Object> foodInfo);

    void updateFood(FoodEntity foodEntity);

    void deleteFood(Long foodId);

    FoodEntity selectByFoodId(Long foodId);

    List<FoodVO> selectAllFood();

    List<FoodVO> selectFoodByName(String foodName);

    List<FoodVO> selectFoodByGenre(Long genreId,String foodName);
}
