package com.example.filetradeapp.Presenter;

import com.example.filetradeapp.Contract;
import com.example.filetradeapp.Model.UploadLogModelImpl;
import com.example.filetradeapp.Util.Bean.FileBean;

import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Response;

public class UploadLogPresenterImpl implements Contract.IUploadLogPresenter {

    private UploadLogModelImpl model;
    private Contract.IUploadLogView view;

    public UploadLogPresenterImpl() {
        model = new UploadLogModelImpl();
    }

    public void attachView(Contract.IUploadLogView view) {
        this.view = view;
    }

    @Override
    public void doUploadLog() {
        model.doUploadLog()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Response<List<FileBean>>>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                    }

                    @Override
                    public void onNext(Response<List<FileBean>> result) {
                        if(result.isSuccessful()) view.onUploadLog(result.body());
                        else view.onUploadLog(null);
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
