package com.tms.o2o.entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

/**
 * 产品实体
 */
@Entity(name="tb_product")
@Data
public class Product {
    /**
     * 商品Id
     */
    @Id
    @GeneratedValue
    private Integer productId;


    /**
     * 商品名称
     */
    @NotNull
    @Size(min=2,max=15,message="商品名称在2-15个字符之间")
    private String productName;


    /**
     * 商品介绍
     */
    private String productDesc;


    /**
     * 缩略图
     */
    private String imgAddr;


    /**
     * 原价
     */
    private String normalPrice;


    /**
     * 折扣价
     */
    private String promotionPrice;


    /**
     * 优先级
     */
    private Integer priority;


    /**
     * 创建时间
     */
    private Date createTime;


    /**
     * 最后编辑时间
     */
    private Date lastEditTime;


    /**
     * 状态 -1.不可用，0.下架，1.在前端展示系统展示
     */
    private Integer enableStatus;


    /**
     * 积分
     */
    private Integer point;


    /**
     * 商品类别Id
     */
    private Integer productCategoryId;


    /**
     * 店铺Id
     */
    private Integer shopId;
}
