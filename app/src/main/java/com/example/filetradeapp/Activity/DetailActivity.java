package com.example.filetradeapp.Activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.example.filetradeapp.R;


public class DetailActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private TextView toolbarTitle;
    private Button btn_download;//下载按钮
    private TextView tv_date,tv_name,tv_type,tv_int,tv_1,tv_2,tv_3;
    private String tvdate,tvname,tvtype,tvint,tv1,tv2,tv3;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //设置页面布局 ,注册界面
        setContentView(R.layout.activity_detail);
        //设置此界面为竖屏
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        init();
        setToolbar();
        toolbarTitle.setText("详情");
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

        //下载按钮
        btn_download.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                return;
                }
        });
    }

    /**     * 填充详情页面     */
    private void setEditString(){



    }



}