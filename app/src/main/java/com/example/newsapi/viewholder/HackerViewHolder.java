package com.example.newsapi.viewholder;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.newsapi.R;

public class HackerViewHolder extends RecyclerView.ViewHolder {

    public TextView tvTitleHacker;
    public TextView tvAuthorHacker;
    public TextView tvDateHacker;
    public ImageView imgHacker;
    public LinearLayout lnNews;

    public HackerViewHolder(@NonNull View itemView, Context context) {
        super(itemView);

        tvTitleHacker = itemView.findViewById(R.id.tv_title_hacker);
        tvAuthorHacker = itemView.findViewById(R.id.tv_author_hacker);
        tvDateHacker = itemView.findViewById(R.id.tv_date_hacker);
        imgHacker = itemView.findViewById(R.id.img_hacker);
    }
}
