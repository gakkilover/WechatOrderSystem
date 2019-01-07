package com.zwk.weibo.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.zwk.weibo.dao.AdminDao;
import com.zwk.weibo.entity.AdminEntity;
import com.zwk.weibo.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("testService")
public class TestServiceImpl  extends ServiceImpl<AdminDao,AdminEntity> implements TestService{

    @Autowired
    private AdminDao adminDao;

    @Override
    public List<AdminEntity> selectAll() {
        return adminDao.selectAll();
    }

    @Override
    public void insert() {
        AdminEntity adminEntity=new AdminEntity();
        adminEntity.setUsername("fecjew");
        adminEntity.setPassword("168498");
        adminDao.insert(adminEntity);
    }

}
