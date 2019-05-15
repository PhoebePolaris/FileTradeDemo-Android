package com.example.filetradeapp.Presenter;

import com.example.filetradeapp.Contract;
import com.example.filetradeapp.Model.UploadModelImpl;
import com.example.filetradeapp.Util.Bean.FileBean;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Response;


public class UploadPresenterImpl implements Contract.IUploadPresenter {

    private UploadModelImpl model;
    private Contract.IUploadView view;

    public UploadPresenterImpl() {
        model = new UploadModelImpl();
    }

    public void attachView(Contract.IUploadView view) {
        this.view = view;
    }

    @Override
    public void doUpload(String uid, String fid, String filePath, String title, int credit) {
        model.doUpload(uid, fid, filePath,title,credit)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Response<FileBean>>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                    }

                    @Override
                    public void onNext(Response<FileBean> result) {
                        view.onUpload(result.isSuccessful());
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
