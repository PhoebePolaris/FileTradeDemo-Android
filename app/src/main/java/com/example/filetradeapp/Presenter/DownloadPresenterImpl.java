package com.example.filetradeapp.Presenter;

import android.app.Activity;
import android.os.Environment;

import com.example.filetradeapp.Contract;
import com.example.filetradeapp.Model.DownloadModelImpl;
import com.example.filetradeapp.Util.Bean.FileBean;
import com.example.filetradeapp.Util.IO.FileUtils;

import java.io.File;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.ResponseBody;
import retrofit2.Response;

import static android.os.Environment.DIRECTORY_DOCUMENTS;

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
    public void doDownload(String url, final String path, final Activity context) {
        model.doDownload(url)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ResponseBody>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                    }

                    @Override
                    public void onNext(final ResponseBody result) {
                        new Thread(new Runnable() {
                            @Override
                            public void run() {
                                boolean bool = FileUtils.writeResponseBodyToDisk(context,path,result);
                                view.onDownload(bool);
                            }
                        }).start();
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