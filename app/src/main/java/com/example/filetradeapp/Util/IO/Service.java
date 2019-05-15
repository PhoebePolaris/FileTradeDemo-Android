package com.example.filetradeapp.Util.IO;

import com.example.filetradeapp.Util.Bean.FileBean;
import com.example.filetradeapp.Util.Bean.UserBean;
import com.google.gson.JsonObject;


import io.reactivex.Observable;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.PartMap;
import retrofit2.http.Streaming;
import retrofit2.http.Url;

public interface Service {

    //注册
    @Headers({"Accept: application/json"})
    @POST("user/update")
    Observable<Response<UserBean>> requestRegister(@Body RequestBody requestBody);

    //上传
    @Multipart
    @POST("file/upload")
    Observable<Response<FileBean>> requestUpload(@Part("json") RequestBody requestBody, @Part MultipartBody.Part file);

    //下载
    @Streaming
    @GET("file/download")
    Observable<Response<FileBean>> requestDownload(@Url String fileUrl);
}
