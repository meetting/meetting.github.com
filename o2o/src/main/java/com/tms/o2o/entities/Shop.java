package com.tms.o2o.entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

/**
 * 商店实体
 */
@Entity(name="tb_shop")
@Data
public class Shop {
    /**
     * 店铺Id
     */
    @Id
    @GeneratedValue
    private Integer shopId;

    /**
     * 所属用户id
     */
    private Integer ownerId;
    /**
     * 地域Id
     */
    private Integer areaId;
    /**
     * 店铺类别
     */
    private Integer shopCategoryId;
    /**
     * 父店铺类型（不知道是个什么属性）
     */
    private Integer parentCategoryId;
    /**
     * 店名
     */
    private String shopName;
    /**
     * 店铺描述
     */
    private String shopDesc;

    /**
     * 店铺地址
     */
    private String shopAddr;
    /**
     * 店铺电话
     */
    private String phone;
    /**
     * 店铺照
     */
    private String shopImg;
    /**
     * 经度
     */
    private Double longitude;
    /**
     * 纬度
     */
    private Double latitude;
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
     * 状态  -1 不可用， 0 审核中， 1 可用
     */
    private Integer enableStatus;
    /**
     * 超级管理员给店铺的提醒
     */
    private String advice;
}
