package com.zwk.weibo.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.zwk.weibo.entity.GenreEntity;

import java.util.List;

/**
 * @ Author     ：zwk
 * @ Email      ：zwk0@qq.com
 * @ Date       ：Created in 2018-12-25 15:24
 * @ Description：
 */
public interface GenreService extends IService<GenreEntity> {

    List<GenreEntity> getGenreList();

    String insertGenre(GenreEntity genreEntity);

    List<GenreEntity> selectGenreByName(String genreName);

    Integer deleteById(Long genreId);

    Integer updateGenre(GenreEntity genreEntity);
}
