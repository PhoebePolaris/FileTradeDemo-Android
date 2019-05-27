package com.example.filetradeapp.Presenter;

import com.example.filetradeapp.Contract;
import com.example.filetradeapp.Model.BuyLogModelImpl;
import com.example.filetradeapp.Util.Bean.FileBean;

import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Response;

public class BuyLogPresenterImpl implements Contract.IBuyLogPresenter {

    private BuyLogModelImpl model;
    private Contract.IBuyLogView view;

    public BuyLogPresenterImpl() {
        model = new BuyLogModelImpl();
    }

    public void attachView(Contract.IBuyLogView view) {
        this.view = view;
    }

    @Override
    public void doBuyLog() {
        model.doBuyLog()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Response<List<FileBean>>>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                    }

                    @Override
                    public void onNext(Response<List<FileBean>> result) {
                        if(result.isSuccessful()) view.onBuyLog(result.body());
                        else view.onBuyLog(null);
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
