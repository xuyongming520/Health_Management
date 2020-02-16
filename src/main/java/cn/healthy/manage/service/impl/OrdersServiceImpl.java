package cn.healthy.manage.service.impl;

import cn.healthy.manage.base.BaseResponse;
import cn.healthy.manage.base.PageParams;
import cn.healthy.manage.domain.Orders;
import cn.healthy.manage.mapper.OrdersMapper;
import cn.healthy.manage.service.OrdersService;
import cn.healthy.manage.utils.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrdersServiceImpl implements OrdersService {

    @Autowired
    private OrdersMapper ordersMapper;

    @Override
    public BaseResponse selectOrdersList(PageParams page){
        Integer count = ordersMapper.countOrders();
        PageBean pageBean = new PageBean(page.getCurrentPage(),count,page.getPageSize());
        List<Orders> orderList = ordersMapper.selectOrdersList(pageBean.getStart(),page.getPageSize());
        pageBean.setList(orderList);
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setCode(0);
        baseResponse.setMsg("查询成功");
        baseResponse.setData(pageBean);
        return baseResponse;
    }

    public BaseResponse selectOrders(Integer orderId){
        BaseResponse baseResponse = new BaseResponse();
        List<Orders> ordersInfo=ordersMapper.selectByOrdersId(orderId);
        if(ordersInfo == null){
            baseResponse.setCode(1);
            baseResponse.setMsg("查询失败");
        }else {
            baseResponse.setCode(0);
            baseResponse.setMsg("查询成功");
            baseResponse.setData(ordersInfo);
        }
        return baseResponse;
    }

    public BaseResponse updateOrdersStatus(Orders orders){
        BaseResponse baseResponse = new BaseResponse();
        if(ordersMapper.updateByOrdersId(orders) == 0){
            baseResponse.setCode(1);
            baseResponse.setMsg("修改失败");
        }else{
            baseResponse.setCode(0);
            baseResponse.setMsg("修改成功");
        }
        return baseResponse;
    }
}