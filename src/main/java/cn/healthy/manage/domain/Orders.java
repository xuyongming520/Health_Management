package cn.healthy.manage.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
@TableName(value = "orders")
public class Orders {

    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;

    @TableField("order_id")
    private Integer orderId;

    @TableField("pro_id")
    private Integer proId;

    @TableField("user_id")
    private Integer userId;

    @TableField("number")
    private Integer number;

    @TableField("total")
    private BigDecimal total;

    @TableField("create_time")
    private Date createTime;

    @TableField("status")
    private Integer status;

}
