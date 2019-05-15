package com.example.filetradeapp;

import com.example.filetradeapp.Util.Bean.FileBean;
import com.example.filetradeapp.Util.Bean.LoginBean;
import com.example.filetradeapp.Util.Bean.RegisterBean;
import com.example.filetradeapp.Util.Bean.UserBean;

import io.reactivex.Observable;
import retrofit2.Response;

public interface Contract {


    //登录
    interface ILoginView {
        void onLoginCall(LoginBean.ResResultBean bean);
    }
    interface ILoginModel {
        void doLogin(String username, String password);
    }
    interface ILoginPresenter {
        void doLogin(String username, String password);
    }


    //注册
    interface IRegisterView {
        void onRegisterResult(RegisterBean.ResResultBean resResultBean);
    }

    interface IRegisterModel {
        void doRegister(String username, String password, String phone, String email, int sex);
    }

    interface IRegisterPresenter {
        void doRegister(String username, String password, String phone, String email, int sex);
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
