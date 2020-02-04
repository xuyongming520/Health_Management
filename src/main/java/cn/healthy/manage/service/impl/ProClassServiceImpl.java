package cn.healthy.manage.service.impl;

import cn.healthy.manage.base.BaseResponse;
import cn.healthy.manage.domain.ProClass;
import cn.healthy.manage.mapper.ProClassMapper;
import cn.healthy.manage.service.ProClassService;
import org.omg.PortableInterceptor.INACTIVE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProClassServiceImpl implements ProClassService {

    @Autowired
    private ProClassMapper proClassMapper;
    @Override
    public BaseResponse addClass(ProClass proClass){
        BaseResponse baseResponse = new BaseResponse();
        int judge = proClassMapper.addByClass(proClass);
        if(judge == 0){
            baseResponse.setCode(1);
            baseResponse.setMsg("添加失败");
        }
        else{
            baseResponse.setCode(0);
            baseResponse.setMsg("添加成功");
        }
        return baseResponse;
    }

    public BaseResponse updateClass(ProClass proClass){
        BaseResponse baseResponse = new BaseResponse();
        if(proClassMapper.updateByClass(proClass) == 0){
            baseResponse.setCode(1);
            baseResponse.setMsg("修改失败");
        }else{
            baseResponse.setCode(0);
            baseResponse.setMsg("修改成功");
        }
        return baseResponse;
    }

    public BaseResponse selectClassList(){
        BaseResponse baseResponse = new BaseResponse();
        List<ProClass> classList = proClassMapper.selectClassList();
        baseResponse.setCode(0);
        baseResponse.setMsg("查询成功");
        baseResponse.setData(classList);
        return baseResponse;
    }

    public BaseResponse selectClass(Integer classId){
        BaseResponse baseResponse = new BaseResponse();
        ProClass classInfo = proClassMapper.selectByClassId(classId);
        if(classInfo == null){
            baseResponse.setCode(1);
            baseResponse.setMsg("查询失败");
        }else{
            baseResponse.setCode(0);
            baseResponse.setMsg("查询成功");
            baseResponse.setData(classInfo);
        }
        return baseResponse;
    }

    public BaseResponse deletedClass(Integer classId){
        BaseResponse baseResponse = new BaseResponse();
        int judge = proClassMapper.deletedByClassId(classId);
        if(judge == 0){
            baseResponse.setCode(1);
            baseResponse.setMsg("删除失败");
        }
        else{
            baseResponse.setCode(0);
            baseResponse.setMsg("删除成功");
        }
        return baseResponse;
    }
}
