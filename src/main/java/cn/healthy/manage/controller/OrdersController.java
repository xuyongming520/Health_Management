package cn.healthy.manage.controller;

import cn.healthy.manage.base.BaseResponse;
import cn.healthy.manage.base.PageParams;
import cn.healthy.manage.domain.Orders;
import cn.healthy.manage.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;

@RestController
@RequestMapping("/orders")
public class OrdersController {
    @Autowired
    private OrdersService ordersService;
    @PostMapping("/selectOrdersList")
    public BaseResponse selectOrderList(@RequestBody PageParams page){
        return ordersService.selectOrdersList(page);
    }

    @PostMapping("/updateOrdersStatus")
    public BaseResponse updateOrderStatus(@RequestBody Orders order){
        return ordersService.updateOrdersStatus(order);
    }

    @GetMapping("/selectOrders")
    public BaseResponse selectOrders(@PathParam("orderId") Integer orderId){
        return ordersService.selectOrders(orderId);
    }

}