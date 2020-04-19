package cn.healthy.manage.mapper;

import cn.healthy.manage.domain.ShoppingCar;
import cn.healthy.manage.domain.ShoppingCarChild;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
@Mapper
public interface ShoppingCarMapper extends BaseMapper<ShoppingCar>{
    public List<ShoppingCarChild> selectShoppingCarList(ShoppingCar shoppingCar);

    public int countShoppingCar();

    public int addShoppingCar(ShoppingCar shoppingCar);

    public int deletedCar(Integer carId);
}
