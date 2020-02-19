package cn.healthy.manage.service;

import cn.healthy.manage.base.BaseResponse;
import cn.healthy.manage.base.PageParams;
import cn.healthy.manage.domain.Product;

public interface ProductService {
    BaseResponse addProduct(Product product);

    BaseResponse updateProduct(Product product);

    BaseResponse selectProductList(PageParams page);

    BaseResponse selectProduct(Integer productId);

    BaseResponse deletedProduct(Integer productId);
}
