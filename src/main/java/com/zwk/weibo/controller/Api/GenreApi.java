package com.zwk.weibo.controller.Api;

import com.alibaba.fastjson.JSONObject;
import com.zwk.weibo.entity.GenreEntity;
import com.zwk.weibo.service.GenreService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @ Author     ：zwk
 * @ Email      ：zwk0@qq.com
 * @ Date       ：Created in 2018-12-30 10:39
 * @ Description：
 */
@RestController
@RequestMapping("/api/genre")
@Api(tags = "种类操作接口》",description = "接口")
public class GenreApi {

    @Autowired
    private GenreService genreService;

    @ApiOperation(value = "查询所有菜品种类")
    @PostMapping("/genreList")
    public String genreList(){
        List<GenreEntity> list=genreService.getGenreList();

        return JSONObject.toJSONString(list);
    }

}
