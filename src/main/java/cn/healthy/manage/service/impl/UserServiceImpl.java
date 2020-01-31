package cn.healthy.manage.service.impl;

import cn.healthy.manage.base.BaseResponse;
import cn.healthy.manage.domain.User;
import cn.healthy.manage.mapper.UserMapper;
import cn.healthy.manage.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;
    @Override
    public BaseResponse login(User user) {
        BaseResponse baseResponse = new BaseResponse();
        User userInfo=userMapper.selectByPhone(user.getPhone());
        if(userInfo == null){
            baseResponse.setCode(1);
            baseResponse.setMsg("该账号未注册");
            return baseResponse;
        }
        if(!userInfo.getPassword().equals(user.getPassword())){
            baseResponse.setCode(2);
            baseResponse.setMsg("密码错误");
        }else{
            baseResponse.setCode(0);
            baseResponse.setMsg("登陆成功");
        }
        return baseResponse;
    }

    public BaseResponse register(User user){
        BaseResponse baseResponse = new BaseResponse();
        User userInfo=userMapper.selectByPhone(user.getPhone());
        if(userInfo != null) {
            baseResponse.setCode(1);
            baseResponse.setMsg("该账号已注册");
            return baseResponse;
        }else{
            user.setCreateTime(new Date());
            int judge = userMapper.addByUser(user);
            if(judge == 0 ){
                baseResponse.setCode(2);
                baseResponse.setMsg("注册失败");
            }else{
                baseResponse.setCode(0);
                baseResponse.setMsg("注册成功");
            }
        }
        return baseResponse;
    }

    public BaseResponse updateUser(User user){
        BaseResponse baseResponse = new BaseResponse();
        if(userMapper.updateByUser(user) == 0){
            baseResponse.setCode(1);
            baseResponse.setMsg("修改失败");
        }else{
            baseResponse.setCode(0);
            baseResponse.setMsg("修改成功");
        }
        return baseResponse;
    }

    public BaseResponse selectAllUser(){
        List<User> user = userMapper.selectAllUser();
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setCode(0);
        baseResponse.setMsg("查询成功");
        baseResponse.setData(user);
        return baseResponse;
    }

    public BaseResponse selectUser(Integer userId){
        BaseResponse baseResponse = new BaseResponse();
        User userInfo=userMapper.selectByUserId(userId);
        if(userInfo == null){
            baseResponse.setCode(1);
            baseResponse.setMsg("查询失败");
        }else {
            baseResponse.setCode(0);
            baseResponse.setMsg("查询成功");
            baseResponse.setData(userInfo);
        }
        return baseResponse;
    }
}
