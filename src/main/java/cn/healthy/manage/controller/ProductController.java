package cn.healthy.manage.controller;


import cn.healthy.manage.base.BaseResponse;
import cn.healthy.manage.domain.Product;
import cn.healthy.manage.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;
    @PostMapping("/addProduct")
    public BaseResponse addProduct(@RequestBody Product product){
        return productService.addProduct(product);
    }

    @DeleteMapping("/deletedProduct")
    public BaseResponse deletedProduct(@PathParam("productId") Integer productId){
        return productService.deletedProduct(productId);
    }
}
