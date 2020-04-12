package cn.healthy.manage.mapper;

import cn.healthy.manage.domain.ShoppingCar;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
@Mapper
public interface ShoppingCarMapper extends BaseMapper<ShoppingCar> {
//    public List<ShoppingCar> selectShoppingCarList(@Param("offset")Integer offset,
//                                                   @Param("limit")Integer limit,
//                                                   @Param("phone")String phone);

    public int countShoppingCar();

    public int addShoppingCar(ShoppingCar shoppingCar);
}
