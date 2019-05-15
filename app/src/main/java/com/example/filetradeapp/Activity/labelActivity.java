package com.example.filetradeapp.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.filetradeapp.Activity.Fragment.NavHomeFragment;
import com.example.filetradeapp.R;
import com.zhy.view.flowlayout.FlowLayout;
import com.zhy.view.flowlayout.TagAdapter;
import com.zhy.view.flowlayout.TagFlowLayout;

import java.util.ArrayList;

public class labelActivity extends AppCompatActivity {
    private TagFlowLayout flowLayout0;
    private TagFlowLayout flowLayout1;
    private TagFlowLayout flowLayout2;
    private TagFlowLayout flowLayout3;

    private ArrayList<String> item0 = new ArrayList<>();
    private ArrayList<String> item1 = new ArrayList<>();
    private ArrayList<String> item2 = new ArrayList<>();
    private ArrayList<String> item3 = new ArrayList<>();

    private TagAdapter<String> mAdapterFive;
    private TextView tv0;
    private TextView tv1;
    private TextView tv2;
    private TextView tv3;
    private int i0 = 0;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_label);

        Button btn = (Button) findViewById(R.id.login_btn);
        flowLayout0 = (TagFlowLayout) findViewById(R.id.flowlayout0);
        flowLayout1 = (TagFlowLayout) findViewById(R.id.flowlayout1);
        flowLayout2 = (TagFlowLayout) findViewById(R.id.flowlayout2);
        flowLayout3 = (TagFlowLayout) findViewById(R.id.flowlayout3);

        item0.add("一年级");item0.add("二年级");item0.add("三年级");item0.add("四年级");item0.add("五年级");
        item0.add("六年级");item0.add("初一");item0.add("初二");item0.add("初三");item0.add("高一");
        item0.add("高二");item0.add("高三");

        item1.add("计算机"); item1.add("数学"); item1.add("经济"); item1.add("物理学"); item1.add("新闻");
        item1.add("法学"); item1.add("医学"); item1.add("文学"); item1.add("历史学"); item1.add("电子信息");
        item1.add("资源环境"); item1.add("管理学"); item1.add("军事学"); item1.add("心理学"); item1.add("哲学");
        item1.add("农学"); item1.add("化学"); item1.add("生物学");

        item2.add("数学");item2.add("语文");item2.add("英语");item2.add("政治");item2.add("历史");item2.add("地理");
        item2.add("物理");item2.add("化学");item2.add("生物");

        item3.add("ACM");
        item3.add("数学建模");item3.add("英语竞赛");item3.add("创新创业");item3.add("互联网+");item3.add("机械创新设计");
        item3.add("临床技能竞赛");item3.add("广告艺术");item3.add("化学实验");

        //使用TagAdapter填充标签
        flowLayout0.setAdapter(mAdapterFive = new TagAdapter<String>(item0) {
            @Override
            public View getView(FlowLayout parent, int position, String s) {
                tv0 = new TextView(labelActivity.this);
                tv0.setTextSize(13);
                tv0.setPadding(34,18,34,18);
                tv0.setBackgroundResource(R.drawable.tag0);
                tv0.setText(s);
                return tv0;
            }
        });
        flowLayout1.setAdapter(mAdapterFive = new TagAdapter<String>(item1) {
            @Override
            public View getView(FlowLayout parent, int position, String s) {
                tv1 = new TextView(labelActivity.this);
                tv1.setTextSize(13);
                tv1.setPadding(34,18,34,18);
                tv1.setBackgroundResource(R.drawable.tag1);
                tv1.setText(s);
                return tv1;
            }
        });
        flowLayout2.setAdapter(mAdapterFive = new TagAdapter<String>(item2) {
            @Override
            public View getView(FlowLayout parent, int position, String s) {
                tv2 = new TextView(labelActivity.this);
                tv2.setTextSize(13);
                tv2.setPadding(34,18,34,18);
                tv2.setBackgroundResource(R.drawable.tag2);
                tv2.setText(s);
                return tv2;
            }
        });
        flowLayout3.setAdapter(mAdapterFive = new TagAdapter<String>(item3) {
            @Override
            public View getView(FlowLayout parent, int position, String s) {
                tv3 = new TextView(labelActivity.this);
                tv3.setTextSize(13);
                tv3.setPadding(34,18,34,18);
                tv3.setBackgroundResource(R.drawable.tag3);
                tv3.setText(s);
                return tv3;
            }
        });


        //监听
        flowLayout0.setOnTagClickListener(new TagFlowLayout.OnTagClickListener() {
            @Override
            public boolean onTagClick(View view, int position, FlowLayout parent) {
                Toast.makeText(labelActivity.this, item0.get(position), Toast.LENGTH_SHORT).show();

                return true;
            }
        });

        flowLayout1.setOnTagClickListener(new TagFlowLayout.OnTagClickListener() {
            @Override
            public boolean onTagClick(View view, int position, FlowLayout parent) {
                Toast.makeText(labelActivity.this, item1.get(position), Toast.LENGTH_SHORT).show();


                return true;
            }
        });
        flowLayout2.setOnTagClickListener(new TagFlowLayout.OnTagClickListener() {
            @Override
            public boolean onTagClick(View view, int position, FlowLayout parent) {

                return true;
            }
        });
        flowLayout3.setOnTagClickListener(new TagFlowLayout.OnTagClickListener() {
            @Override
            public boolean onTagClick(View view, int position, FlowLayout parent) {


                return true;
            }
        });

        //String[] labelString = new String[n];

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(labelActivity.this,NavHomeFragment.class);
                startActivity(intent);
            }
        });
    }
}
