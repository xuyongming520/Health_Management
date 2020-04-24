package cn.healthy.manage.mapper;

import cn.healthy.manage.domain.Food;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface FoodMapper {

    public List<Food> selectFood(Food food);
}
