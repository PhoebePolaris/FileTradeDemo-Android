package com.example.filetradeapp;

import android.content.Context;
import android.os.Environment;

import com.example.filetradeapp.Util.Bean.FileBean;
import com.example.filetradeapp.Util.Bean.File_label;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

import static android.os.Environment.DIRECTORY_DOCUMENTS;

public class Config {

    public static String username;
    public static String userId;
    public static int credit;

    public static String baseURL = "http://192.168.137.1:8080/";

    public static String storageURL = Environment.getExternalStoragePublicDirectory(DIRECTORY_DOCUMENTS).getAbsolutePath();
}
