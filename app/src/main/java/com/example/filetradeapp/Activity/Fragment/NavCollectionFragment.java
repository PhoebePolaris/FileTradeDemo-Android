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
import com.example.filetradeapp.Contract;
import com.example.filetradeapp.Presenter.CollectionPresenterImpl;
import com.example.filetradeapp.R;
import com.example.filetradeapp.Util.Bean.FileBean;

import java.util.ArrayList;
import java.util.List;

public class NavCollectionFragment extends Fragment implements Contract.ICollectionView {

    private View view;
    private static CollectionPresenterImpl presenter = new CollectionPresenterImpl();

    private List<FileBean> cardList = new ArrayList<>();
    private FileCardRecyclerAdapter recyclerAdapter = new FileCardRecyclerAdapter(cardList);
    private RecyclerView recyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        view = inflater.inflate(R.layout.fragment_recycler, container,false);

        presenter.attachView(this);
        presenter.doCollection();

        RecyclerView recyclerView=(RecyclerView)view.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext(),LinearLayoutManager.VERTICAL,false));
        recyclerView.setAdapter(recyclerAdapter);

        return view;
    }

    @Override
    public void onCollection(List<FileBean> list) {
        if(list!=null){
            cardList = list;
            recyclerAdapter.resetCardList(cardList);
        }
        else {
            Toast.makeText(getContext(), "获得列表失败", Toast.LENGTH_SHORT).show();
            cardList = new ArrayList<>();
            recyclerAdapter.resetCardList(cardList);
        }
    }

    public static CollectionPresenterImpl getPresenter(){
        return presenter;
    }
}

