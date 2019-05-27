package com.example.filetradeapp.Model;

import com.example.filetradeapp.Config;
import com.example.filetradeapp.Contract;
import com.example.filetradeapp.Util.Bean.UserBean;
import com.example.filetradeapp.Util.IO.ServiceManager;

import io.reactivex.Observable;
import retrofit2.Response;

public class UserModelImpl implements Contract.IUserModel {
    @Override
    public Observable<Response<UserBean>> doUser() {
        return ServiceManager.getRequest().requestUser(Config.userId);
    }
}
