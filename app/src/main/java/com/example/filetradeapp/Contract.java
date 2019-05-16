package com.example.filetradeapp;

import android.app.Activity;

import com.example.filetradeapp.Util.Bean.FileBean;
import com.example.filetradeapp.Util.Bean.UserBean;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.Response;

public interface Contract {

    //登录
    interface ILoginView {
        void onLogin(boolean bool);
    }
    interface ILoginModel {
        Observable<Response<UserBean>> doRegister(String username, String password);
    }
    interface ILoginPresenter {
        void doLogin(String username, String password);
    }

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
        Observable<ResponseBody> doDownload(String url);
    }
    interface IDownloadPresenter {
        void doDownload(String url, String path, Activity context);
    }
}
