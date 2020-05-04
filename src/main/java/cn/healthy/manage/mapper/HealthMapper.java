package cn.healthy.manage.mapper;

import cn.healthy.manage.domain.Diet;
import cn.healthy.manage.domain.Health;
import cn.healthy.manage.domain.HealthAll;
import cn.healthy.manage.request.BmiRequest;
import cn.healthy.manage.request.DietRequest;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;


@Repository
@Mapper
public interface HealthMapper extends BaseMapper<Health> {
    HealthAll queryHealth(@Param("req") BmiRequest request);

    void diet(@Param("date") String date , @Param("id") Integer id,@Param("type") String type,@Param("foods") String foods);

    Diet query(@Param("date") String date , @Param("id") Integer id);

}
