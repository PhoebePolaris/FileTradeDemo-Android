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

import com.example.filetradeapp.Activity.SomeActivity;
import com.example.filetradeapp.Activity.SomeRecyclerActivity;
import com.example.filetradeapp.Config;
import com.example.filetradeapp.R;

public class NavUserFragment extends Fragment {
    private View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        view = inflater.inflate(R.layout.fragment_user, null);

        Button button=(Button)view.findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().finish();
            }
        });

        TextView tx = (TextView)view.findViewById(R.id.textView);
        tx.setText(Config.username);
        /*LinearLayout my_import=(LinearLayout)view.findViewById(R.id.my_source);
        my_import.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(),SomeRecyclerActivity.class);
                startActivity(intent);
            }
        });
        */
        LinearLayout my_favor=(LinearLayout)view.findViewById(R.id.my_collection);
        my_favor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(),SomeRecyclerActivity.class);
                startActivity(intent);
            }
        });

        return view;
    }
}
