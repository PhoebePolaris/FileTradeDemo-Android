
package com.example.filetradeapp.Model;


import com.example.filetradeapp.Contract;
import com.example.filetradeapp.Util.Bean.FileBean;
import com.example.filetradeapp.Util.Bean.RegisterBean;
import com.example.filetradeapp.Util.Bean.UserBean;
import com.example.filetradeapp.Util.IO.ServiceManager;
import com.google.gson.JsonObject;

import java.util.UUID;

import io.reactivex.Observable;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Response;

public class RegisterModelImpl implements Contract.IRegisterModel {


    @Override
    public Observable<Response<UserBean>> doRegister(String username, String password, String phone) {
        JsonObject json = new JsonObject();
        json.addProperty("user_id",UUID.randomUUID().toString().replace("-",""));
        json.addProperty("phone_num",phone);
        json.addProperty("password",password);
        json.addProperty("user_name",username);
        json.addProperty("credit",0);
        RequestBody reqUser = RequestBody.create(MediaType.parse("application/json"),json.toString());
        return ServiceManager.getRequest().requestRegister(reqUser);
    }
}