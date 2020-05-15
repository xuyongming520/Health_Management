package cn.healthy.manage.service;

import cn.healthy.manage.base.BaseResponse;
import cn.healthy.manage.base.PageParams;
import cn.healthy.manage.domain.Orders;
import cn.healthy.manage.domain.OrdersChild;
import cn.healthy.manage.request.OrderPageRequest;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.sun.org.apache.xpath.internal.operations.Or;

import java.util.List;

public interface OrdersService extends IService<Orders> {
    BaseResponse selectOrdersList(PageParams page);

    BaseResponse selectOrders(Integer orderId);

    BaseResponse updateOrdersStatus(Orders order);

    BaseResponse addOrders(Orders order);

    BaseResponse addOrdersByCar(List<Orders> order);

    IPage<Orders> selectOrdersListByUserId(OrderPageRequest request);

    BaseResponse returnGoods(Orders order);

    BaseResponse evaluate(Orders order);
}
