package com.example.newsapi.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.newsapi.DetailActivity;
import com.example.newsapi.R;
import com.example.newsapi.modelnews.ArticlesItemNews;
import com.example.newsapi.viewholder.HackerViewHolder;
import com.squareup.picasso.Picasso;

import java.util.List;

public class HackerAdapter extends RecyclerView.Adapter<HackerViewHolder> {

    Context context;
    private List<ArticlesItemNews> data;

    public HackerAdapter(Context context, List<ArticlesItemNews> data2) {
        this.context = context;
        this.data = data2;
    }

    @NonNull
    @Override
    public HackerViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(context).inflate(R.layout.hacker_viewholder, null);
        return new HackerViewHolder(v, context);
    }

    @Override
    public void onBindViewHolder(@NonNull HackerViewHolder hackerViewHolder, final int i) {
        hackerViewHolder.tvTitleHacker.setText(data.get(i).getTitle());
        hackerViewHolder.tvAuthorHacker.setText(data.get(i).getAuthor());
        hackerViewHolder.tvDateHacker.setText(data.get(i).getPublishedAt());
        Picasso.get().load(data.get(i).getUrlToImage()).into(hackerViewHolder.imgHacker);
        hackerViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent move = new Intent(context, DetailActivity.class);
                move.putExtra("a", data.get(i).getContent());
                move.putExtra("b", data.get(i).getUrlToImage());
                context.startActivity(move);
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}
