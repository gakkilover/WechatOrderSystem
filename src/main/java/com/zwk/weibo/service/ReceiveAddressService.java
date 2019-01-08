package com.zwk.weibo.service;

import com.baomidou.mybatisplus.service.IService;
import com.zwk.weibo.entity.MyCollectEntity;
import com.zwk.weibo.entity.ReceiveAddressEntity;

import java.util.List;

/**
 * @ Author     ：zwk
 * @ Email      ：zwk0@qq.com
 * @ Date       ：Created in 2018-12-25 15:26
 * @ Description：
 */
public interface ReceiveAddressService extends IService<ReceiveAddressEntity> {

    List<ReceiveAddressEntity> getAddressList(Long userId);

    void insertAddress(ReceiveAddressEntity address);

    String updateAddress(String type,ReceiveAddressEntity address);

    String defaultAddress(Long addressId, Long userId);
}
