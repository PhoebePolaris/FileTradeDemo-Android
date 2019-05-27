package com.example.filetradeapp.Presenter;

import com.example.filetradeapp.Contract;
import com.example.filetradeapp.Model.UserModelImpl;
import com.example.filetradeapp.Util.Bean.UserBean;

import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Response;

public class UserPresenterImpl implements Contract.IUserPresenter {

    private UserModelImpl model;
    private Contract.IUserView view;

    public UserPresenterImpl() {
        model = new UserModelImpl();
    }

    public void attachView(Contract.IUserView view) {
        this.view = view;
    }

    @Override
    public void doUser() {
        model.doUser()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Response<UserBean>>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                    }

                    @Override
                    public void onNext(Response<UserBean> result) {
                        if(result.isSuccessful()) view.onUser(result.body().getCredit());
                        else view.onUser(0);
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
