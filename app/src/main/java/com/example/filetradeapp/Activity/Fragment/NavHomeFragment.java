package com.example.filetradeapp.Activity.Fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.filetradeapp.Activity.Adapter.FileCardRecyclerAdapter;
import com.example.filetradeapp.Config;
import com.example.filetradeapp.Contract;
import com.example.filetradeapp.Presenter.SearchPresenterImpl;
import com.example.filetradeapp.R;
import com.example.filetradeapp.Util.Bean.FileBean;

import java.util.ArrayList;
import java.util.List;

public class NavHomeFragment extends Fragment implements Contract.ISearchView{

    private View view;
    private static SearchPresenterImpl presenter = new SearchPresenterImpl();

    private List<FileBean> cardList = new ArrayList<>();
    private FileCardRecyclerAdapter recyclerAdapter = new FileCardRecyclerAdapter(cardList);
    private RecyclerView recyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        view = inflater.inflate(R.layout.fragment_home, container,false);

        presenter.attachView(this);
        presenter.doRecommend();

        SearchView searchView =(SearchView)view.findViewById(R.id.search);
        SearchView.SearchAutoComplete text = (SearchView.SearchAutoComplete) searchView.findViewById(R.id.search_src_text);
        searchView.setQueryHint("搜索文件");
        searchView.setIconified(false);
        searchView.setFocusable(true);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                presenter.doSearch(query);
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });

        recyclerView=(RecyclerView)view.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext(),LinearLayoutManager.VERTICAL,false));
        recyclerView.setAdapter(recyclerAdapter);

        return view;
    }

    @Override
    public void onSearch(List<FileBean> list) {
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

    @Override
    public void onRecommend(List<FileBean> list) {
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

    public static SearchPresenterImpl getPresenter(){
        return presenter;
    }
}

