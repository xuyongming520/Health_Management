package cn.healthy.manage.service.impl;

import cn.healthy.manage.base.BaseResponse;
import cn.healthy.manage.base.PageParams;
import cn.healthy.manage.domain.Orders;
import cn.healthy.manage.domain.OrdersChild;
import cn.healthy.manage.domain.User;
import cn.healthy.manage.mapper.OrdersMapper;
import cn.healthy.manage.mapper.ProductMapper;
import cn.healthy.manage.mapper.UserMapper;
import cn.healthy.manage.request.OrderPageRequest;
import cn.healthy.manage.service.OrdersService;
import cn.healthy.manage.utils.PageBean;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.omg.CORBA.ORB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

@Service
public class OrdersServiceImpl extends ServiceImpl<OrdersMapper,Orders> implements OrdersService {

    @Autowired
    private OrdersMapper ordersMapper;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private ProductMapper productMapper;

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
        List<OrdersChild> ordersInfo=ordersMapper.selectByOrdersId(orderId);
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

    public IPage<Orders> selectOrdersListByUserId(OrderPageRequest request){
        QueryWrapper<Orders> queryWrapper = new QueryWrapper<>();
        LambdaQueryWrapper<Orders> lambdaQueryWrapper = queryWrapper.lambda();
        lambdaQueryWrapper.eq(Orders::getUserId,request.getUserId());
        lambdaQueryWrapper.groupBy(Orders::getOrderId);
        lambdaQueryWrapper.orderByDesc(Orders::getCreateTime);
        return page(new Page<>(request.getCurrentPage(),request.getPageSize()),queryWrapper);
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

    public BaseResponse returnGoods(Orders order){
        BaseResponse baseResponse = new BaseResponse();
        if(ordersMapper.returnGoods(order) == 0){
            baseResponse.setCode(1);
            baseResponse.setMsg("退货失败");
        }else{
            baseResponse.setCode(0);
            baseResponse.setMsg("退货成功");
        }
        return baseResponse;
    }

    public BaseResponse evaluate(Orders order){
        BaseResponse baseResponse = new BaseResponse();
        if(ordersMapper.evaluate(order) == 1){
            baseResponse.setCode(0);
            baseResponse.setMsg("评价成功");
        }else{
            baseResponse.setCode(1);
            baseResponse.setMsg("评价失败");
        }
        return baseResponse;
    }


    public BaseResponse addOrders(Orders orders){
        BigDecimal balance = userMapper.selectBalance(orders.getUserId());
        BigDecimal total = orders.getTotal();
        Integer storage = productMapper.selectStorage(orders.getProId());
        orders.setCreateTime(new Date());
        if(balance.compareTo(orders.getTotal()) == -1){
            return BaseResponse.createFailedResponse(1,"余额不足");
        }else{
            BigDecimal userBalance =balance.subtract(total);
            Integer proStorage = storage - orders.getNumber();
            userMapper.updateBalance(orders.getUserId(),userBalance);
            productMapper.updateStorage(orders.getProId(),proStorage);
            if(saveOrUpdate(orders)){
                return BaseResponse.createSuccessResponse(0,"下单成功");
            }else {
                return BaseResponse.createFailedResponse(-1,"下单失败");
            }
        }

    }

    public BaseResponse addOrdersByCar(List<Orders> orders){
        for(int i =0;i<orders.size();i++){
            Orders order = orders.get(i);
            BigDecimal balance = userMapper.selectBalance(order.getUserId());
            BigDecimal total = order.getTotal();
            Integer storage = productMapper.selectStorage(order.getProId());
            order.setCreateTime(new Date());
            if(balance.compareTo(order.getTotal()) == -1){
                return BaseResponse.createFailedResponse(1,"余额不足");
            }else{
                BigDecimal userBalance =balance.subtract(total);
                Integer proStorage = storage - order.getNumber();
                userMapper.updateBalance(order.getUserId(),userBalance);
                productMapper.updateStorage(order.getProId(),proStorage);
                if(!saveOrUpdate(order)){
                    return BaseResponse.createFailedResponse(-1,"下单失败");
                }
            }
        }
        return BaseResponse.createSuccessResponse(0,"下单成功");
    }

}
