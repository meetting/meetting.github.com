package com.teamtwo.pojo;

public class Profitsset {
    private String profitsname;

    private Integer sendpoint;

    private Integer recvpoint;

    private Integer company;

    public String getProfitsname() {
        return profitsname;
    }

    public void setProfitsname(String profitsname) {
        this.profitsname = profitsname == null ? null : profitsname.trim();
    }

    public Integer getSendpoint() {
        return sendpoint;
    }

    public void setSendpoint(Integer sendpoint) {
        this.sendpoint = sendpoint;
    }

    public Integer getRecvpoint() {
        return recvpoint;
    }

    public void setRecvpoint(Integer recvpoint) {
        this.recvpoint = recvpoint;
    }

    public Integer getCompany() {
        return company;
    }

    public void setCompany(Integer company) {
        this.company = company;
    }
}