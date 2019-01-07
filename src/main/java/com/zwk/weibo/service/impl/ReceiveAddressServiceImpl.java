package com.zwk.weibo.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.zwk.weibo.dao.ReceiveAddressDao;
import com.zwk.weibo.entity.MyCollectEntity;
import com.zwk.weibo.entity.ReceiveAddressEntity;
import com.zwk.weibo.service.MyCollectService;
import com.zwk.weibo.service.ReceiveAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ Author     ：zwk
 * @ Email      ：zwk0@qq.com
 * @ Date       ：Created in 2019-01-05 09:20
 * @ Description：
 */
@Service("receiveAddressService")
public class ReceiveAddressServiceImpl extends ServiceImpl<ReceiveAddressDao,ReceiveAddressEntity> implements ReceiveAddressService {

    @Autowired
    private ReceiveAddressDao receiveAddressDao;

    @Override
    public List<ReceiveAddressEntity> getAddressList(Long userId) {

        return receiveAddressDao.getAddressList(userId);
    }

    @Override
    public void insertAddress(ReceiveAddressEntity address) {
        address.setAddressId(receiveAddressDao.getMaxId());
        receiveAddressDao.insert(address);
    }
}
