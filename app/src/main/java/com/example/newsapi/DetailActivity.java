package com.example.newsapi;

import android.graphics.drawable.AnimationDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class DetailActivity extends AppCompatActivity {

    TextView tvDetail;
    ImageView imgDetail;
    LinearLayout linearLayout;
    AnimationDrawable animationDrawable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        linearLayout = findViewById(R.id.layout_detail);
        animationDrawable = (AnimationDrawable) linearLayout.getBackground();
        animationDrawable.setEnterFadeDuration(2000);
        animationDrawable.setExitFadeDuration(4000);
        animationDrawable.start();

        tvDetail = findViewById(R.id.tv_detail);
        imgDetail = findViewById(R.id.img_detail);

        tvDetail.setText(getIntent().getStringExtra("a"));
        Picasso.get().load(getIntent().getStringExtra("b")).into(imgDetail);
    }
}
