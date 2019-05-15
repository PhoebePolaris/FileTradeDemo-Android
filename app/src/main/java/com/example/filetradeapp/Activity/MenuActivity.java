package com.example.filetradeapp.Activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.example.filetradeapp.Activity.Fragment.NavCollectionFragment;
import com.example.filetradeapp.Activity.Fragment.NavHomeFragment;
import com.example.filetradeapp.Activity.Fragment.NavUserFragment;
import com.example.filetradeapp.Config;
import com.example.filetradeapp.Contract;
import com.example.filetradeapp.Presenter.UploadPresenterImpl;
import com.example.filetradeapp.R;
import com.example.filetradeapp.Util.IO.FileUtils;
import com.example.filetradeapp.Util.IO.PermissionUtil;
import com.example.filetradeapp.Util.IO.ServiceManager;

import java.io.File;
import java.util.Timer;
import java.util.TimerTask;
import java.util.UUID;

public class MenuActivity extends AppCompatActivity implements Contract.IUploadView {

    private static Toolbar toolbar;
    private static TextView toolbarTitle;

    private BottomNavigationView navigation;
    private static FragmentManager fragmentManager;
    private static NavHomeFragment homeFragment;
    private static NavCollectionFragment collectionFragment;
    private static NavUserFragment userFragment;

    private static final int home = 0;
    private static final int collection = 1;
    private static final int user = 2;

    private static int current = home;

    private boolean isExit=false;
    private static String path;

    private static UploadPresenterImpl presenter = new UploadPresenterImpl();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        setToolbar();

        ServiceManager.init();
        presenter.attachView(this);

        toolbarTitle.setText("主页");
        homeFragment = new NavHomeFragment();
        fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().add(R.id.menu_container, homeFragment).show(homeFragment).commit();

        setNavigation();
    }

    private void setToolbar(){
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("");
        toolbarTitle = (TextView) findViewById(R.id.toolbar_txt);
        setSupportActionBar(toolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // 绑定toolbar跟menu
        getMenuInflater().inflate(R.menu.toolbar, menu);
        toolbar.getMenu().findItem(R.id.add).setVisible(true);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == R.id.add){
            //上传文件
            Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
            intent.setType("*/*");
            intent.addCategory(Intent.CATEGORY_OPENABLE);
            startActivityForResult(intent,1);
            return true;
        }
        return false;
    }

    private void setNavigation(){
        navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                return setCurrent(item.getItemId());
            }
        });
    }

    private static boolean setCurrent(int itemId){
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        switch (itemId) {
            case R.id.navigation_home:{
                if (current == home) return true;
                current = home;
                if(collectionFragment !=null) transaction.hide(collectionFragment);
                if(userFragment !=null) transaction.hide(userFragment);
                transaction.show(homeFragment).commit();
                toolbarTitle.setText("主页");
                toolbar.getMenu().findItem(R.id.add).setVisible(true);
                return true;
            }
            case R.id.navigation_collection:{
                if (current == collection) return true;
                current = collection;
                if(homeFragment !=null) transaction.hide(homeFragment);
                if(userFragment !=null) transaction.hide(userFragment);
                if (collectionFragment == null) {
                    collectionFragment = new NavCollectionFragment();
                    transaction.add(R.id.menu_container, collectionFragment).commit();
                }
                else transaction.show(collectionFragment).commit();
                toolbarTitle.setText("收藏夹");
                toolbar.getMenu().findItem(R.id.add).setVisible(false);
                return true;
            }
            case R.id.navigation_user:{
                if (current == user) return true;
                current = user;
                if(homeFragment !=null) transaction.hide(homeFragment);
                if(collectionFragment !=null) transaction.hide(collectionFragment);
                if (userFragment == null) {
                    userFragment = new NavUserFragment();
                    transaction.add(R.id.menu_container, userFragment).commit();
                }
                else transaction.show(userFragment).commit();
                toolbarTitle.setText("用户设置");
                toolbar.getMenu().findItem(R.id.add).setVisible(false);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode == KeyEvent.KEYCODE_BACK) {
            if(!isExit) {
                isExit = true;
                Toast.makeText(this, "再按一次退出程序", Toast.LENGTH_SHORT).show();
                new Timer().schedule(new TimerTask() {
                    @Override
                    public void run() {
                        isExit = false;
                    }
                }, 2000);
            }
            else {
                moveTaskToBack(false);
            }
        }
        return false;
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
                        presenter.doUpload(Config.uid,UUID.randomUUID().toString().replaceAll("-", ""),filePath,title,credit);
                        Toast.makeText(this, "文件上传中", Toast.LENGTH_SHORT).show();
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
