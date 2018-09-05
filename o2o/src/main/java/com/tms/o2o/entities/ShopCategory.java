package com.tms.o2o.entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

/**
 * 商店类型实体
 */
@Entity(name="tb_shop_category")
@Data
public class ShopCategory {

    /**
     * 店铺类别Id
     */
    @Id
    @GeneratedValue
    private Integer shopCategoryId;


    /**
     * 店铺类别名
     */
    @NotNull
    @Size(min=2,max=15,message="店铺类别名在2-15个字符之间")
    private String shopCategoryName;


    /**
     * 店铺类别介绍
     */
    private String shopCategoryDesc;


    /**
     * 店铺类别图片
     */
    private String shopCategoryImg;


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
     * 上级类别
     */
    private Integer parentId;

}
