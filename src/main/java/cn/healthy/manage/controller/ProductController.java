package cn.healthy.manage.controller;


import cn.healthy.manage.base.BaseResponse;
import cn.healthy.manage.base.PageParams;
import cn.healthy.manage.domain.Image;
import cn.healthy.manage.domain.Product;
import cn.healthy.manage.request.ProductPageRequest;
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

    @PostMapping("/selectProductList")
    public BaseResponse selectProductList(@RequestBody ProductPageRequest request){
        return BaseResponse.createSuccessResponse(productService.selectProductList(request));
    }

    @GetMapping("/selectProduct")
    public BaseResponse selectProduct(@PathParam("productId") Integer productId){
        return productService.selectProduct(productId);
    }

    @PostMapping("/updateProduct")
    public BaseResponse updateProduct(@RequestBody Product product){
        return productService.updateProduct(product);
    }

    @PostMapping("/images")
    public BaseResponse images(@RequestBody Image image){
        return productService.images(image);
    }
}
