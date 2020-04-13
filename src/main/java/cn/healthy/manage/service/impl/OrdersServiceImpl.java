package cn.healthy.manage.service.impl;

import cn.healthy.manage.base.BaseResponse;
import cn.healthy.manage.base.PageParams;
import cn.healthy.manage.domain.Orders;
import cn.healthy.manage.domain.OrdersChild;
import cn.healthy.manage.domain.User;
import cn.healthy.manage.mapper.OrdersMapper;
import cn.healthy.manage.request.OrderPageRequest;
import cn.healthy.manage.service.OrdersService;
import cn.healthy.manage.utils.PageBean;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrdersServiceImpl extends ServiceImpl<OrdersMapper,Orders> implements OrdersService {

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

    public BaseResponse addOrders(Orders orders){
        if(saveOrUpdate(orders)){
            return BaseResponse.createSuccessResponse("新增成功");
        }else {
            return BaseResponse.createFailedResponse("新增失败");
        }
    }

    public BaseResponse addOrdersByCar(List<Orders> orders){
        if(saveOrUpdateBatch(orders)){
            return BaseResponse.createSuccessResponse("新增成功");
        }else{
            return BaseResponse.createFailedResponse("新增失败");
        }
    }

}
