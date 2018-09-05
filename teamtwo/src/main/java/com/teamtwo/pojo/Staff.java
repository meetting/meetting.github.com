package com.teamtwo.pojo;

public class Staff {
    private Integer staffid;

    private String staffname;

    private String staffpost;

    private String staffphone;

    public Integer getStaffid() {
        return staffid;
    }

    public void setStaffid(Integer staffid) {
        this.staffid = staffid;
    }

    public String getStaffname() {
        return staffname;
    }

    public void setStaffname(String staffname) {
        this.staffname = staffname == null ? null : staffname.trim();
    }

    public String getStaffpost() {
        return staffpost;
    }

    public void setStaffpost(String staffpost) {
        this.staffpost = staffpost == null ? null : staffpost.trim();
    }

    public String getStaffphone() {
        return staffphone;
    }

    public void setStaffphone(String staffphone) {
        this.staffphone = staffphone == null ? null : staffphone.trim();
    }
}