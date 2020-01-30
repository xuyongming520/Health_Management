package cn.healthy.manage.service.impl;

import cn.healthy.manage.domain.User;
import cn.healthy.manage.mapper.UserMapper;
import cn.healthy.manage.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;
    @Override
    public boolean login(User user) {
        User userInfo=userMapper.selectByPhone(user.getPhone());
        if(userInfo == null){
            return false;
        }
        if(userInfo.getPassword().equals(user.getPassword())){
            return true;
        }
        return false;
    }
}
