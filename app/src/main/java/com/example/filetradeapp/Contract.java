package com.example.filetradeapp;

import android.app.Activity;

import com.example.filetradeapp.Util.Bean.FileBean;
import com.example.filetradeapp.Util.Bean.File_label;
import com.example.filetradeapp.Util.Bean.LoginBean;
import com.example.filetradeapp.Util.Bean.RegisterBean;
import com.example.filetradeapp.Util.Bean.UserBean;

import java.util.List;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.Response;

public interface Contract {

    //登录
    interface ILoginView {
        void onLogin(boolean bool);
    }
    interface ILoginModel {
        Observable<Response<UserBean>> doLogin(String phone, String password);
    }
    interface ILoginPresenter {
        void doLogin(String phone, String password);
    }

    //注册
    interface IRegisterView {
        void onRegister(boolean bool);
    }
    interface IRegisterModel {
        Observable<Response<UserBean>> doRegister(String username, String password, String phone);
    }
    interface IRegisterPresenter {
        void doRegister(String username, String password, String phone);
    }

    //重置密码
    interface IPasswordView {
        void onPassword(boolean bool);
    }
    interface IPasswordModel {
        Observable<Response> doPassword(String phone, String password);
    }
    interface IPasswordPresenter {
        void doPassword(String phone, String password);
    }

    //搜索,推荐
    interface ISearchView {
        void onSearch(List<FileBean> list);
        void onRecommend(List<FileBean> list);
    }
    interface ISearchModel {
        Observable<Response<List<FileBean>>> doSearch(String word);
        Observable<Response<List<FileBean>>> doRecommend();
    }
    interface ISearchPresenter {
        void doSearch(String word);
        void doRecommend();
    }

    //详情,添加收藏,取消收藏,添加购买
    interface IDetailView {
        void onDetail(File_label label);
        void onAddCollection(boolean bool);
        void onDeleteCollection(boolean bool);
        void onBuy(boolean bool);
    }
    interface IDetailModel {
        Observable<Response<File_label>> doDetail(String fid);
        Observable<Response> doAddCollection(String fid);
        Observable<Response> doDeleteCollection(String fid);
        Observable<Response> doBuy(String fid);
    }
    interface IDetailPresenter {
        void doDetail(String fid);
        void doAddCollection(String fid);
        void doDeleteCollection(String fid);
        void doBuy(String fid);
    }

    //收藏列表
    interface ICollectionView {
        void onCollection(List<FileBean> list);
    }
    interface ICollectionModel {
        Observable<Response<List<FileBean>>> doCollection();
    }
    interface ICollectionPresenter {
        void doCollection();
    }

    //上传记录
    interface IUploadLogView {
        void onUploadLog(List<FileBean> list);
    }
    interface IUploadLogModel {
        Observable<Response<List<FileBean>>> doUploadLog();
    }
    interface IUploadLogPresenter {
        void doUploadLog();
    }

    //下载记录
    interface IDownloadLogView {
        void onDownloadLog(List<FileBean> list);
    }
    interface IDownloadLogModel {
        Observable<Response<List<FileBean>>> doDownloadLog();
    }
    interface IDownloadLogPresenter {
        void doDownloadLog();
    }

    //购买记录
    interface IBuyLogView {
        void onBuyLog(List<FileBean> list);
    }
    interface IBuyLogModel {
        Observable<Response<List<FileBean>>> doBuyLog();
    }
    interface IBuyLogPresenter {
        void doBuyLog();
    }

    //用户信息
    interface IUserView {
        void onUser(int credit);
    }
    interface IUserModel {
        Observable<Response<UserBean>> doUser();
    }
    interface IUserPresenter {
        void doUser();
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
