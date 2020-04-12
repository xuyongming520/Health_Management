package cn.healthy.manage.request;

import lombok.Data;

@Data
public class OrderPageRequest {
    public Integer currentPage;

    public Integer pageSize;

    public Integer userId;
}
