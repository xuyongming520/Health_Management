package cn.healthy.manage.service.impl;

import cn.healthy.manage.base.BaseResponse;
import cn.healthy.manage.base.PageParams;
import cn.healthy.manage.domain.ShoppingCar;
import cn.healthy.manage.mapper.ShoppingCarMapper;
import cn.healthy.manage.request.ShoppingCarPageRequest;
import cn.healthy.manage.service.ShoppingCarService;
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
public class ShoppingCarServiceImpl extends ServiceImpl<ShoppingCarMapper,ShoppingCar> implements ShoppingCarService {
    @Autowired
    private ShoppingCarMapper shoppingCarMapper;

    @Override
    public IPage<ShoppingCar> selectShoppingCarList(ShoppingCarPageRequest request){
        QueryWrapper<ShoppingCar> queryWrapper = new QueryWrapper<>();
        LambdaQueryWrapper<ShoppingCar> lambdaQueryWrapper = queryWrapper.lambda();
        lambdaQueryWrapper.eq(ShoppingCar::getUserId,request.getUserId());
        return page(new Page<>(request.getCurrentPage(),request.getPageSize()),queryWrapper);
    }

    public BaseResponse addShoppingCar(ShoppingCar shoppingCar){
        if(saveOrUpdate(shoppingCar)){
            return BaseResponse.createSuccessResponse("新增成功");
        }else{
            return BaseResponse.createFailedResponse("新增失败");
        }
    }
}
