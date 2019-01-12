package com.zwk.weibo.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.zwk.weibo.entity.GenreEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @ Author     ：zwk
 * @ Email      ：zwk0@qq.com
 * @ Date       ：Created in 2018-12-26 08:35
 * @ Description：
 */
@Mapper
public interface GenreDao extends BaseMapper<GenreEntity> {

    @Select(" SELECT * FROM GENRE WHERE 1=1 ")
    List<GenreEntity> getGenreList();

    @Select(" SELECT MAX(GENRE_ID)+1 FROM GENRE ")
    Long getMaxId();

    @Select(" SELECT * FROM GENRE WHERE GENRE_NAME like CONCAT('%',#{genreName},'%') ")
    List<GenreEntity> selectByName(String genreName);

    @Select(" SELECT * FROM GENRE WHERE GENRE_NAME =#{genreName} ")
    GenreEntity selectOneByName(String genreName);
}
