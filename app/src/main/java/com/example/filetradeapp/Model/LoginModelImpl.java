package com.example.filetradeapp.Model;


import com.example.filetradeapp.Contract;

public class LoginModelImpl implements Contract.ILoginModel {


    @Override
    public void doLogin(String username, String password) {
        new UniversalPresenter().LoginByRetrofit(username, password);
    }
}
