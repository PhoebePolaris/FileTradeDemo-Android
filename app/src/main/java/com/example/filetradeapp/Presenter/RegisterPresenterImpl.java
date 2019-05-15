package com.example.filetradeapp.Presenter;


import com.example.filetradeapp.Contract;
import com.example.filetradeapp.Model.RegisterModelImpl;

public class RegisterPresenterImpl implements Contract.IRegisterPresenter{

    private RegisterModelImpl model;
    //View
    private Contract.IRegisterView registerView;

    public RegisterPresenterImpl() {
        model = new RegisterModelImpl();
        if (!EventBus.getDefault().isRegistered(this))
            EventBus.getDefault().register(this);
    }

    public void attachView(Contract.IRegisterView view) {
        registerView = view;
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onRegisterCall(RegisterEvent registerEvent) {
        //处理注册结果
        registerView.onRegisterResult(registerEvent.getResult());
    }

    @Override
    public void doRegister(String username, String password, String phone, String email, int sex) {
        model.doRegister(username, password, phone, email, sex);
    }
}

