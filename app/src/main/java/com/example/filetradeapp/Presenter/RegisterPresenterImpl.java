package com.example.filetradeapp.Presenter;


import com.example.filetradeapp.Contract;
import com.example.filetradeapp.Model.LoginModelImpl;
import com.example.filetradeapp.Model.RegisterModelImpl;
import com.example.filetradeapp.Util.Bean.FileBean;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Response;

public class RegisterPresenterImpl implements Contract.IRegisterPresenter{

    private RegisterModelImpl model;
    private Contract.IRegisterView view;

    public RegisterPresenterImpl() {
        model = new RegisterModelImpl();
    }

    public void attachView(Contract.IRegisterView view) {
        this.view = view;
    }

    @Override
    public void doRegister(String username, String password, String phone) {
        model.doRegister(username, password,phone)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Response<FileBean>>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                    }

                    @Override
                    public void onNext(Response<FileBean> result) {
                        view.onRegister(result.isSuccessful());
                    }

                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();
                    }

                    @Override
                    public void onComplete() {
                    }
                });
    }
}

