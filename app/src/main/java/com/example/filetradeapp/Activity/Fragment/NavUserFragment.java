package com.example.filetradeapp.Activity.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.filetradeapp.Activity.BuyLogActivity;
import com.example.filetradeapp.Activity.CollectionActivity;
import com.example.filetradeapp.Activity.DownloadLogActivity;
import com.example.filetradeapp.Activity.LabelActivity;
import com.example.filetradeapp.Activity.UploadLogActivity;
import com.example.filetradeapp.Config;
import com.example.filetradeapp.Contract;
import com.example.filetradeapp.Presenter.UserPresenterImpl;
import com.example.filetradeapp.R;

public class NavUserFragment extends Fragment implements Contract.IUserView {
    private View view;
    private static UserPresenterImpl presenter = new UserPresenterImpl();

    TextView tx;
    TextView txcredit;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        view = inflater.inflate(R.layout.fragment_user, null);
        presenter.attachView(this);

        tx = (TextView)view.findViewById(R.id.textView);
        tx.setText(Config.username);
        txcredit = (TextView)view.findViewById(R.id.textView2_1);
        txcredit.setText(Config.credit);

        Button button=(Button)view.findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().finish();
            }
        });

        LinearLayout my_collection=(LinearLayout)view.findViewById(R.id.my_collection);
        my_collection.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(),CollectionActivity.class);
                startActivity(intent);
            }
        });

        LinearLayout my_upload=(LinearLayout)view.findViewById(R.id.my_upload);
        my_upload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(),UploadLogActivity.class);
                startActivity(intent);
            }
        });

        LinearLayout my_download=(LinearLayout)view.findViewById(R.id.my_download);
        my_download.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(),DownloadLogActivity.class);
                startActivity(intent);
            }
        });

        LinearLayout my_buy=(LinearLayout)view.findViewById(R.id.my_buy);
        my_buy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(),BuyLogActivity.class);
                startActivity(intent);
            }
        });

        LinearLayout my_label=(LinearLayout)view.findViewById(R.id.my_label);
        my_label.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(),LabelActivity.class);
                intent.putExtra("from",1);
                startActivity(intent);
            }
        });

        return view;
    }

    @Override
    public void onUser(int credit) {
        Config.credit = credit;
        txcredit.setText(credit);
    }

    public static UserPresenterImpl getPresenter(){
        return presenter;
    }

}
