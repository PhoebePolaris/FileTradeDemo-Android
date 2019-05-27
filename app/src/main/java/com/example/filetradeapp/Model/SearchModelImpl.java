package com.example.filetradeapp.Model;

import com.example.filetradeapp.Config;
import com.example.filetradeapp.Contract;
import com.example.filetradeapp.Util.Bean.FileBean;
import com.example.filetradeapp.Util.IO.ServiceManager;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.Response;

public class SearchModelImpl implements Contract.ISearchModel {
    @Override
    public Observable<Response<List<FileBean>>> doSearch(String word) {
        return ServiceManager.getRequest().requestSearch(word);
    }

    @Override
    public Observable<Response<List<FileBean>>> doRecommend() {
        return ServiceManager.getRequest().requestRecommend(Config.userId);
    }
}
