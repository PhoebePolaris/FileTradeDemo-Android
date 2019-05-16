package com.example.filetradeapp.Presenter;


import com.example.filetradeapp.Contract;
import com.example.filetradeapp.Model.DownloadModelImpl;
import com.example.filetradeapp.Model.LoginModelImpl;
import com.example.filetradeapp.Util.Bean.FileBean;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Response;

public class LoginPresenterImpl implements Contract.ILoginPresenter {
    private LoginModelImpl model;
    private Contract.ILoginView view;

    public LoginPresenterImpl() {
        model = new LoginModelImpl();
    }

    public void attachView(Contract.ILoginView view) {
        this.view = view;
    }

    @Override
    public void doLogin(String username, String password) {
        model.doLogin(username, password)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Response<FileBean>>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                    }

                    @Override
                    public void onNext(Response<FileBean> result) {
                        view.onLogin(result.isSuccessful());
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
