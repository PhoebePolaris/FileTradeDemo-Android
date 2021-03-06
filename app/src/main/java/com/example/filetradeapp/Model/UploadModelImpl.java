package com.example.filetradeapp.Model;

import com.example.filetradeapp.Contract;
import com.example.filetradeapp.Util.Bean.FileBean;
import com.example.filetradeapp.Util.IO.ServiceManager;
import com.google.gson.JsonObject;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import io.reactivex.Observable;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Response;

public class UploadModelImpl implements Contract.IUploadModel {

    @Override
    public Observable<Response<FileBean>> doUpload(String uid, String fid, String filePath, String title, int credit) {

        File file = new File(filePath);
        String filename = file.getName();
        String suffixName = filename.substring(filename.lastIndexOf(".")+1);

        SimpleDateFormat dateTime = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        JsonObject json = new JsonObject();
        json.addProperty("file_id",fid);
        json.addProperty("size",0);
        json.addProperty("file_title",title);
        json.addProperty("creation_time",dateTime.format(new Date()));
        json.addProperty("file_type",suffixName);
        json.addProperty("credit",credit);
        json.addProperty("creator_id",uid);
        json.addProperty("score",0);
        Map<String,JsonObject> map = new HashMap<>();
        map.put("json",json);

        RequestBody reqFile = RequestBody.create(MediaType.parse("multipart/form-data"),file);
        MultipartBody.Part part= MultipartBody.Part.createFormData("file", fid, reqFile);
        return ServiceManager.getRequest().requestUpload(map,part);
    }
}
