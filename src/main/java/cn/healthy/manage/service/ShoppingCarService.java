package cn.healthy.manage.service;

import cn.healthy.manage.base.BaseResponse;
import cn.healthy.manage.domain.ShoppingCar;
import com.baomidou.mybatisplus.extension.service.IService;

public interface ShoppingCarService extends IService<ShoppingCar>{

    BaseResponse selectShoppingCarList(ShoppingCar shoppingCar);

    BaseResponse addShoppingCar(ShoppingCar shoppingCar);

    BaseResponse deletedCar(Integer carId);
}
