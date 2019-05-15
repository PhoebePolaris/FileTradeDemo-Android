package com.example.filetradeapp.Model;

import com.example.filetradeapp.Contract;
import com.example.filetradeapp.Util.Bean.FileBean;
import com.example.filetradeapp.Util.IO.ServiceManager;

import io.reactivex.Observable;
import retrofit2.Response;

public class DownloadModelImpl implements Contract.IDownloadModel {
    @Override
    public Observable<Response<FileBean>> doDownload(String url, String filePath) {
        return ServiceManager.getRequest().requestDownload(url);
    }
}
