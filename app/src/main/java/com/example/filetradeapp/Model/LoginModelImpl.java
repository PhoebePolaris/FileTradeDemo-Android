package com.example.filetradeapp.Model;


import com.example.filetradeapp.Contract;
import com.example.filetradeapp.Util.Bean.FileBean;
import com.example.filetradeapp.Util.IO.ServiceManager;

import io.reactivex.Observable;
import retrofit2.Response;

public class LoginModelImpl implements Contract.ILoginModel {


    @Override
    public Observable<Response<FileBean>> doLogin(String username, String password) {
        return ServiceManager.getRequest().requestDownload();
    }
}
