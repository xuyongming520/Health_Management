package cn.healthy.manage.request;

import lombok.Data;

import java.util.Date;

@Data
public class behaviorRequest {
    private Integer id;

    private Date date;

    private String name;

    private Integer calorie;

    private Integer num;
}
