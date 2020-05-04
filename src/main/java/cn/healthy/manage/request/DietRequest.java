package cn.healthy.manage.request;

import lombok.Data;


@Data
public class DietRequest {

    private Integer id;

    private String date;

    private String type;

    private String foods;
}
