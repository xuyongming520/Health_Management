package cn.healthy.manage.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
@TableName(value = "orders")
public class Orders {
    private Integer id;

    private Integer orderId;

    private Integer proId;

    private Integer userId;

    private Integer number;

    private BigDecimal total;

    private Date createTime;

    private Integer status;

    private String proName;

    private String proPic;

    private BigDecimal proPrice;

    private String userName;
}
