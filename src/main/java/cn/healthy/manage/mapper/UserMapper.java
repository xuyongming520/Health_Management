package cn.healthy.manage.mapper;

import cn.healthy.manage.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface UserMapper {
    public User selectByPhone(String phone);

    public int addByUser(User user);

    public int updateByUser(User user);

    public List<User> selectAllUser();

    public User selectByUserId(Integer userId);
}
