package com.zwk.weibo.controller;

import com.alibaba.fastjson.JSONObject;
import com.zwk.weibo.entity.GenreEntity;
import com.zwk.weibo.service.GenreService;
import org.apache.commons.lang.StringUtils;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @ Author     ：zwk
 * @ Email      ：zwk0@qq.com
 * @ Date       ：Created in 2018-12-26 08:34
 * @ Description：
 */
@Controller
public class GenreController {

    @Autowired
    private GenreService genreService;

    @RequestMapping("/genreList")
    public String getGenreList(Model model){
        List<GenreEntity> genreLists=genreService.getGenreList();
        model.addAttribute("genreLists",genreLists);
        return "view/system/roleinfo/roleinfo_list";
    }


    @RequestMapping("/addGenrePost")
    public String addGenrePost(Model model){
        return "view/system/roleinfo/roleinfo_add";
    }

    @RequestMapping("/addGenre")
    public String addGenre(Model model, @Param("genreId")String genreId,@Param("genreDescription") String genreDescription,@Param("genreName") String genreName){
        GenreEntity genreEntity=new GenreEntity();
        genreEntity.setGenreName(genreName);
        genreEntity.setGenreDescription(genreDescription);
        if(StringUtils.isNotBlank(genreId)&&!genreId.equals("")){
            genreEntity.setGenreId(Long.parseLong(genreId));
            genreService.updateGenre(genreEntity);
        }else{
            genreService.insert(genreEntity);
        }
        return "forward:/genreList";
    }

    @RequestMapping("/selectGenre")
    public String selectGenre(Model model,@Param("genreName")String genreName){
        model.addAttribute("genreLists",genreService.selectGenreByName(genreName));
        return "view/system/roleinfo/roleinfo_list";
    }

    @RequestMapping("/deleteGenre")
    public String deleteGenre(Model model,@Param("genreId")Long genreId){
        genreService.deleteById(genreId);
        return "forward:/genreList";
    }

    @RequestMapping("/genreUpdate")
    public String genreUpdate(Model model,@Param("genreId")Long genreId,@Param("genreName")String genreName, @Param("genreDescription") String genreDescription){
        GenreEntity genreEntity=new GenreEntity();
        genreEntity.setGenreName(genreName);
        genreEntity.setGenreDescription(genreDescription);
        genreEntity.setGenreId(genreId);
        model.addAttribute("genreEntity",genreEntity);
        model.addAttribute("genreId",genreId);
        return "view/system/roleinfo/roleinfo_update";
    }

}
