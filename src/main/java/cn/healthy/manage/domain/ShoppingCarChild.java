package cn.healthy.manage.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ShoppingCarChild extends ShoppingCar{
    private String proName;

    private String proPic;

    private BigDecimal proPrice;

    private String proIntroduce;
}
