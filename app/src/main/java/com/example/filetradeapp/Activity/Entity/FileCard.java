package com.example.filetradeapp.Activity.Entity;

public class FileCard {
    private String fid;
    private String fname;
    private int credit;
    private String uid;

    public FileCard(String fid, String fname, int credit, String uid) {
        this.fid = fid;
        this.fname = fname;
        this.credit = credit;
        this.uid = uid;
    }

    public String getFid() {
        return fid;
    }

    public void setFid(String fid) {
        this.fid = fid;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }
}
