package com.zwk.weibo.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.zwk.weibo.constant.Final;
import com.zwk.weibo.dao.GenreDao;
import com.zwk.weibo.entity.GenreEntity;
import com.zwk.weibo.service.GenreService;
import com.zwk.weibo.utils.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ Author     ：zwk
 * @ Email      ：zwk0@qq.com
 * @ Date       ：Created in 2018-12-26 08:38
 * @ Description：
 */
@Service("genreService")
public class GenreServiceImpl extends ServiceImpl<GenreDao,GenreEntity> implements GenreService {


    @Autowired
    private RedisConnectionFactory factory;

    @Autowired
    private RedisUtils redis;
    @Autowired
    private GenreDao genreDao;

    @Override
    public List<GenreEntity> getGenreList() {
        return genreDao.getGenreList();
    }

    @Override
    public String insertGenre(GenreEntity genreEntity) {
        GenreEntity genre=genreDao.selectOneByName(genreEntity.getGenreName());
        if(genre!=null){
            return "已存在该种类";
        }
        genreEntity.setGenreId(genreDao.getMaxId());
        genreEntity.setGenreState(Final.GENRE_ERROE_CODE);
        genreEntity.setStoreId(1L);
        genreDao.insert(genreEntity);
        return "插入成功";
    }

    @Override
    public List<GenreEntity> selectGenreByName(String genreName) {
        return genreDao.selectByName(genreName);
    }

    @Override
    public Integer deleteById(Long genreId) {
        return genreDao.deleteById(genreId);
    }

    @Override
    public Integer updateGenre(GenreEntity genreEntity) {
        return genreDao.updateById(genreEntity);
    }
}
