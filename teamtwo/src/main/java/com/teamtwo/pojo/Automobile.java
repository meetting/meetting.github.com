package com.teamtwo.pojo;

public class Automobile {
    private Integer automobileid;

    private String cartweight;

    private String carvolume;

    private String cartate;

    private Integer pointid;

    public Integer getAutomobileid() {
        return automobileid;
    }

    public void setAutomobileid(Integer automobileid) {
        this.automobileid = automobileid;
    }

    public String getCartweight() {
        return cartweight;
    }

    public void setCartweight(String cartweight) {
        this.cartweight = cartweight == null ? null : cartweight.trim();
    }

    public String getCarvolume() {
        return carvolume;
    }

    public void setCarvolume(String carvolume) {
        this.carvolume = carvolume == null ? null : carvolume.trim();
    }

    public String getCartate() {
        return cartate;
    }

    public void setCartate(String cartate) {
        this.cartate = cartate == null ? null : cartate.trim();
    }

    public Integer getPointid() {
        return pointid;
    }

    public void setPointid(Integer pointid) {
        this.pointid = pointid;
    }
}