package cn.healthy.manage.mapper;

import cn.healthy.manage.domain.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface UserMapper extends BaseMapper<User> {
    public User selectByPhone(String phone);

    public int addByUser(User user);

    public int updateByUser(User user);

    public List<User> selectUserList(@Param("offset")Integer offset,
                                    @Param("limit")Integer limit);

    public int countUser();

    public User selectByUserId(Integer userId);
}
