package com.example.filetradeapp.Util.Bean;

import java.io.Serializable;

public class FileBean implements Serializable {

    private String uid;
    private String fid;
    private String size;
    private String title;
    private String type;
    private String time;
    private int credit;
    private double score;

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

    public String getTime() {
        return time;
    }

    public double getScore() {
        return score;
    }

    public String getSize() {
        return size;
    }

    public String getType() {
        return type;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setType(String type) {
        this.type = type;
    }
}
