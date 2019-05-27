package com.example.filetradeapp.Activity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.filetradeapp.Config;
import com.example.filetradeapp.Contract;
import com.example.filetradeapp.R;
import com.example.filetradeapp.Util.Bean.FileBean;
import com.example.filetradeapp.Util.IO.FileUtils;

public class UploadActivity extends AppCompatActivity implements Contract.IUploadView{


    private static EditText file_name;
    private static Spinner file_type;
    private static Button btn_queren;
    private static Button upload;
    private static EditText file_jifen;
    private static EditText file_tag1;
    private static EditText file_tag2;
    private static EditText file_tag3;

    private static Toolbar toolbar;
    private static TextView toolbarTitle;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //设置页面布局 ,注册界面
        setContentView(R.layout.activity_upload);
        //设置此界面为竖屏
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        init();
        setToolbar();
        toolbarTitle.setText("上传");

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

        file_name = (EditText)findViewById(R.id.file_name);
        btn_queren = (Button)findViewById(R.id.btn_queren);
        upload = (Button) findViewById(R.id.upload);
        file_jifen = (EditText) findViewById(R.id.file_jifen);
        file_tag1 = (EditText) findViewById(R.id.file_tag1);
        file_tag2 = (EditText) findViewById(R.id.file_tag2);
        file_tag3 = (EditText) findViewById(R.id.file_tag3);

        //上传控件的点击事件
        upload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            //上传文件
            Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
            intent.setType("*/*");
            intent.addCategory(Intent.CATEGORY_OPENABLE);
            startActivityForResult(intent,1);

            }
        });

        //确认控件的点击事件
        btn_queren.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "上传成功", Toast.LENGTH_SHORT).show();
                FileBean b = new FileBean();
                b.setTitle(file_name.getText().toString());
                b.setType("doc");
            }
        });


    }

    @Override
    protected void onActivityResult(int requestCode,int resultCode,Intent data){
        super.onActivityResult(requestCode,resultCode,data);
        if(resultCode==RESULT_OK){
            switch(requestCode){
                case 1:
                    Uri uri=data.getData();
                    String filePath;
                    if (uri != null) {
                        filePath = FileUtils.getFilePathByUri(this,uri);

                        String title = "test";
                        int credit = 0;
                        //presenter.doUpload(Config.uid,UUID.randomUUID().toString().replaceAll("-", ""),filePath,title,credit);
                        Toast.makeText(this, "文件已选择", Toast.LENGTH_SHORT).show();
                    }
                    break;
            }
        }
    }

    @Override
    public void onUpload(boolean bool) {
        if(bool) Toast.makeText(this, "文件上传成功", Toast.LENGTH_SHORT).show();
        else Toast.makeText(this, "文件上传失败", Toast.LENGTH_SHORT).show();
    }



}
