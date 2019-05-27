package com.example.filetradeapp.Model;

import com.example.filetradeapp.Config;
import com.example.filetradeapp.Contract;
import com.example.filetradeapp.Util.Bean.FileBean;
import com.example.filetradeapp.Util.IO.ServiceManager;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.Response;

public class DownloadLogModelImpl implements Contract.IDownloadLogModel {
    @Override
    public Observable<Response<List<FileBean>>> doDownloadLog() {
        return ServiceManager.getRequest().requestDownloadLog(Config.userId);
    }
}
