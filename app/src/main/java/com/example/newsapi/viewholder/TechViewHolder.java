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

public class TechViewHolder extends RecyclerView.ViewHolder {

    public TextView tvTitleTech;
    public TextView tvAuthorTech;
    public TextView tvDateTech;
    public ImageView imgTech;
    public LinearLayout lnNews;

    public TechViewHolder(@NonNull View itemView, Context context) {
        super(itemView);

        tvTitleTech = itemView.findViewById(R.id.tv_title_tech);
        tvAuthorTech = itemView.findViewById(R.id.tv_author_tech);
        tvDateTech = itemView.findViewById(R.id.tv_date_tech);
        imgTech = itemView.findViewById(R.id.img_tech);
    }
}
