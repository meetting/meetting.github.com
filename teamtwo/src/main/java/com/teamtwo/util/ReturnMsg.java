package com.teamtwo.util;

import java.io.Serializable;

public class ReturnMsg implements Serializable{
  private static final long serialVersionUID = 1L;
  private Integer status;
  private String strStatus;
  private String msg;
  private Object data;

  public ReturnMsg(Integer status, String msg){
    this(status, msg, null);
  }

  public ReturnMsg(Integer status, String msg, Object data) {
    this.status = status;
    this.msg = msg;
    this.data = data;
  }

  public ReturnMsg(String status, String msg) {
    this(status, msg, null);
  }

  public ReturnMsg(String status, String msg, Object data) {
    this.strStatus = status;
    this.msg = msg;
    this.data = data;
  }

  public Integer getStatus() {
    return this.status;
  }

  public void setStatus(Integer status) {
    this.status = status;
  }

  public String getStrStatus() {
    return this.strStatus;
  }

  public void setStrStatus(String strStatus) {
    this.strStatus = strStatus;
  }

  public String getMsg() {
    return this.msg;
  }

  public void setMsg(String msg) {
    this.msg = msg;
  }

  public Object getData() {
    return this.data;
  }

  public void setData(Object data) {
    this.data = data;
  }
}