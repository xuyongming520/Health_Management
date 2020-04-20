package cn.healthy.manage.mapper;

import cn.healthy.manage.domain.Exercise;
import cn.healthy.manage.domain.Food;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface ExerciseMapper {

    public List<Exercise> selectExercise();
}
