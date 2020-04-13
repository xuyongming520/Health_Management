package cn.healthy.manage.service.impl;

import cn.healthy.manage.base.BaseResponse;
import cn.healthy.manage.domain.ShoppingCar;
import cn.healthy.manage.domain.ShoppingCarChild;
import cn.healthy.manage.mapper.ShoppingCarMapper;
import cn.healthy.manage.service.ShoppingCarService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShoppingCarServiceImpl extends ServiceImpl<ShoppingCarMapper,ShoppingCar> implements ShoppingCarService {
    @Autowired
    private ShoppingCarMapper shoppingCarMapper;

    @Override
    public BaseResponse selectShoppingCarList(ShoppingCar shoppingCar){
        BaseResponse baseResponse = new BaseResponse();
        List<ShoppingCarChild> shoppingCarList = shoppingCarMapper.selectShoppingCarList(shoppingCar);
        baseResponse.setCode(0);
        baseResponse.setMsg("查询成功");
        baseResponse.setData(shoppingCarList);
        return baseResponse;
    }

    public BaseResponse addShoppingCar(ShoppingCar shoppingCar){
        if(saveOrUpdate(shoppingCar)){
            return BaseResponse.createSuccessResponse("新增成功");
        }else{
            return BaseResponse.createFailedResponse("新增失败");
        }
    }
}
