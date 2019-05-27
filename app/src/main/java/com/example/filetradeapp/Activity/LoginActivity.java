package com.example.filetradeapp.Activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.filetradeapp.Config;
import com.example.filetradeapp.Contract;
import com.example.filetradeapp.Presenter.LoginPresenterImpl;
import com.example.filetradeapp.Presenter.UploadPresenterImpl;
import com.example.filetradeapp.R;
import com.example.filetradeapp.Util.Bean.LoginBean;
import com.example.filetradeapp.Util.IO.ServiceManager;


public class LoginActivity extends AppCompatActivity implements Contract.ILoginView {

    private static EditText et_phonenum;
    private static EditText et_psw;
    private static Button btn_login;
    private static TextView tv_register;
    private static TextView tv_find_psw;

    private static Toolbar toolbar;
    private static TextView toolbarTitle;

    private String phonenum, psw;

    private static LoginPresenterImpl presenter = new LoginPresenterImpl();

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);//设置此界面为竖屏
        setToolbar();
        toolbarTitle.setText("登录");

        ServiceManager.init();

        init();
        presenter.attachView(this);

        et_phonenum.setText("root");
        et_psw.setText("123456");
    }

    private void setToolbar(){
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("");
        toolbarTitle = (TextView) findViewById(R.id.toolbar_txt);
        setSupportActionBar(toolbar);
    }

    private void init() {

        et_phonenum = (EditText) findViewById(R.id.et_phonenum);
        et_psw = (EditText) findViewById(R.id.et_psw);
        btn_login = (Button) findViewById(R.id.btn_login);
        tv_register = (TextView) findViewById(R.id.tv_register);
        tv_find_psw = (TextView) findViewById(R.id.tv_find_psw);

        //立即注册控件的点击事件
        tv_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //为了跳转到注册界面，并实现注册功能
                LoginActivity.this.finish();
                startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
            }
        });

        //重置密码控件的点击事件
        tv_find_psw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, PasswordActivity.class);
                startActivityForResult(intent, 1);
            }
        });

        //登录按钮的点击事件
        btn_login.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 //开始登录，获取手机号和密码 getText().toString().trim();
                 phonenum = et_phonenum.getText().toString().trim();
                 psw = et_psw.getText().toString().trim();
                 if (TextUtils.isEmpty(phonenum)) {
                     Toast.makeText(LoginActivity.this, "请输入手机号", Toast.LENGTH_SHORT).show();
                     return;
                 } else if (TextUtils.isEmpty(psw)) {
                     Toast.makeText(LoginActivity.this, "请输入密码", Toast.LENGTH_SHORT).show();
                     return;
                 }
                 presenter.doLogin(phonenum, psw);
                 Toast.makeText(LoginActivity.this, "登录成功", Toast.LENGTH_SHORT).show();
                 LoginActivity.this.finish();
                 startActivity(new Intent(LoginActivity.this, MenuActivity.class));
             }
         });
    }

    /**
     * 从SharedPreferences中根据用户名读取密码
     */
    private String readPsw(String phonenum) {
        //getSharedPreferences("loginInfo",MODE_PRIVATE);
        // "loginInfo",mode_private; MODE_PRIVATE表示可以继续写入
        SharedPreferences sp = getSharedPreferences("loginInfo", MODE_PRIVATE);
        //sp.getString() phonenum, "";
        return sp.getString(phonenum, "");
    }


    @Override
    //显示数据， onActivityResult
    //startActivityForResult(intent, 1); 从注册界面中获取数据
    //int requestCode , int resultCode , Intent data
    //LoginActivity -> startActivityForResult -> onActivityResult();
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        //super.onActivityResult(requestCode, resultCode, data);
        super.onActivityResult(requestCode, resultCode, data);
        if (data != null) {
            //是获取注册界面回传过来的手机号
            //getExtra().getString("***");
            String phone = data.getStringExtra("username");
            if (!TextUtils.isEmpty(phone)) {
                //设置用户名到 et_phonenum 控件
                et_phonenum.setText(phone);
                //et_phonenum控件的setSelection()方法来设置光标位置
                et_phonenum.setSelection(phone.length());
            }
        }
    }

    @Override
    public void onLogin(boolean bool) {
         if (bool) {
             Toast.makeText(LoginActivity.this, "登录成功", Toast.LENGTH_SHORT).show();
             LoginActivity.this.finish();
             startActivity(new Intent(LoginActivity.this, LabelActivity.class));
         }
         else {
             Toast.makeText(this, "登录失败", Toast.LENGTH_SHORT).show();
         }
    }
}



