package cn.healthy.manage.service;

import cn.healthy.manage.base.BaseResponse;
import cn.healthy.manage.base.PageParams;
import cn.healthy.manage.domain.User;

public interface UserService {
    BaseResponse login(User user);

    BaseResponse register(User user);

    BaseResponse updateUser(User user);

    BaseResponse selectUserList(PageParams page);

    BaseResponse selectUser(Integer userId);
}
