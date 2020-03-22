package cn.healthy.manage.mapper;

import cn.healthy.manage.domain.Orders;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface OrdersMapper {
    public List<Orders> selectOrdersList(@Param("offset")Integer offset,
                                        @Param("limit")Integer limit);

    public List<Orders> selectByOrdersId(@Param("orderId")Integer orderId);

    public int updateByOrdersId(Orders order);

    public int countOrders();
}
