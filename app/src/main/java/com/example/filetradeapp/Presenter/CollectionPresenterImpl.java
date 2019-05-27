package com.example.filetradeapp.Presenter;

import com.example.filetradeapp.Contract;
import com.example.filetradeapp.Model.CollectionModelImpl;
import com.example.filetradeapp.Util.Bean.FileBean;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Response;

public class CollectionPresenterImpl implements Contract.ICollectionPresenter {

    private CollectionModelImpl model;
    private Contract.ICollectionView view;

    public CollectionPresenterImpl() {
        model = new CollectionModelImpl();
    }

    public void attachView(Contract.ICollectionView view) {
        this.view = view;
    }

    @Override
    public void doCollection() {
        model.doCollection()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Response<List<FileBean>>>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                    }

                    @Override
                    public void onNext(Response<List<FileBean>> result) {
                        if(result.isSuccessful()) view.onCollection(result.body());
                        else view.onCollection(null);
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
