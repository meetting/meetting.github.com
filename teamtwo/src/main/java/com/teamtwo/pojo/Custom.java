package com.teamtwo.pojo;

public class Custom {
    private Integer customid;

    private String customname;

    private String custompsw;

    private String customrealname;

    private String customphone;

    private String customaddress;

    public Integer getCustomid() {
        return customid;
    }

    public void setCustomid(Integer customid) {
        this.customid = customid;
    }

    public String getCustomname() {
        return customname;
    }

    public void setCustomname(String customname) {
        this.customname = customname == null ? null : customname.trim();
    }

    public String getCustompsw() {
        return custompsw;
    }

    public void setCustompsw(String custompsw) {
        this.custompsw = custompsw == null ? null : custompsw.trim();
    }

    public String getCustomrealname() {
        return customrealname;
    }

    public void setCustomrealname(String customrealname) {
        this.customrealname = customrealname == null ? null : customrealname.trim();
    }

    public String getCustomphone() {
        return customphone;
    }

    public void setCustomphone(String customphone) {
        this.customphone = customphone == null ? null : customphone.trim();
    }

    public String getCustomaddress() {
        return customaddress;
    }

    public void setCustomaddress(String customaddress) {
        this.customaddress = customaddress == null ? null : customaddress.trim();
    }
}