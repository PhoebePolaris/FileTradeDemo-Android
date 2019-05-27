package com.example.filetradeapp.Presenter;

import com.example.filetradeapp.Config;
import com.example.filetradeapp.Contract;
import com.example.filetradeapp.Model.PasswordModelImpl;
import com.example.filetradeapp.Util.Bean.UserBean;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Response;

public class PasswordPresenterImpl implements Contract.IPasswordPresenter {
    private PasswordModelImpl model;
    private Contract.IPasswordView view;

    public PasswordPresenterImpl() {
        model = new PasswordModelImpl();
    }

    public void attachView(Contract.IPasswordView view) {
        this.view = view;
    }

    @Override
    public void doPassword(String phone, String password) {
        model.doPassword(phone, password)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Response<UserBean>>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                    }

                    @Override
                    public void onNext(Response<UserBean> result) {
                        view.onPassword(result.isSuccessful());
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
