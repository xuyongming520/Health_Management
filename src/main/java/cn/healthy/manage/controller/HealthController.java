package cn.healthy.manage.controller;

import cn.healthy.manage.base.BaseResponse;
import cn.healthy.manage.base.PageParams;
import cn.healthy.manage.domain.Health;
import cn.healthy.manage.domain.User;
import cn.healthy.manage.mapper.HealthMapper;
import cn.healthy.manage.request.BmiRequest;
import cn.healthy.manage.request.DietRequest;
import cn.healthy.manage.request.UserBalanceRequest;
import cn.healthy.manage.service.HealthService;
import cn.healthy.manage.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;

@RestController
@RequestMapping("/health")
public class HealthController {
    @Autowired
    private HealthService healthService;

    @PostMapping("/BMI")
    public BaseResponse bmi(@RequestBody BmiRequest request){
        return healthService.bmi(request);
    }

    @PostMapping("/addHealth")
    public BaseResponse addHealth(@RequestBody Health health){
        return healthService.addHealth(health);
    }

    @PostMapping("/diet")
    public BaseResponse diet(DietRequest request){
        return healthService.diet(request);
    }

    @PostMapping("/query")
    public BaseResponse query(DietRequest request){
        return healthService.query(request);
    }

}

