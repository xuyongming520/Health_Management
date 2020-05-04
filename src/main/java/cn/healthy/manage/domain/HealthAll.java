package cn.healthy.manage.domain;

import lombok.Data;

import java.math.BigDecimal;


@Data
public class HealthAll {

    private Integer id;

    private Integer userId;

    private String createTime;

    private BigDecimal weight;

    private BigDecimal height;

    private BigDecimal waistline;

    private BigDecimal hipline;

    private BigDecimal chest;

    private BigDecimal water;

    private BigDecimal sleep;

    private BigDecimal defecation;

    private Integer age;

    private Integer sex;

}
