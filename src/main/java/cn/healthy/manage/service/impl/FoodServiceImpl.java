package cn.healthy.manage.service.impl;

import cn.healthy.manage.base.BaseResponse;
import cn.healthy.manage.domain.Food;
import cn.healthy.manage.mapper.FoodMapper;
import cn.healthy.manage.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodServiceImpl implements FoodService {

    @Autowired
    private FoodMapper foodMapper;
    @Override
    public BaseResponse selectFoodList(){
        List<Food> foodList = foodMapper.selectFood();
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setCode(0);
        baseResponse.setMsg("查询成功");
        baseResponse.setData(foodList);
        return baseResponse;
    }
}
