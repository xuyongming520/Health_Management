package cn.healthy.manage.controller;

import cn.healthy.manage.base.BaseResponse;
import cn.healthy.manage.domain.User;
import cn.healthy.manage.service.UserService;
import com.fasterxml.jackson.databind.ser.Serializers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @PostMapping("/login")
    public BaseResponse login(@RequestBody User user){
        BaseResponse loginBase = new BaseResponse();
        if(userService.login(user)){
            loginBase.setMsg("登陆成功");
            loginBase.setCode(0);
        }
        else {
            loginBase.setMsg("登陆失败");
            loginBase.setCode(1);
        }
        return loginBase;
    }
}
