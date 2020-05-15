package cn.healthy.manage.request;

import lombok.Data;

import java.util.List;


@Data
public class DietRequest {

    private Integer id;

    private String date;

    private String type;

    private List<behaviorRequest> foods;
}
