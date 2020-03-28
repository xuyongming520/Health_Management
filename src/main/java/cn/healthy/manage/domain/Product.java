package cn.healthy.manage.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@TableName(value = "product")
public class Product {

    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;

    @TableField("name")
    private String name;

    @TableField("class_id")
    private Integer classId;

    @TableField("price")
    private BigDecimal price;

    @TableField("pic")
    private String pic;

    @TableField("storage")
    private Integer storage;

    @TableField("shelf_life")
    private Integer shelfLife;

    @TableField("manufacturer_con")
    private String manufacturerCon;

    @TableField("pro_number")
    private String proNumber;

    @TableField("series")
    private String series;

    @TableField("provinces")
    private String provinces;

    @TableField("factory_name")
    private String factoryName;

    @TableField("ingredients")
    private String ingredients;

    @TableField("net_content")
    private String netContent;

    @TableField("store_method")
    private String storeMethod;

    @TableField("brand")
    private String brand;

    @TableField("model")
    private String model;

    @TableField("color")
    private String color;

    @TableField("introduce")
    private String introduce;
//
//    private String className;
}
