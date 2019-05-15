package com.example.filetradeapp.Presenter;


import com.example.filetradeapp.Contract;
import com.example.filetradeapp.Model.LoginModelImpl;

public class LoginPresenterImpl implements Contract.ILoginPresenter {

    //Model
    private LoginModelImpl model;
    //View
    private Contract.ILoginView loginView;

    public LoginPresenterImpl() {
        model = new LoginModelImpl();
        if (!EventBus.getDefault().isRegistered(this))
            EventBus.getDefault().register(this);
    }

    public void attachView(Contract.ILoginView view) {
        loginView = view;
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onLoginCall(LoginEvent loginEvent) {
        //处理登录结果
        loginView.onLoginCall(loginEvent.getResult());
    }


    @Override
    public void doLogin(String username, String password) {
        model.doLogin(username, password);
    }

}
