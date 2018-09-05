package com.teamtwo.pojo;

public class Road {
    private Integer roadid;

    private Integer startpointid;

    private Integer endpointid;

    private Float roadlength;

    private Float roadvalue;

    public Integer getRoadid() {
        return roadid;
    }

    public void setRoadid(Integer roadid) {
        this.roadid = roadid;
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

    public Float getRoadlength() {
        return roadlength;
    }

    public void setRoadlength(Float roadlength) {
        this.roadlength = roadlength;
    }

    public Float getRoadvalue() {
        return roadvalue;
    }

    public void setRoadvalue(Float roadvalue) {
        this.roadvalue = roadvalue;
    }
}