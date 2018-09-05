package com.tms.o2o.entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

/**
 * 区域实体
 */
@Entity(name="tb_area")
@Data
public class Area {
    /**
     * 区域id,主键，自增
     */
    @Id
    @GeneratedValue
    private Integer areaId;

    /**
     * 区域名，唯一
     */
    @NotNull
    @Size(min=2,max=100,message = "名字应当在2-25个字符之间")
    private String areaName;

    /**
     * 地区描述
     */
    private String areaDesc;

    /**
     * 特权，按它排序
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


}
