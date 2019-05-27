package com.example.filetradeapp.Presenter;

import com.example.filetradeapp.Contract;
import com.example.filetradeapp.Model.DownloadLogModelImpl;
import com.example.filetradeapp.Util.Bean.FileBean;

import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Response;

public class DownloadLogPresenterImpl implements Contract.IDownloadLogPresenter {


    private DownloadLogModelImpl model;
    private Contract.IDownloadLogView view;

    public DownloadLogPresenterImpl() {
        model = new DownloadLogModelImpl();
    }

    public void attachView(Contract.IDownloadLogView view) {
        this.view = view;
    }

    @Override
    public void doDownloadLog() {
        model.doDownloadLog()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Response<List<FileBean>>>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                    }

                    @Override
                    public void onNext(Response<List<FileBean>> result) {
                        if(result.isSuccessful()) view.onDownloadLog(result.body());
                        else view.onDownloadLog(null);
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
