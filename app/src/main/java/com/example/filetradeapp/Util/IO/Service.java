package com.example.filetradeapp.Util.IO;

import com.example.filetradeapp.Util.Bean.FileBean;
import com.example.filetradeapp.Util.Bean.File_label;
import com.example.filetradeapp.Util.Bean.UserBean;
import com.google.gson.JsonObject;


import java.util.List;
import java.util.Map;

import io.reactivex.Observable;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.PartMap;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.Streaming;
import retrofit2.http.Url;

public interface Service {


    //登录
    @Headers({"Accept: application/json"})
    @POST("user/login")
    Observable<Response<UserBean>> requestLogin(@Body RequestBody requestBody);

    //注册
    @Headers({"Accept: application/json"})
    @POST("user/update")
    Observable<Response<UserBean>> requestRegister(@Body RequestBody requestBody);

    //重置密码
    @Headers({"Accept: application/json"})
    @POST("user/updateOther")
    Observable<Response> requestPassword(@Body RequestBody requestBody);

    //主页推荐
    @Headers({"Accept: application/json"})
    @GET("recommend/{user_id}")
    Observable<Response<List<FileBean>>> requestRecommend(@Path("user_id") String uid);

    //搜索
    @Headers({"Accept: application/json"})
    @GET("search")
    Observable<Response<List<FileBean>>> requestSearch(@Query("word") String word);

    //详情
    @Headers({"Accept: application/json"})
    @GET("file_label/{file_id}")
    Observable<Response<File_label>> requestDetail(@Path("file_id") String fid);

    //添加收藏
    @Headers({"Accept: application/json"})
    @GET("collect_log")
    Observable<Response> requestAddCollection(@Body RequestBody requestBody);

    //取消收藏
    @Headers({"Accept: application/json"})
    @GET("collect_log/{file_id}/{user_id}")
    Observable<Response> requestDeleteCollection(@Path("file_id") String fid,@Path("user_id") String uid);

    //收藏列表
    @Headers({"Accept: application/json"})
    @GET("collect_log/{user_id}")
    Observable<Response<List<FileBean>>> requestCollection(@Path("user_id") String uid);

    //上传记录
    @Headers({"Accept: application/json"})
    @GET("upload_log/{user_id}")
    Observable<Response<List<FileBean>>> requestUploadLog(@Path("user_id") String uid);

    //下载记录
    @Headers({"Accept: application/json"})
    @GET("download_log/{user_id}")
    Observable<Response<List<FileBean>>> requestDownloadLog(@Path("user_id") String uid);

    //添加购买
    @Headers({"Accept: application/json"})
    @POST("buy_log")
    Observable<Response> requestBuy(@Body RequestBody requestBody);

    //购买记录
    @Headers({"Accept: application/json"})
    @GET("buy_log/{user_id}")
    Observable<Response<List<FileBean>>> requestBuyLog(@Path("user_id") String uid);

    //用户信息
    @Headers({"Accept: application/json"})
    @GET("user/{user_id}")
    Observable<Response<UserBean>> requestUser(@Path("user_id") String uid);

    //用户label
    @Headers({"Accept: application/json"})
    @POST("user_label/update")
    Observable<Response<UserBean>> requestUser(@Body RequestBody requestBody);

    //上传
    @Multipart
    @POST("file/upload")
    Observable<Response<FileBean>> requestUpload(@PartMap Map<String, JsonObject> map, @Part MultipartBody.Part file);

    //下载
    @Streaming
    @GET
    Observable<ResponseBody> requestDownload(@Url String url);
}
