package com.example.filetradeapp.Activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.Looper;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.filetradeapp.Config;
import com.example.filetradeapp.Contract;
import com.example.filetradeapp.Presenter.DetailPresenterImpl;
import com.example.filetradeapp.Presenter.DownloadPresenterImpl;
import com.example.filetradeapp.R;
import com.example.filetradeapp.Util.Bean.FileBean;
import com.example.filetradeapp.Util.Bean.File_label;


public class DetailActivity extends AppCompatActivity implements Contract.IDetailView,Contract.IDownloadView{

    private Toolbar toolbar;
    private TextView toolbarTitle;
    private ImageButton starButton;
    private Button btn_buy;//下载按钮
    private Button btn_download;//下载按钮
    private TextView tv_date,tv_name,tv_type,tv_int,tv_1,tv_2,tv_3;
    private FileBean fileBean;
    private static DetailPresenterImpl presenter = new DetailPresenterImpl();
    private static DownloadPresenterImpl dpresenter = new DownloadPresenterImpl();

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //设置页面布局 ,注册界面
        setContentView(R.layout.activity_detail);
        //设置此界面为竖屏
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        init();
        setToolbar();
        toolbarTitle.setText("详情");

        fileBean = (FileBean) getIntent().getSerializableExtra("fileBean");

        presenter.attachView(this);
        dpresenter.attachView(this);
        presenter.doDetail(fileBean.getFid());
        }


    private void setToolbar(){
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("");
        toolbarTitle = (TextView) findViewById(R.id.toolbar_txt);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if(id==android.R.id.home){
            finish();
            return true;
        }
        else return false;
    }

    private void init() {

        btn_download = findViewById(R.id.btn_download);
        tv_date= findViewById(R.id.tv_date);
        tv_name= findViewById(R.id.tv_name);
        tv_type= findViewById(R.id.tv_type);
        tv_int= findViewById(R.id.tv_int);
        tv_1= findViewById(R.id.tv_1);
        tv_2= findViewById(R.id.tv_2);
        tv_3 = findViewById(R.id.tv_3);

        btn_download.setClickable(false);
        //下载按钮
        btn_download.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dpresenter.doDownload("file/download/"+fileBean.getFid()+"."+fileBean.getType(),Config.storageURL + "/"+fileBean.getTitle()+"."+fileBean.getType(),DetailActivity.this);
                }
        });
    }

    /**     * 填充详情页面     */
    private void setEditString(File_label label){

        tv_date.setText(fileBean.getTime());
        tv_name.setText(fileBean.getUid());
        tv_type.setText(fileBean.getType());
        tv_int.setText(fileBean.getCredit());
        tv_1.setText(label.getLabel_1());
        tv_2.setText(label.getLabel_2());
        tv_3.setText(label.getLabel_3());
    }


    @Override
    public void onDownload(boolean bool) {
        Looper.prepare();
        if(bool) Toast.makeText(getApplicationContext(), "文件下载成功", Toast.LENGTH_SHORT).show();
        else Toast.makeText(getApplicationContext(), "文件下载失败", Toast.LENGTH_SHORT).show();
        Looper.loop();
    }

    @Override
    public void onDetail(File_label label) {
        setEditString(label);
    }

    @Override
    public void onAddCollection(boolean bool) {
        starButton.setImageDrawable(ContextCompat.getDrawable(DetailActivity.this,R.drawable.stared));
    }

    @Override
    public void onDeleteCollection(boolean bool) {
        starButton.setImageDrawable(ContextCompat.getDrawable(DetailActivity.this,R.drawable.unstar));
    }

    @Override
    public void onBuy(boolean bool) {
        if(bool) {
            btn_download.setClickable(true);
            btn_buy.setVisibility(View.GONE);
        }
    }
}