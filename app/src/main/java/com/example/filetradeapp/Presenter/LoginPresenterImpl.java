package com.example.filetradeapp.Presenter;


import com.example.filetradeapp.Config;
import com.example.filetradeapp.Contract;
import com.example.filetradeapp.Model.DownloadModelImpl;
import com.example.filetradeapp.Model.LoginModelImpl;
import com.example.filetradeapp.Util.Bean.FileBean;
import com.example.filetradeapp.Util.Bean.UserBean;

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
    public void doLogin(String phone, String password) {
        model.doLogin(phone, password)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Response<UserBean>>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                    }

                    @Override
                    public void onNext(Response<UserBean> result) {
                        UserBean userBean = result.body();
                        Config.userId = userBean.getUser_id();
                        Config.username = userBean.getUser_name();
                        Config.credit = userBean.getCredit();
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
