package cn.healthy.manage.service.impl;

import cn.healthy.manage.base.BaseResponse;
import cn.healthy.manage.domain.*;
import cn.healthy.manage.mapper.HealthMapper;
import cn.healthy.manage.mapper.UserMapper;
import cn.healthy.manage.request.BmiRequest;
import cn.healthy.manage.request.DietRequest;
import cn.healthy.manage.service.HealthService;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class HealthServiceImpl extends ServiceImpl<HealthMapper, Health> implements HealthService {

    @Autowired
    private HealthMapper healthMapper;
    @Autowired
    private UserMapper userMapper;
    @Override
    public BaseResponse bmi(BmiRequest request) {
        BaseResponse baseResponse = new BaseResponse();
        HealthAll health = healthMapper.queryHealth(request);
        Double weight = health.getWeight().doubleValue();
        Double height = health.getHeight().doubleValue();
        Double bmi = height/(weight*weight);
        Double fatRate = 1.2*bmi + 0.23*health.getAge() -5.4-10.8*health.getSex();
        HealthReturn healthReturn = new HealthReturn();
        healthReturn.setBmi(bmi);
        healthReturn.setFatRate(fatRate);
        healthReturn.setHeight(health.getHeight());
        healthReturn.setWeight(health.getWeight());
        healthReturn.setWaistline(health.getWaistline());
        healthReturn.setHipline(health.getHipline());
        healthReturn.setChest(health.getChest());
        healthReturn.setWater(health.getWater());
        healthReturn.setSleep(health.getSleep());
        healthReturn.setDefecation(health.getDefecation());
        baseResponse.setData(healthReturn);
        return baseResponse;
    }

    public BaseResponse addHealth(Health health){
        Double weight = health.getWeight().doubleValue();
        Double height = health.getHeight().doubleValue();
        Double bmi = height/(weight*weight);
        Integer age =  userMapper.selectAge(health.getUserId());
        Integer sex =  userMapper.selectSex(health.getUserId());
        Double fatRate = 1.2*bmi + 0.23*age -5.4-10.8*sex;
        HealthReturn healthReturn = new HealthReturn();
        healthReturn.setBmi(bmi);
        healthReturn.setFatRate(fatRate);
        if(saveOrUpdate(health)){
            return BaseResponse.createSuccessResponse(healthReturn);
        }else {
            return BaseResponse.createFailedResponse("新增失败");
        }
    }

    @Override
    public BaseResponse diet(DietRequest request) {
        BaseResponse baseResponse = new BaseResponse();
        healthMapper.diet(request.getDate(),request.getId(),request.getType(),request.getFoods());

        return baseResponse;
    }

    @Override
    public BaseResponse query(DietRequest request) {
        BaseResponse baseResponse = new BaseResponse();
        Diet d = healthMapper.query(request.getDate(),request.getId());
        DietReturn dietReturn = new DietReturn();
        dietReturn.setFoods(JSONArray.parseArray(d.getContent()));
        dietReturn.setType(d.getType());
        baseResponse.setData(dietReturn);
        return baseResponse;
    }

}
