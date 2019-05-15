package com.example.filetradeapp.Presenter;

import com.example.filetradeapp.Contract;
import com.example.filetradeapp.Model.DownloadModelImpl;
import com.example.filetradeapp.Util.Bean.FileBean;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Response;

public class DownloadPresenterImpl implements Contract.IDownloadPresenter {

    private DownloadModelImpl model;
    private Contract.IDownloadView view;

    public DownloadPresenterImpl() {
        model = new DownloadModelImpl();
    }

    public void attachView(Contract.IDownloadView view) {
        this.view = view;
    }

    @Override
    public void doDownload(String url, String filePath) {
        model.doDownload(url,filePath)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Response<FileBean>>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                    }

                    @Override
                    public void onNext(Response<FileBean> result) {
                        view.onDownload(result.isSuccessful());
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