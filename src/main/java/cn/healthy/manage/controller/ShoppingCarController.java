package cn.healthy.manage.controller;

import cn.healthy.manage.base.BaseResponse;
import cn.healthy.manage.domain.ShoppingCar;
import cn.healthy.manage.service.ShoppingCarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;

@RestController
@RequestMapping("/shoppingcart")
public class ShoppingCarController {
    @Autowired
    private ShoppingCarService shoppingCarService;

    @PostMapping("/selectShoppingCartList")
    public BaseResponse selectShoppingCartList(@RequestBody ShoppingCar shoppingCar){
        return shoppingCarService.selectShoppingCarList(shoppingCar);
    }

    @PostMapping("/addShoppingCart")
    public BaseResponse addShoppingCar(@RequestBody ShoppingCar shoppingCar){
        return shoppingCarService.addShoppingCar(shoppingCar);
    }

    @DeleteMapping("/deleteCar")
    public BaseResponse deletedCar(@PathParam("carId") Integer carId){
        return shoppingCarService.deletedCar(carId);
    }

}
