package cn.healthy.manage.service.impl;

import cn.healthy.manage.base.BaseResponse;
import cn.healthy.manage.domain.Product;
import cn.healthy.manage.mapper.ProductMapper;
import cn.healthy.manage.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServicelImpl implements ProductService {
    @Autowired
    private ProductMapper productMapper;

    @Override
    public BaseResponse addProduct(Product product){
        BaseResponse baseResponse = new BaseResponse();
        int judge = productMapper.addByProduct(product);
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

    public BaseResponse deletedProduct(Integer productId){
        BaseResponse baseResponse = new BaseResponse();
        int judge = productMapper.deletedByProductId(productId);
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
