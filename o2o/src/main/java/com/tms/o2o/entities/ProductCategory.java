package com.tms.o2o.entities;

import org.springframework.data.annotation.Id;

import javax.persistence.GeneratedValue;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

public class ProductCategory {

    /**
     * 商品类别Id
     */
    @Id
    @GeneratedValue
    private Long productCategoryId;


    /**
     * 店铺Id
     */
    @NotNull
    private Long shopId;


    /**
     * 商品类别名
     */
    @NotNull
    @Size(min=2,max=15,message="商品类别名应在2-15个字符之间")
    private String productCategoryName;


    /**
     * 优先级
     */
    private Integer priority;


    /**
     * 创建时间
     */
    private Date createTime;

}
