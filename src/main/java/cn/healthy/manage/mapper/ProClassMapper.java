package cn.healthy.manage.mapper;

import cn.healthy.manage.domain.ProClass;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface ProClassMapper {
    public int addByClass(ProClass proClass);

    public int updateByClass(ProClass proClass);

    public List<ProClass> selectClassList();

    public ProClass selectByClassId(Integer classId);
}
