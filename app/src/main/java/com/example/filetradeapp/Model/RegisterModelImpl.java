
package com.example.filetradeapp.Model;


import com.example.filetradeapp.Contract;

public class RegisterModelImpl implements Contract.IRegisterModel {


    @Override
    public void doRegister(String username, String password, String phone, String email, int sex) {
        new UniversalPresenter().RegisterByRetrofit(username, password, phone, email, sex);
    }
}