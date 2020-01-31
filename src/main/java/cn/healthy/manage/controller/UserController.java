package cn.healthy.manage.controller;

import cn.healthy.manage.base.BaseResponse;
import cn.healthy.manage.domain.User;
import cn.healthy.manage.service.UserService;
import com.fasterxml.jackson.databind.ser.Serializers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @PostMapping("/login")
    public BaseResponse login(@RequestBody User user){
        return userService.login(user);
    }

    @PostMapping("/register")
    public BaseResponse register(@RequestBody User user){
        return userService.register(user);
    }

    @PostMapping("/updateUser")
    public BaseResponse updateUser(@RequestBody User user){
        return userService.updateUser(user);
    }

    @PostMapping("/selectAllUser")
    public BaseResponse selectAllUser(){
        return userService.selectAllUser();
    }

    @GetMapping("/selectUser")
    public BaseResponse selectUser(@PathParam("userId") Integer userId){
        return userService.selectUser(userId);
    }
}
