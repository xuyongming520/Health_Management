package cn.healthy.manage.service.impl;

import cn.healthy.manage.base.BaseResponse;
import cn.healthy.manage.base.PageParams;
import cn.healthy.manage.domain.Image;
import cn.healthy.manage.domain.Product;
import cn.healthy.manage.domain.ProductChild;
import cn.healthy.manage.mapper.ProductMapper;
import cn.healthy.manage.request.ProductPageRequest;
import cn.healthy.manage.service.ProductService;
import cn.healthy.manage.utils.PageBean;
import cn.healthy.manage.utils.UploadUtils;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fasterxml.jackson.databind.ser.Serializers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
public class ProductServicelImpl extends ServiceImpl<ProductMapper,Product> implements ProductService {
    @Autowired
    private ProductMapper productMapper;

    @Override
    public BaseResponse addProduct(Product product){
        if(saveOrUpdate(product)){
            return BaseResponse.createSuccessResponse("新增成功");
        }else {
            return BaseResponse.createFailedResponse("新增失败");
        }
    }

    public BaseResponse deletedProduct(Integer productId){
        BaseResponse baseResponse = new BaseResponse();
        int judge = productMapper.deletedByProductId(productId);
        if(judge == 0){
            BaseResponse.createFailedResponse(1,"删除失败");
        }
        else{
            BaseResponse.createSuccessResponse("删除成功");
        }
        return baseResponse;
    }

//    public BaseResponse selectProductList(PageParams page){
////        BaseResponse baseResponse = new BaseResponse();
////        Integer count = productMapper.countProduct();
////        PageBean pageBean = new PageBean(page.getCurrentPage(),count,page.getPageSize());
////        List<Product> productList = productMapper.selectProductList(pageBean.getStart(),page.getPageSize(),page.getName(),page.getClassId());
////        pageBean.setList(productList);
////        baseResponse.setCode(0);
////        baseResponse.setMsg("查询成功");
////        baseResponse.setData(pageBean);
////        return baseResponse;
////    }

    public IPage<Product> selectProductList(ProductPageRequest request) {
        // 不进行 count sql 优化，解决 MP 无法自动优化 SQL 问题，这时候你需要自己查询 count 部分
        // page.setOptimizeCountSql(false);
        // 当 total 为小于 0 或者设置 setSearchCount(false) 分页插件不会进行 count 查询
        // 要点!! 分页返回的对象与传入的对象是同一个
        QueryWrapper<Product> queryWrapper = new QueryWrapper<>();
        LambdaQueryWrapper<Product> lambdaQueryWrapper = queryWrapper.lambda();
        if (!StringUtils.isEmpty(request.getName())){
            lambdaQueryWrapper.like(Product::getName,request.getName());
        }
        if (!StringUtils.isEmpty(request.getClassId())){
            lambdaQueryWrapper.eq(Product::getClassId,request.getClassId());
        }
        return page(new Page<>(request.getCurrentPage(),request.getPageSize()),queryWrapper);
    }

    public BaseResponse selectProduct(Integer productId){
        BaseResponse baseResponse = new BaseResponse();
        ProductChild proInfo = productMapper.selectByProductId(productId);
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
        if(saveOrUpdate(product)){
            return BaseResponse.createSuccessResponse("新增成功");
        }else {
            return BaseResponse.createFailedResponse("新增失败");
        }
//        BaseResponse baseResponse = new BaseResponse();
//        if(productMapper.updateByProduct(product) == 0 ){
//            baseResponse.setCode(1);
//            baseResponse.setMsg("修改失败");
//        }else{
//            baseResponse.setCode(0);
//            baseResponse.setMsg("修改成功");
//        }
//        return baseResponse;
    }

    public BaseResponse images(Image image){
        BaseResponse baseResponse = new BaseResponse();
        UploadUtils uploadUtils = new UploadUtils();
        String imagesName = uploadUtils.upload(image.getBase64());
        baseResponse.setData(imagesName);
        return baseResponse;
    }
}
