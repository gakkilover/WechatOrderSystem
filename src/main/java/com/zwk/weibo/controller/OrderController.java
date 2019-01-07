package com.zwk.weibo.controller;

import com.zwk.weibo.entity.OrderInfoEntity;
import com.zwk.weibo.service.FoodService;
import com.zwk.weibo.service.OrderDetailService;
import com.zwk.weibo.service.OrderService;
import io.swagger.annotations.ApiParam;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @ Author     ：zwk
 * @ Email      ：zwk0@qq.com
 * @ Date       ：Created in 2019-01-03 16:52
 * @ Description：
 */
@Controller
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private OrderDetailService orderDetailService;

    @RequestMapping("/orderList")
    public String orderList(Model model, @Param("userId")String userId){
        model.addAttribute("orderLists",orderService.selectAllOrder(userId));
        return "view/system/orderinfo/orderinfo_list";
    }

    @RequestMapping("/updateOrder")
    public String updateOrder(Model model,@Param("orderId")String orderId){
        OrderInfoEntity orderInfoEntity=orderService.selectById(orderId);
        model.addAttribute("order",orderInfoEntity);
        return "view/system/orderinfo/orderinfo_update";
    }

    @RequestMapping("/deleteOrder")
    public String deleteOrder(Model model,@Param("orderId")Long orderId){
        orderService.deleteById(orderId);
        return "forward:orderList";
    }

    @RequestMapping("/updateOrderPost")
    public String updateOrderPost(Model model, @Param("orderId")String orderId, @Param("status")String status,
                                  @Param("totalPrice")Float totalPrice, @Param("storeId")Long storeId, @Param("isPacked")String isPacked , @Param("userId")Long userId){
        OrderInfoEntity orderInfoEntity=orderService.selectById(orderId);
        if(orderInfoEntity!=null){
            orderInfoEntity.setTotalPrice(totalPrice);
            orderInfoEntity.setStoreId(storeId);
            orderInfoEntity.setUserId(userId);
            orderInfoEntity.setIsPacked(isPacked);
            orderInfoEntity.setStatus(status);
            orderService.insertOrUpdate(orderInfoEntity);
        }
        return "forward:orderList";
    }

    @RequestMapping("/refuseOrder")
    public String refuseOrder(Model model, @Param("orderId") Long orderId){
        String msg=orderService.refuseOrder(orderId);
        model.addAttribute("msg",msg);
        return "forward:orderList";
    }

    @RequestMapping("/acceptOrder")
    public String acceptOrder(Model model, @RequestParam("orderId") String orderId){

        String syt;
        String msg=orderService.acceptOrder(Long.parseLong(orderId));
        model.addAttribute("msg",msg);
        return "forward:orderList";
    }

    @RequestMapping("/orderDetail")
    public String orderDetail(Model model, @Param("orderId") Long orderId){

        model.addAttribute("orderDetailList",orderDetailService.orderDetailList(orderId));
        return "view/system/orderinfo/orderdetail_list";
    }

    @RequestMapping("/dispatch")
    public String dispatch(Model model, @Param("orderId") Long orderId){
        String msg=orderService.dispatch(orderId);
        model.addAttribute("msg",msg);
        return "forward:orderList";
    }

}
