package com.example.filetradeapp.Presenter;

import com.example.filetradeapp.Contract;
import com.example.filetradeapp.Model.SearchModelImpl;
import com.example.filetradeapp.Util.Bean.FileBean;

import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Response;

public class SearchPresenterImpl implements Contract.ISearchPresenter {

    private SearchModelImpl model;
    private Contract.ISearchView view;

    public SearchPresenterImpl() {
        model = new SearchModelImpl();
    }

    public void attachView(Contract.ISearchView view) {
        this.view = view;
    }

    @Override
    public void doSearch(String word) {
        model.doSearch(word)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Response<List<FileBean>>>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                    }

                    @Override
                    public void onNext(Response<List<FileBean>> result) {
                        if(result.isSuccessful()) view.onSearch(result.body());
                        else view.onSearch(null);
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

    @Override
    public void doRecommend() {
        model.doRecommend()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Response<List<FileBean>>>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                    }

                    @Override
                    public void onNext(Response<List<FileBean>> result) {
                        if(result.isSuccessful()) view.onRecommend(result.body());
                        else view.onRecommend(null);
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
