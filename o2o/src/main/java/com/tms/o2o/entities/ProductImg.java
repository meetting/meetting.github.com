package com.tms.o2o.entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * 商品图片实体
 */
@Entity(name="tb_product_img")
@Data
public class ProductImg {
    /**
     * 商品图片Id
     */
    @Id
    @GeneratedValue
    private Long productImgId;


    /**
     * 图片地址
     */
    private String imgAddr;


    /**
     * 图片描述
     */
    private String imgDesc;


    /**
     * 优先级
     */
    private Integer priority;


    /**
     * 创建时间
     */
    private Date createTime;


    /**
     * 商品Id
     */
    @NotNull
    private Integer productId;

}
