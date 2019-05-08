package com.example.filetradeapp.Activity.Fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.filetradeapp.Activity.Adapter.FileCardRecyclerAdapter;
import com.example.filetradeapp.Activity.Entity.FileCard;
import com.example.filetradeapp.Config;
import com.example.filetradeapp.R;

import java.util.ArrayList;
import java.util.List;

public class NavCollectionFragment extends Fragment {

    private View view;
    //private static NavMenuPresenterImpl presenter = new NavMenuPresenterImpl();

    //private List<FileCard> cardList = new ArrayList<>();
    private List<FileCard> cardList = Config.getTestList();
    private FileCardRecyclerAdapter recyclerAdapter = new FileCardRecyclerAdapter(cardList);
    private RecyclerView recyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        view = inflater.inflate(R.layout.fragment_recycler, container,false);

        //presenter.attachView(this);
        //presenter.doGetUserSources();

        RecyclerView recyclerView=(RecyclerView)view.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext(),LinearLayoutManager.VERTICAL,false));
        recyclerView.setAdapter(recyclerAdapter);

        return view;
    }

    //    public static NavMenuPresenterImpl getPresenter(){
//        return presenter;
//    }

//    @Override
//    public void onUserSourcesRetrieved(String status) {
//        if(status.equals("success")){
//            List<Source> list = presenter.getSources();
//            if(list==null) return;
//            StaticTool.sourceCardList = list;
//            recyclerAdapter.resetCardList(StaticTool.sourceCardList);
//        }
//        else {
//            Toast.makeText(getActivity(), "获得订阅列表失败", Toast.LENGTH_SHORT).show();
//        }
//    }
}

