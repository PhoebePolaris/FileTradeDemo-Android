package com.example.filetradeapp;

import com.example.filetradeapp.Util.Bean.FileBean;
import com.example.filetradeapp.Util.Bean.UserBean;

import io.reactivex.Observable;
import retrofit2.Response;

public interface Contract {

    //注册
    interface IRegisterView {
        void onRegister(boolean bool);
    }
    interface IRegisterModel {
        Observable<Response<UserBean>> doRegister(String username, String password);
    }
    interface IRegisterPresenter {
        void doRegister(String username, String password);
    }

    //上传
    interface IUploadView {
        void onUpload(boolean bool);
    }
    interface IUploadModel {
        Observable<Response<FileBean>> doUpload(String uid, String fid, String filePath, String title, int credit);
    }
    interface IUploadPresenter {
        void doUpload(String uid, String fid, String filePath, String title, int credit);
    }

    //下载
    interface IDownloadView {
        void onDownload(boolean bool);
    }
    interface IDownloadModel {
        Observable<Response<FileBean>> doDownload(String url, String filePath);
    }
    interface IDownloadPresenter {
        void doDownload(String url, String filePath);
    }
}
