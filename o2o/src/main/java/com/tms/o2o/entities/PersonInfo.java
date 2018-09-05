package com.tms.o2o.entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

/**
 * 用户实体
 */
@Entity(name="tb_person_info")
@Data
public class PersonInfo {

    /**
     * 用户id
     */
    @Id
    @GeneratedValue
    private Integer userId;

    /**
     * 账号
     */
    @NotNull
    @Size(min=2,max=25,message = "名字应当在2-25个字符之间")
    private String userName;

    /**
     * 密码
     */
    private String password;

    /**
     * 用户名
     */
    private String theName;

    /**
     * 生日
     */
    private Date birthday;

    /**
     * 性别
     */
    private String gender;

    /**
     * 电话
     */
    private String phone;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 头像
     */
    private String profileImg;

    /**
     * 用户权限标识
     */
    private Integer customerFlag;

    /**
     * 店家权限标识
     */
    private Integer shopOwnerFlag;

    /**
     * 管理员权限标识
     */
    private Integer adminFlag;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 最后编辑时间
     */
    private Date lastEditTime;

    /**
     * 用户是否可用(0不可用，1可用)
     */
    private Integer enableStatus;
}
