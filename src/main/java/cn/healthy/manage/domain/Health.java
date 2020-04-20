package cn.healthy.manage.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
@TableName(value = "health")
public class Health {

    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;

    @TableField("user_id")
    private Integer userId;

    @TableField("create_time")
    private Date createTime;

    @TableField("weight")
    private BigDecimal weight;

    @TableField("height")
    private BigDecimal height;

    @TableField("waistline")
    private BigDecimal waistline;

    @TableField("hipline")
    private BigDecimal hipline;

    @TableField("chest")
    private BigDecimal chest;

    @TableField("breakfast")
    private String breakfast;

    @TableField("lunch")
    private String lunch;

    @TableField("dinner")
    private String dinner;

    @TableField("exercise")
    private String exercise;

    @TableField("water")
    private Integer water;

    @TableField("sleep")
    private BigDecimal sleep;

    @TableField("defecation")
    private Integer defecation;
}
