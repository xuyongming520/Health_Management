package cn.healthy.manage.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.math.BigDecimal;

@Data
@TableName(value = "shoppingcart")
public class ShoppingCar {

    @TableId(value = "id",type = IdType.AUTO)
    public Integer id;

    @TableField("pro_id")
    public Integer proId;

    @TableField("user_id")
    public Integer userId;

    @TableField("number")
    public Integer number;

    @TableField("total")
    public BigDecimal total;
}
