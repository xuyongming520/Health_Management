package cn.healthy.manage.service;

import cn.healthy.manage.base.BaseResponse;
import cn.healthy.manage.domain.ProClass;

public interface ProClassService {
    BaseResponse addClass(ProClass proClass);

    BaseResponse updateClass(ProClass proClass);

    BaseResponse selectClassList();

    BaseResponse selectClass(Integer classId);

    BaseResponse deletedClass(Integer classId);
}
