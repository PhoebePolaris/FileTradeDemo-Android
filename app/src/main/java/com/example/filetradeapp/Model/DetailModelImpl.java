package com.example.filetradeapp.Model;

import com.example.filetradeapp.Config;
import com.example.filetradeapp.Contract;
import com.example.filetradeapp.Util.Bean.File_label;
import com.example.filetradeapp.Util.IO.ServiceManager;
import com.google.gson.JsonObject;

import io.reactivex.Observable;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Response;

public class DetailModelImpl implements Contract.IDetailModel {

    @Override
    public Observable<Response<File_label>> doDetail(String fid) {
        return ServiceManager.getRequest().requestDetail(fid);
    }

    @Override
    public Observable<Response> doAddCollection(String fid) {
        JsonObject json = new JsonObject();
        json.addProperty("user_id",Config.userId);
        json.addProperty("file_id",fid);
        RequestBody req = RequestBody.create(MediaType.parse("application/json"),json.toString());
        return ServiceManager.getRequest().requestAddCollection(req);
    }

    @Override
    public Observable<Response> doDeleteCollection(String fid) {
        return ServiceManager.getRequest().requestDeleteCollection(fid,Config.userId);
    }

    @Override
    public Observable<Response> doBuy(String fid) {
        JsonObject json = new JsonObject();
        json.addProperty("user_id",Config.userId);
        json.addProperty("file_id",fid);
        RequestBody req = RequestBody.create(MediaType.parse("application/json"),json.toString());
        return ServiceManager.getRequest().requestBuy(req);
    }
}
