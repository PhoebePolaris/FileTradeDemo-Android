package com.example.filetradeapp.Activity.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.filetradeapp.Activity.Entity.FileCard;
import com.example.filetradeapp.Activity.SomeActivity;
import com.example.filetradeapp.R;

import java.util.List;


public class FileCardRecyclerAdapter extends RecyclerView.Adapter<FileCardRecyclerAdapter.ViewHolder> {
    private Context context;
    private List<FileCard> cardList;

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

    public FileCardRecyclerAdapter(List<FileCard> list) {
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
        final FileCard card = cardList.get(position);
        holder.card_name.setText(card.getFname());

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                Intent intent = new Intent(context, SomeActivity.class);
                intent.putExtra("id", card.getFid());
                context.startActivity(intent);
            }
        });
    }


    @Override
    public int getItemCount() {
        return cardList.size();
    }

    public void resetCardList(List<FileCard> list){
        this.cardList = list;
        notifyDataSetChanged();
    }
}


