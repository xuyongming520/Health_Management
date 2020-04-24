package cn.healthy.manage.service.impl;

import cn.healthy.manage.base.BaseResponse;
import cn.healthy.manage.domain.Exercise;
import cn.healthy.manage.mapper.ExerciseMapper;
import cn.healthy.manage.service.ExerciseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExerciseServiceImpl implements ExerciseService {

    @Autowired
    private ExerciseMapper exerciseMapper;
    @Override
    public BaseResponse selectExerciseList(Exercise exercise){
        List<Exercise> exerciseList = exerciseMapper.selectExercise(exercise);
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setCode(0);
        baseResponse.setMsg("查询成功");
        baseResponse.setData(exerciseList);
        return baseResponse;
    }
}
