package com.zwk.weibo.controller.Api;

import com.alibaba.fastjson.JSONObject;
import com.zwk.weibo.constant.Final;
import com.zwk.weibo.entity.MyCollectEntity;
import com.zwk.weibo.entity.ReceiveAddressEntity;
import com.zwk.weibo.service.MyCollectService;
import com.zwk.weibo.service.ReceiveAddressService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @ Author     ：zwk
 * @ Email      ：zwk0@qq.com
 * @ Date       ：Created in 2019-01-05 09:21
 * @ Description：
 */
@RestController
@Api(tags = "收货地址》",description = "接口")
@RequestMapping("/api/mycollect")
public class ReceiveAddressApi {

    @Autowired
    private ReceiveAddressService receiveAddressService;

    @ApiOperation("查询用户收货地址")
    @PostMapping("/addressList")
    public String getAddress(@RequestParam("userId") Long userId){
        List<ReceiveAddressEntity> addressList=receiveAddressService.getAddressList(userId);
        return JSONObject.toJSONString(addressList);
    }

    @ApiOperation("新增用户收货地址")
    @PostMapping("/insertAddress")
    public String insertAddress(@RequestParam("addressInfo")String addressInfo){
        JSONObject json=JSONObject.parseObject(addressInfo);
        ReceiveAddressEntity receiveAddressEntity=JSONObject.toJavaObject(json,ReceiveAddressEntity.class);

        receiveAddressService.insertAddress(receiveAddressEntity);
        return Final.SUCCESS;
    }
    @ApiOperation("修改用户默认收货地址")
    @PostMapping("/defaultAddress")
    public String defaultAddress(@RequestParam("addressId")Long addressId, @RequestParam("userId")Long userId){
        if(receiveAddressService.defaultAddress(addressId, userId).equals(Final.SUCCESS)){
            return Final.SUCCESS;
        }
        return Final.EMPTY;
    }
}
