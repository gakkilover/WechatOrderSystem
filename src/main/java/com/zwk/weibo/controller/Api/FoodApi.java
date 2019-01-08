package com.zwk.weibo.controller.Api;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.zwk.weibo.entity.FoodEntity;
import com.zwk.weibo.entity.vo.FoodVO;
import com.zwk.weibo.service.FoodService;
import com.zwk.weibo.service.GenreService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @ Author     ：zwk
 * @ Email      ：zwk0@qq.com
 * @ Date       ：Created in 2018-12-29 21:04
 * @ Description：
 */
@RestController
@Api(tags = "菜谱操作》",description = "接口")
@RequestMapping("/api/food")
public class FoodApi {

    @Autowired
    private FoodService foodService;

    @Autowired
    private GenreService genreService;

//    @ApiOperation("全部菜名")
//    @PostMapping(value = "/foodList")
//    public List<String> foodList(@ApiParam(value = "{\"id\":1,\"type\":0,\"name\":0}") @RequestBody JSONObject jsonObject){
//        List<FoodVO> list=foodService.selectAllFood();
//        List<String> json=new ArrayList<>();
//        for (FoodVO foodEntity:list) {
//            json.add(JSONObject.toJSONString(foodEntity));
//        }
//        return json;
//    }

    @ApiOperation("条件查询菜品")
    @PostMapping(value = "/foodListByGenre")
    public String foodListByGenre(@RequestParam("genreId")String genreId,@RequestParam("foodName")String foodName){
        List<FoodVO> list=null;
        if(genreId!=null&&genreId.equals("-1")){
            list=foodService.selectAllFood();

        } else if(genreId!=null&&genreId.equals("-2")){
            list=foodService.selectFoodByGenre(null,foodName);

        }else if(genreId!=null&&!genreId.equals("")){
            list=foodService.selectFoodByGenre(Long.parseLong(genreId),foodName);
        }
        return JSONObject.toJSONString(list);
    }


}
