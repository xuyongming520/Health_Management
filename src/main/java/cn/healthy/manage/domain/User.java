package cn.healthy.manage.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@TableName(value = "user")
@Data
public class User {
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;

    @TableField("name")
    private String name;

    @TableField("balance")
    private BigDecimal balance;

    @TableField("phone")
    private String phone;

    @TableField("password")
    private String password;

    @TableField("email")
    private String email;

    @TableField("create_time")
    private Date createTime;

    @TableField("address")
    private String address;

    @TableField("age")
    private Integer age;

    @TableField("sex")
    private Integer sex;
}
