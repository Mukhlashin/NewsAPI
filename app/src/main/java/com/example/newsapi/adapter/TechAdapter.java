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
import com.example.newsapi.viewholder.TechViewHolder;
import com.squareup.picasso.Picasso;

import java.util.List;

public class TechAdapter extends RecyclerView.Adapter<TechViewHolder> {
    Context context;
    private List<ArticlesItemNews> data;

    public TechAdapter(Context context, List<ArticlesItemNews> data3) {
        this.context = context;
        this.data = data3;
    }

    @NonNull
    @Override
    public TechViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(context).inflate(R.layout.tech_viewholder, null);
        return new TechViewHolder(v, context);
    }

    @Override
    public void onBindViewHolder(@NonNull TechViewHolder techViewHolder, final int i) {
        techViewHolder.tvTitleTech.setText(data.get(i).getTitle());
        techViewHolder.tvAuthorTech.setText(data.get(i).getAuthor());
        techViewHolder.tvDateTech.setText(data.get(i).getPublishedAt());
        Picasso.get().load(data.get(i).getUrlToImage()).into(techViewHolder.imgTech);
        techViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
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
