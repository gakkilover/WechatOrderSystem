package com.zwk.weibo.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.zwk.weibo.entity.FoodEntity;
import com.zwk.weibo.entity.vo.FoodVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @ Author     ：zwk
 * @ Email      ：zwk0@qq.com
 * @ Date       ：Created in 2018-12-27 16:38
 * @ Description：
 */
@Mapper
public interface FoodDao extends BaseMapper<FoodEntity> {

    @Select(" Select max(food_id)+1 from food where 1=1 ")
    Long getMaxId();

    @Select(" SELECT * FROM FOOD F LEFT JOIN STORE S ON F.STORE_ID=S.STORE_ID  WHERE 1=1 ")
    List<FoodVO> getFoodList();

    @Select(" SELECT * FROM FOOD F LEFT JOIN STORE S ON F.STORE_ID=S.STORE_ID WHERE FOOD_NAME LIKE CONCAT('%',#{foodName},'%') ")
    List<FoodVO> selectFoodByName(String foodName);

    @Select(" ${sql} ")
    List<FoodVO> selectFoodByGenre(@Param("sql") String sql);


}
