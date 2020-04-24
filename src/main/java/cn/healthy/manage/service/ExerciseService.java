package cn.healthy.manage.service;

import cn.healthy.manage.base.BaseResponse;
import cn.healthy.manage.domain.Exercise;

public interface ExerciseService {

    BaseResponse selectExerciseList(Exercise exercise);
}
