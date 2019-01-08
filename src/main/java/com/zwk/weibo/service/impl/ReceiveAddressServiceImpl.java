package com.zwk.weibo.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.zwk.weibo.constant.Final;
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
        if(address.getAddressId()!=null){
            address.setDefaultAddress("0");
        }else {
            address.setAddressId(receiveAddressDao.getMaxId());
            address.setDefaultAddress("1");
        }
        this.insertOrUpdate(address);
    }

    @Override
    public String updateAddress(String type, ReceiveAddressEntity address) {
        if(type!=null&&type.equals("-1")){

        }
        return null;
    }

    @Override
    public String defaultAddress(Long addressId, Long userId) {
        List<ReceiveAddressEntity> addressList=receiveAddressDao.getAddressList(userId);
        for (ReceiveAddressEntity address:addressList) {
            if(addressId!=null&&addressId.equals(address.getAddressId())){
                address.setDefaultAddress("0");
            }else{
                address.setDefaultAddress("1");
            }
        }
        if(this.updateBatchById(addressList)){
            return Final.SUCCESS;
        }
        return Final.FAILURE;
    }
}
