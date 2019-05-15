package com.example.filetradeapp.Util.Bean;

import java.util.Date;

public class FileBean {

    private String uid;
    private String fid;
    private double size;
    private String title;
    private String type;
    private Date time;
    private int credit;
    private double score;

    public FileBean(String uid, String fid, double size, String title, String type, Date time, int credit, double score){
        this.uid = uid;
        this.fid= fid;
        this.credit = credit;
        this.score = score;
        this.size = size;
        this.time = time;
        this.title = title;
        this.type = type;
    }

    public void setFid(String fid) {
        this.fid = fid;
    }

    public String getFid() {
        return fid;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    public int getCredit() {
        return credit;
    }

    public String getTitle() {
        return title;
    }

    public Date getTime() {
        return time;
    }

    public double getScore() {
        return score;
    }

    public double getSize() {
        return size;
    }

    public String getType() {
        return type;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public void setSize(double size) {
        this.size = size;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setType(String type) {
        this.type = type;
    }
}
