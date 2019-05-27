package com.example.filetradeapp.Activity.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.filetradeapp.Activity.DetailActivity;
import com.example.filetradeapp.R;
import com.example.filetradeapp.Util.Bean.FileBean;

import java.util.List;
import java.util.Random;


public class FileCardRecyclerAdapter extends RecyclerView.Adapter<FileCardRecyclerAdapter.ViewHolder> {
    private Context context;
    private List<FileBean> cardList;

    static class ViewHolder extends RecyclerView.ViewHolder{

        CardView cardView;
        TextView card_name;
        ImageView imageView;

        public ViewHolder(View view) {
            super(view);
            cardView = (CardView)view;
            card_name = (TextView) view.findViewById(R.id.card_file_name);
            imageView =(ImageView)view.findViewById(R.id.card_file_img);
        }
    }

    public FileCardRecyclerAdapter(List<FileBean> list) {
        this.cardList = list;
    }

    @NonNull
    @Override
    public FileCardRecyclerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (context == null){
            context = parent.getContext();
        }
        View view= LayoutInflater.from(context).inflate(R.layout.card_file,parent,false);
        return new FileCardRecyclerAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final FileBean card = cardList.get(position);
        holder.card_name.setText(card.getTitle());

        if(card.getType().equals("doc"))holder.imageView.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.doc));
        else if(card.getType().equals("ppt"))holder.imageView.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.ppt));
        else if(card.getType().equals("pdf"))holder.imageView.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.pdf));
        else holder.imageView.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.txt));

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                Intent intent = new Intent(context, DetailActivity.class);
                intent.putExtra("fileBean", card);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return cardList.size();
    }

    public void resetCardList(List<FileBean> list){
        this.cardList = list;
        notifyDataSetChanged();
    }
}


