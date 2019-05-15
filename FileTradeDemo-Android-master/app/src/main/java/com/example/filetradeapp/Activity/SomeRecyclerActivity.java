package com.example.filetradeapp.Activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.filetradeapp.Activity.Adapter.FileCardRecyclerAdapter;
import com.example.filetradeapp.Activity.Entity.FileCard;
import com.example.filetradeapp.Config;
import com.example.filetradeapp.R;

import java.util.ArrayList;
import java.util.List;

public class SomeRecyclerActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private TextView toolbarTitle;
    private View view;

    //private static GroupPresenterImpl presenter = new GroupPresenterImpl();
    //private List<FileCard> cardList = new ArrayList<>();
    private List<FileCard> cardList = Config.getTestList();
    private FileCardRecyclerAdapter recyclerAdapter = new FileCardRecyclerAdapter(cardList);
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        view = View.inflate(this,R.layout.activity_recycler,null);
        setContentView(view);

        //presenter.attachView(this);

        setToolbar();

        toolbarTitle.setText("someLog");
        //presenter.doGetUserGroups();

        recyclerView=(RecyclerView)findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(SomeRecyclerActivity.this,LinearLayoutManager.VERTICAL,false));
        recyclerView.setAdapter(recyclerAdapter);
    }

    private void setToolbar(){
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("");
        toolbarTitle = (TextView) findViewById(R.id.toolbar_txt);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // 绑定toolbar跟menu
        getMenuInflater().inflate(R.menu.toolbar, menu);
        toolbar.getMenu().findItem(R.id.add).setVisible(false);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:{
                finish();
                return true;
            }
        }
        return false;
    }

//    public static GroupPresenterImpl getPresenter(){
//        return presenter;
//    }
//
//    @Override
//    public void onUserGroupsRetrieved(String status) {
//        if(status.equals("success")){
//            cardList = presenter.getUserGroups();
//            if(cardList==null) cardList = new ArrayList<>();
//            recyclerAdapter.resetCardList(cardList);
//        }
//        else {
//            Toast.makeText(GroupActivity.this, "获得小组失败", Toast.LENGTH_SHORT).show();
//            cardList = new ArrayList<>();
//            recyclerAdapter.resetCardList(cardList);
//        }
//    }
}

