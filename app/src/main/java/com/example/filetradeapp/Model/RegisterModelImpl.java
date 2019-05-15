
package com.example.filetradeapp.Model;


import com.example.filetradeapp.Contract;
import com.example.filetradeapp.Util.Bean.FileBean;
import com.example.filetradeapp.Util.Bean.RegisterBean;
import com.example.filetradeapp.Util.IO.ServiceManager;

import io.reactivex.Observable;
import retrofit2.Response;

public class RegisterModelImpl implements Contract.IRegisterModel {


    @Override
    public Observable<Response<RegisterBean>> doRegister(String username, String password, String phone) {
        return ServiceManager.getRequest().requestRegister();
    }
}