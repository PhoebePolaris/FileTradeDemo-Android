package com.example.filetradeapp.Model;


import com.example.filetradeapp.Contract;
import com.example.filetradeapp.Util.Bean.FileBean;
import com.example.filetradeapp.Util.Bean.UserBean;
import com.example.filetradeapp.Util.IO.ServiceManager;
import com.google.gson.JsonObject;

import io.reactivex.Observable;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Response;

public class LoginModelImpl implements Contract.ILoginModel {


    @Override
    public Observable<Response<UserBean>> doLogin(String phone_num, String password) {
        JsonObject json = new JsonObject();
        json.addProperty("user_id","");
        json.addProperty("phone_num",phone_num);
        json.addProperty("password",password);
        json.addProperty("user_name","");
        json.addProperty("credit",0);
        RequestBody reqUser = RequestBody.create(MediaType.parse("application/json"),json.toString());
        return ServiceManager.getRequest().requestLogin(reqUser);
    }
}
