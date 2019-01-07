package com.zwk.weibo.controller;

import com.zwk.weibo.entity.FoodEntity;
import com.zwk.weibo.service.FoodService;
import com.zwk.weibo.service.GenreService;
import com.zwk.weibo.utils.FileNameUtils;
import com.zwk.weibo.utils.FileUtils;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.net.URL;
import java.util.Map;

/**
 * @ Author     ：zwk
 * @ Email      ：zwk0@qq.com
 * @ Date       ：Created in 2018-12-27 16:44
 * @ Description：
 */
@Controller
public class FoodController {

    @Autowired
    private FoodService foodService;

    @Autowired
    private GenreService genreService;

    @RequestMapping("/foodList")
    public String foodList(Model model){
        model.addAttribute("foodLists",foodService.selectAllFood());
        return "view/system/food/food_list";
    }

    @RequestMapping("/addFoodPost")
    public String addFoodPost(Model model){
        model.addAttribute("genreList",genreService.getGenreList());
        return "view/system/food/food_add";
    }

    @RequestMapping("/addFood")
    public String upload(@RequestParam("fileName") MultipartFile fileName, @RequestParam Map<String,Object> foodInfo, HttpServletRequest request){

        foodInfo.put("foodPic",fileName.getOriginalFilename());
        Object obj=foodInfo.get("foodId");

        // 要上传的目标文件存放路径
        String returnUrl = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() +"/upload/imgs/";//存储路径
        String localPath = request.getSession().getServletContext().getRealPath("img"); //文件存储位置
        String realFileName=FileNameUtils.getFileName(fileName.getOriginalFilename());

        if (FileUtils.upload(fileName, localPath, realFileName)){
            foodInfo.put("foodPic",realFileName);
            foodService.insertFood(foodInfo);
        }
        return "forward:/foodList";
    }

    @RequestMapping("/selectFood")
    public String selectFoodByName(Model model,@Param("foodName")String foodName){
        model.addAttribute("foodLists",foodService.selectFoodByName(foodName));
        model.addAttribute("fooeName",foodName);
        return "view/system/food/food_list";
    }

    @RequestMapping("/deleteFood")
    public String deleteFood(Model model,@Param("foodId")Long foodId){
        foodService.deleteFood(foodId);
        return "forward:foodList";
    }

    @RequestMapping("/updateFood")
    public String updateFood(Model model,@Param("foodId")String foodId){
        FoodEntity foodEntity=foodService.selectById(foodId);
        model.addAttribute("food",foodEntity);
        model.addAttribute("genreList",genreService.getGenreList());
        return "view/system/food/food_update";
    }

}
