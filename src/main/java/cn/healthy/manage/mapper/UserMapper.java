package cn.healthy.manage.mapper;

import cn.healthy.manage.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface UserMapper {
    public User selectByPhone(String phone);
}
