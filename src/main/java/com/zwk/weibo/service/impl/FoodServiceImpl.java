package com.zwk.weibo.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.zwk.weibo.dao.FoodDao;
import com.zwk.weibo.entity.FoodEntity;
import com.zwk.weibo.entity.vo.FoodVO;
import com.zwk.weibo.service.FoodService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @ Author     ：zwk
 * @ Email      ：zwk0@qq.com
 * @ Date       ：Created in 2018-12-28 08:46
 * @ Description：
 */
@Service("foodService")
public class FoodServiceImpl extends ServiceImpl<FoodDao,FoodEntity> implements FoodService {

    @Autowired
    private FoodDao foodDao;

    @Override
    public void insertFood(Map<String,Object> foodInfo) {
        String obj=(String)foodInfo.get("foodId");
        FoodEntity foodEntity=new FoodEntity();
        String foodDetail=(String)foodInfo.get("foodDetail");
        String foodName=(String)foodInfo.get("foodName");
        Long genreId=Long.parseLong((String)foodInfo.get("genreId"));
        String foodPic=(String)foodInfo.get("foodPic");
        float foodPrice=Float.valueOf((String)foodInfo.get("foodPrice"));
        foodEntity.setFoodName(foodName);
        foodEntity.setFoodDetail(foodDetail);
        foodEntity.setGenreId(genreId);
        foodEntity.setFoodPic(foodPic);
        foodEntity.setFoodPrice(foodPrice);
        foodEntity.setStoreId(1L);
        foodEntity.setFoodId(foodDao.getMaxId());
        if(obj!=null&&StringUtils.isNotBlank(obj)){
            foodEntity.setFoodId(Long.parseLong(obj));
        }
        this.insertOrUpdate(foodEntity);
    }

    @Override
    public void updateFood(FoodEntity foodEntity) {
        this.updateById(foodEntity);
    }

    @Override
    public void deleteFood(Long foodId) {
        this.deleteById(foodId);
    }

    @Override
    public FoodEntity selectByFoodId(Long foodId) {
        return this.selectById(foodId);
    }

    @Override
    public List<FoodVO> selectAllFood() {
        List<FoodVO> foodList=foodDao.getFoodList();
        return foodList;
    }

    @Override
    public List<FoodVO> selectFoodByName(String foodName) {
        List<FoodVO> foodlist=null;
        if(foodName!=null) {
            foodlist = foodDao.selectFoodByName(foodName);
        }
        return foodlist;
    }

    @Override
    public List<FoodVO> selectFoodByGenre(Long genreId, String foodName) {
        StringBuffer sb=new StringBuffer();
        sb.append(" SELECT * FROM FOOD F LEFT JOIN GENRE g ON F.GENRE_ID=g.GENRE_ID where 1=1 ");
        if(genreId!=null&&!genreId.equals("")){
            sb.append("  and g.GENRE_ID=  "+genreId);
        }
        if(foodName!=null&&StringUtils.isNotBlank(foodName)){
            sb.append(" AND F.FOOD_NAME LIKE '%"+foodName+"%'");
        }

        return foodDao.selectFoodByGenre(sb.toString());
    }
}
