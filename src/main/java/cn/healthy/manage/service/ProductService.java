package cn.healthy.manage.service;

import cn.healthy.manage.base.BaseResponse;
import cn.healthy.manage.base.PageParams;
import cn.healthy.manage.domain.Image;
import cn.healthy.manage.domain.Product;
import cn.healthy.manage.request.ProductPageRequest;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

public interface ProductService extends IService<Product> {
    BaseResponse addProduct(Product product);

    BaseResponse updateProduct(Product product);

    IPage<Product> selectProductList(ProductPageRequest request);

    BaseResponse selectProduct(Integer productId);

    BaseResponse deletedProduct(Integer productId);

    BaseResponse images(Image image);
}
