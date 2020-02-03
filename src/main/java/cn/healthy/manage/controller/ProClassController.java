package cn.healthy.manage.controller;


import cn.healthy.manage.base.BaseResponse;
import cn.healthy.manage.domain.ProClass;
import cn.healthy.manage.service.ProClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;

@RestController
@RequestMapping("/proClass")
public class ProClassController {
    @Autowired
    private ProClassService proClassService;
    @PostMapping("/addClass")
    public BaseResponse addClass(@RequestBody ProClass proClass){
        return proClassService.addClass(proClass);
    }

    @PostMapping("/updateClass")
    public BaseResponse updateClass(@RequestBody ProClass proClass){
        return proClassService.updateClass(proClass);
    }

    @PostMapping("/selectClassList")
    public BaseResponse selectClassList(){
        return proClassService.selectClassList();
    }

    @GetMapping("/selectClass")
    public BaseResponse selectClass(@PathParam("classId") Integer classId){
        return proClassService.selectClass(classId);
    }
}
