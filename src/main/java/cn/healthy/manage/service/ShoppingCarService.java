package cn.healthy.manage.service;

import cn.healthy.manage.base.BaseResponse;
import cn.healthy.manage.base.PageParams;
import cn.healthy.manage.domain.ShoppingCar;
import cn.healthy.manage.request.ShoppingCarPageRequest;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

public interface ShoppingCarService extends IService<ShoppingCar> {

    IPage<ShoppingCar> selectShoppingCarList(ShoppingCarPageRequest request);

    BaseResponse addShoppingCar(ShoppingCar shoppingCar);
}
