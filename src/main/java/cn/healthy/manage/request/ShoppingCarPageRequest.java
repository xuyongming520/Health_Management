package cn.healthy.manage.request;

import lombok.Data;

@Data
public class ShoppingCarPageRequest {
    private Integer currentPage;

    private Integer pageSize;

    private Integer userId;
}
