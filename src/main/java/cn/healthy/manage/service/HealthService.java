package cn.healthy.manage.service;

import cn.healthy.manage.base.BaseResponse;
import cn.healthy.manage.base.PageParams;
import cn.healthy.manage.domain.Health;
import cn.healthy.manage.domain.User;
import cn.healthy.manage.request.BmiRequest;
import cn.healthy.manage.request.DietRequest;
import cn.healthy.manage.request.UserBalanceRequest;
import com.baomidou.mybatisplus.extension.service.IService;

import javax.swing.plaf.basic.BasicEditorPaneUI;

public interface HealthService extends IService<Health> {
    BaseResponse bmi(BmiRequest request);

    BaseResponse diet(DietRequest request);

    BaseResponse query(DietRequest request);

    BaseResponse addHealth(Health health);
}
