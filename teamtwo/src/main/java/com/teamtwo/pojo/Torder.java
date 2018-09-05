package com.teamtwo.pojo;

import java.util.Date;

public class Torder {
    private Integer orderid;

    private Integer customid;

    private Integer startcityid;

    private Integer endcityid;

    private Integer startpointid;

    private Integer endpointid;

    private Integer senddelivery;

    private Integer recvdelivery;

    private Date sendtime;

    private Date exptime;

    private Date recvtime;

    private Float safe;

    private Float weight;

    private Float volume;

    private String describe;

    private String sendnamev;

    private String sendphone;

    private String sendaddress;

    private String recvname;

    private String recvphone;

    private String recvaddress;

    private Integer fast;

    private Float fastcost;

    private Float cost;

    private Integer transfer;

    private Integer mailing;

    private String statev;

    private String remarks;

    public Integer getOrderid() {
        return orderid;
    }

    public void setOrderid(Integer orderid) {
        this.orderid = orderid;
    }

    public Integer getCustomid() {
        return customid;
    }

    public void setCustomid(Integer customid) {
        this.customid = customid;
    }

    public Integer getStartcityid() {
        return startcityid;
    }

    public void setStartcityid(Integer startcityid) {
        this.startcityid = startcityid;
    }

    public Integer getEndcityid() {
        return endcityid;
    }

    public void setEndcityid(Integer endcityid) {
        this.endcityid = endcityid;
    }

    public Integer getStartpointid() {
        return startpointid;
    }

    public void setStartpointid(Integer startpointid) {
        this.startpointid = startpointid;
    }

    public Integer getEndpointid() {
        return endpointid;
    }

    public void setEndpointid(Integer endpointid) {
        this.endpointid = endpointid;
    }

    public Integer getSenddelivery() {
        return senddelivery;
    }

    public void setSenddelivery(Integer senddelivery) {
        this.senddelivery = senddelivery;
    }

    public Integer getRecvdelivery() {
        return recvdelivery;
    }

    public void setRecvdelivery(Integer recvdelivery) {
        this.recvdelivery = recvdelivery;
    }

    public Date getSendtime() {
        return sendtime;
    }

    public void setSendtime(Date sendtime) {
        this.sendtime = sendtime;
    }

    public Date getExptime() {
        return exptime;
    }

    public void setExptime(Date exptime) {
        this.exptime = exptime;
    }

    public Date getRecvtime() {
        return recvtime;
    }

    public void setRecvtime(Date recvtime) {
        this.recvtime = recvtime;
    }

    public Float getSafe() {
        return safe;
    }

    public void setSafe(Float safe) {
        this.safe = safe;
    }

    public Float getWeight() {
        return weight;
    }

    public void setWeight(Float weight) {
        this.weight = weight;
    }

    public Float getVolume() {
        return volume;
    }

    public void setVolume(Float volume) {
        this.volume = volume;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe == null ? null : describe.trim();
    }

    public String getSendnamev() {
        return sendnamev;
    }

    public void setSendnamev(String sendnamev) {
        this.sendnamev = sendnamev == null ? null : sendnamev.trim();
    }

    public String getSendphone() {
        return sendphone;
    }

    public void setSendphone(String sendphone) {
        this.sendphone = sendphone == null ? null : sendphone.trim();
    }

    public String getSendaddress() {
        return sendaddress;
    }

    public void setSendaddress(String sendaddress) {
        this.sendaddress = sendaddress == null ? null : sendaddress.trim();
    }

    public String getRecvname() {
        return recvname;
    }

    public void setRecvname(String recvname) {
        this.recvname = recvname == null ? null : recvname.trim();
    }

    public String getRecvphone() {
        return recvphone;
    }

    public void setRecvphone(String recvphone) {
        this.recvphone = recvphone == null ? null : recvphone.trim();
    }

    public String getRecvaddress() {
        return recvaddress;
    }

    public void setRecvaddress(String recvaddress) {
        this.recvaddress = recvaddress == null ? null : recvaddress.trim();
    }

    public Integer getFast() {
        return fast;
    }

    public void setFast(Integer fast) {
        this.fast = fast;
    }

    public Float getFastcost() {
        return fastcost;
    }

    public void setFastcost(Float fastcost) {
        this.fastcost = fastcost;
    }

    public Float getCost() {
        return cost;
    }

    public void setCost(Float cost) {
        this.cost = cost;
    }

    public Integer getTransfer() {
        return transfer;
    }

    public void setTransfer(Integer transfer) {
        this.transfer = transfer;
    }

    public Integer getMailing() {
        return mailing;
    }

    public void setMailing(Integer mailing) {
        this.mailing = mailing;
    }

    public String getStatev() {
        return statev;
    }

    public void setStatev(String statev) {
        this.statev = statev == null ? null : statev.trim();
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks == null ? null : remarks.trim();
    }
}