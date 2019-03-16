package com.example.newsapi.viewholder;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.newsapi.R;

public class NewsViewHolder extends RecyclerView.ViewHolder {

    public TextView tvTitle;
    public TextView tvAuthor;
    public TextView tvDate;
    public ImageView imgNews;
    public LinearLayout lnNews;

    public NewsViewHolder(@NonNull View itemView, Context context) {
        super(itemView);

        tvTitle = itemView.findViewById(R.id.tv_title);
        tvAuthor = itemView.findViewById(R.id.tv_author);
        tvDate = itemView.findViewById(R.id.tv_date);
        imgNews = itemView.findViewById(R.id.img_news);

    }
}
