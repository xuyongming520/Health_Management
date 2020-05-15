package cn.healthy.manage.mapper;

import cn.healthy.manage.domain.Orders;
import cn.healthy.manage.domain.OrdersChild;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface OrdersMapper extends BaseMapper<Orders> {
    public List<Orders> selectOrdersList(@Param("offset")Integer offset,
                                        @Param("limit")Integer limit);

    public List<OrdersChild> selectByOrdersId(@Param("orderId")Integer orderId);

    public int updateByOrdersId(Orders order);

    public int countOrders();

    public int addOrders(Orders order);

    public int returnGoods(Orders order);

    public int evaluate(Orders order);
}
