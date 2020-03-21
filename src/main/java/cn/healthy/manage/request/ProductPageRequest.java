package cn.healthy.manage.request;

import lombok.Data;

@Data
public class ProductPageRequest {

    private Integer pageSize;

    private Integer currentPage;

    private String name;

    private Integer classId;
}
