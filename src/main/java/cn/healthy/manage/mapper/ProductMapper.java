package cn.healthy.manage.mapper;


import cn.healthy.manage.domain.Product;
import cn.healthy.manage.domain.ProductChild;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface ProductMapper extends BaseMapper<Product> {
    public int addByProduct(Product product);

    public int updateByProduct(Product product);

//    public List<Product> selectProductList(@Param("offset")Integer offset,
//                                     @Param("limit")Integer limit,@Param("name")String name,@Param("classId")Integer classId);

    public int countProduct();

    public ProductChild selectByProductId(Integer productId);

    public int deletedByProductId(Integer productId);

    public int updateImages(Product product);
}
