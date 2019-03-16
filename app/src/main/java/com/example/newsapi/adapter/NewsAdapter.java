package com.example.newsapi.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.newsapi.DetailActivity;
import com.example.newsapi.MainActivity;
import com.example.newsapi.R;
import com.example.newsapi.model.ArticlesItem;
import com.example.newsapi.viewholder.NewsViewHolder;
import com.squareup.picasso.Picasso;

import java.util.List;

public class NewsAdapter extends RecyclerView.Adapter<NewsViewHolder> {

    Context context;
    List<ArticlesItem> data;

    public NewsAdapter(Context context, List<ArticlesItem> data) {
        this.context = context;
        this.data = data;
    }

    @NonNull
    @Override
    public NewsViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(context).inflate(R.layout.news_viewholder, null);
        return new NewsViewHolder(v, context);
    }

    @Override
    public void onBindViewHolder(@NonNull NewsViewHolder newsViewHolder, final int i) {
        newsViewHolder.tvTitle.setText(data.get(i).getTitle());
        newsViewHolder.tvAuthor.setText(data.get(i).getAuthor());
        newsViewHolder.tvDate.setText(data.get(i).getPublishedAt());
        Picasso.get().load(data.get(i).getUrlToImage()).into(newsViewHolder.imgNews);
        newsViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
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
