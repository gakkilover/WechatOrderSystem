package com.zwk.weibo.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.zwk.weibo.entity.MyCollectEntity;
import com.zwk.weibo.entity.ReceiveAddressEntity;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @ Author     ：zwk
 * @ Email      ：zwk0@qq.com
 * @ Date       ：Created in 2019-01-05 09:19
 * @ Description：
 */
public interface ReceiveAddressDao extends BaseMapper<ReceiveAddressEntity> {

    @Select(" SELECT * FROM  RECEIVE_ADDRESS  WHERE USER_ID=#{userId} ")
    List<ReceiveAddressEntity> getAddressList(Long userId);

    @Select(" SELECT MAX(ADDRESS_ID)+1 from RECEIVE_ADDRESS  WHERE 1=1 ")
    Long getMaxId();
}
