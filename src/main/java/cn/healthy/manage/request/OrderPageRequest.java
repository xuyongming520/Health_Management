package cn.healthy.manage.request;

import lombok.Data;

@Data
public class OrderPageRequest {
    private Integer currentPage;

    private Integer pageSize;

    private Integer userId;
}
