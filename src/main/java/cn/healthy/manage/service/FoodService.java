package cn.healthy.manage.service;

import cn.healthy.manage.base.BaseResponse;
import cn.healthy.manage.domain.Food;

public interface FoodService {

    BaseResponse selectFoodList(Food food);
}
