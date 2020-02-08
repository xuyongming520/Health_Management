package cn.healthy.manage.service;

import cn.healthy.manage.base.BaseResponse;
import cn.healthy.manage.base.PageParams;
import cn.healthy.manage.domain.Orders;

public interface OrdersService {
    BaseResponse selectOrdersList(PageParams page);

    BaseResponse selectOrders(Integer orderId);

    BaseResponse updateOrdersStatus(Orders order);
}
