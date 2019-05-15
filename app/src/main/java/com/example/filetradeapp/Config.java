package com.example.filetradeapp;

import android.content.Context;

import com.example.filetradeapp.Activity.Entity.FileCard;

import java.util.LinkedList;
import java.util.List;

public class Config {
    //public static final String baseURL = "http://120.79.191.240:8089/rssbackend/api/v1/";

    public static String username;
    public static String userId;
    public static String phone;

    public static String uid;

    public static int credit;

    public static String baseURL = "http://192.168.191.1:8080/";

    public static List<FileCard> getTestList(){
        List<FileCard> list = new LinkedList<>();
        for(int i=0;i<10;i++){
            list.add(new FileCard("fid"+i,"fname"+i,2,"uid"+i));
        }
        return list;
    }
}
