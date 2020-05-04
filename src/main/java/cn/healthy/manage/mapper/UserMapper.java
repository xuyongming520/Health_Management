package cn.healthy.manage.mapper;

import cn.healthy.manage.domain.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
@Mapper
public interface UserMapper extends BaseMapper<User> {
    public User selectUserByPhone(String phone);

    public int addByUser(User user);

    public int updateByUser(User user);

    public List<User> selectUserList(@Param("offset")Integer offset,
                                    @Param("limit")Integer limit);

    public int countUser();

    public User selectByUserId(Integer userId);

    public BigDecimal selectBalance(Integer userId);

    public int updateBalance(@Param("userId") Integer userId,@Param("balance") BigDecimal balance);

    public Integer selectAge(Integer userId);

    public Integer selectSex(Integer userId);
}
