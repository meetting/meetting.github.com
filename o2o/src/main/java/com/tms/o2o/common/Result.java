package com.tms.o2o.common;

import lombok.Getter;
import lombok.Setter;

/**
 * 自定义返回结果
 * @param <T>
 */
@Getter
@Setter
public class Result<T>{
    /**
     * 错误代码
     */
    private Integer code;

    /**
     * 返回消息
     */
    private String msg;

    /**
     * 具体的数据
     */
    private T data;


}
