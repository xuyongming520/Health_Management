package cn.healthy.manage.controller;

import cn.healthy.manage.base.BaseResponse;
import cn.healthy.manage.domain.Exercise;
import cn.healthy.manage.service.ExerciseService;
import cn.healthy.manage.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/exercise")
public class ExerciseController {

    @Autowired
    private ExerciseService exerciseService;

    @PostMapping("/exerciseList")
    public BaseResponse exerciseList(@RequestBody Exercise exercise){
        return exerciseService.selectExerciseList(exercise);
    }
}
