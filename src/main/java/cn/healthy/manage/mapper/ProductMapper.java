package cn.healthy.manage.mapper;


import cn.healthy.manage.domain.Product;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface ProductMapper {
    public int addByProduct(Product product);

    public int updateByProduct(Product product);

    public List<Product> selectProductList(@Param("offset")Integer offset,
                                     @Param("limit")Integer limit);

    public int countProduct();

    public Product selectByProductId(Integer productId);

    public int deletedByProductId(Integer productId);
}
