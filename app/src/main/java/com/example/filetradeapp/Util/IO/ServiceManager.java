package com.example.filetradeapp.Util.IO;

import com.example.filetradeapp.Config;
import com.google.gson.GsonBuilder;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class ServiceManager {

    private static Retrofit retrofit;

    private static volatile Service request = null;

    private static ServiceManager instance;

    public static ServiceManager getInstance() {
        if (instance == null) {
            synchronized (ServiceManager.class) {
                if (instance == null) {
                    instance = new ServiceManager();
                }
            }
        }
        return instance;
    }

    public static void init(){

        OkHttpClient client = new OkHttpClient.Builder()
                .build();

        retrofit = new Retrofit.Builder()
                .baseUrl(Config.baseURL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create(new GsonBuilder().create()))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

    public static Service getRequest(){
        if (request == null) {
            synchronized (Request.class) {
                request = retrofit.create(Service.class);
            }
        }
        return retrofit.create(Service.class);
    }
}
