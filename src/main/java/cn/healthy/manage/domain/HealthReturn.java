package cn.healthy.manage.domain;

import lombok.Data;

import java.math.BigDecimal;


@Data
public class HealthReturn {

    private Double bmi;

    private Double fatRate;

    private BigDecimal height;

    private BigDecimal weight;

    private BigDecimal waistline;

    private BigDecimal hipline;

    private BigDecimal chest;

    private BigDecimal water;

    private BigDecimal sleep;

    private BigDecimal defecation;
}
