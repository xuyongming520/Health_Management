package cn.healthy.manage.service.impl;

import cn.healthy.manage.base.BaseResponse;
import cn.healthy.manage.base.PageParams;
import cn.healthy.manage.domain.User;
import cn.healthy.manage.mapper.UserMapper;
import cn.healthy.manage.service.UserService;
import cn.healthy.manage.utils.PageBean;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper,User> implements UserService {

    @Autowired
    private UserMapper userMapper;
    @Override
    public BaseResponse login(User user) {
        BaseResponse baseResponse = new BaseResponse();
        User user1 = this
                .lambdaQuery()
                .eq(User::getPhone,user.getPhone())
                .one();
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
            baseResponse.setData(userInfo);
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
            if(save(user) ){
                user.setCreateTime(new Date());
                return BaseResponse.createSuccessResponse(0,"注册成功");
            }else{

                return BaseResponse.createFailedResponse(2,"注册失败");
            }
        }
    }

    public BaseResponse updateUser(User user){
        BaseResponse baseResponse = new BaseResponse();
        saveOrUpdate(user);
        if(userMapper.updateByUser(user) == 0){
            baseResponse.setCode(1);
            baseResponse.setMsg("修改失败");
        }else{
            baseResponse.setCode(0);
            baseResponse.setMsg("修改成功");
        }
        return baseResponse;
    }

    public BaseResponse selectUserList(PageParams page){
        Integer count = userMapper.countUser();
        PageBean pageBean = new PageBean(page.getCurrentPage(),count,page.getPageSize());
        List<User> userList = userMapper.selectUserList(pageBean.getStart(),page.getPageSize());
        pageBean.setList(userList);
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setCode(0);
        baseResponse.setMsg("查询成功");
        baseResponse.setData(pageBean);
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

    public BaseResponse selectUserByPhone(String phone){
        BaseResponse baseResponse = new BaseResponse();
        User userInfo=userMapper.selectByPhone(phone);
        if(userInfo == null){
            baseResponse.setCode(1);
            baseResponse.setMsg("未查到该用户");
        }else {
            baseResponse.setCode(0);
            baseResponse.setMsg("查询成功");
            baseResponse.setData(userInfo);
        }
        return baseResponse;
    }
}
