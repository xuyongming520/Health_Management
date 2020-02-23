package cn.healthy.manage.service.impl;

import cn.healthy.manage.base.BaseResponse;
import cn.healthy.manage.base.PageParams;
import cn.healthy.manage.domain.Product;
import cn.healthy.manage.mapper.ProductMapper;
import cn.healthy.manage.service.ProductService;
import cn.healthy.manage.utils.PageBean;
import cn.healthy.manage.utils.UploadUtils;
import com.fasterxml.jackson.databind.ser.Serializers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public BaseResponse selectProductList(PageParams page){
        BaseResponse baseResponse = new BaseResponse();
        Integer count = productMapper.countProduct();
        PageBean pageBean = new PageBean(page.getCurrentPage(),count,page.getPageSize());
        List<Product> productList = productMapper.selectProductList(pageBean.getStart(),page.getPageSize());
        pageBean.setList(productList);
        baseResponse.setCode(0);
        baseResponse.setMsg("查询成功");
        baseResponse.setData(pageBean);
        return baseResponse;
    }

    public BaseResponse selectProduct(Integer productId){
        BaseResponse baseResponse = new BaseResponse();
        Product proInfo = productMapper.selectByProductId(productId);
        if(proInfo == null){
            baseResponse.setCode(1);
            baseResponse.setMsg("查询失败");
        }else {
            baseResponse.setCode(0);
            baseResponse.setMsg("查询成功");
            baseResponse.setData(proInfo);
        }
        return baseResponse;
    }

    public BaseResponse updateProduct(Product product){
        BaseResponse baseResponse = new BaseResponse();
        if(productMapper.updateByProduct(product) == 0 ){
            baseResponse.setCode(1);
            baseResponse.setMsg("修改失败");
        }else{
            baseResponse.setCode(0);
            baseResponse.setMsg("修改成功");
        }
        return baseResponse;
    }

    public BaseResponse images(Product product){
        BaseResponse baseResponse = new BaseResponse();
        UploadUtils uploadUtils = new UploadUtils();
        String imagesName = uploadUtils.upload(product.getPic());
        product.setPic(imagesName);
        if(productMapper.updateImages(product) == 0){
            baseResponse.setCode(1);
            baseResponse.setMsg("修改失败");
        }else{
            baseResponse.setCode(0);
            baseResponse.setMsg("修改成功");
        }
        return baseResponse;
    }
}
