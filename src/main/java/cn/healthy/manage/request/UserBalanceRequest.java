package cn.healthy.manage.request;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class UserBalanceRequest {
    private Integer userId;

    private BigDecimal balance;
}
