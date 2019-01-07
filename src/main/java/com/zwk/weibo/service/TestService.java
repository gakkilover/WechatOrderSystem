package com.zwk.weibo.service;

import com.baomidou.mybatisplus.service.IService;
import com.zwk.weibo.entity.AdminEntity;

import java.util.List;

public interface TestService extends IService<AdminEntity> {

    List<AdminEntity> selectAll();

    void insert();
}
