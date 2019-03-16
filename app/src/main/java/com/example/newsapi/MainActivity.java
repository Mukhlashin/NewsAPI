package com.example.newsapi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.newsapi.adapter.NewsAdapter;
import com.example.newsapi.api.ConfigRetrofit;
import com.example.newsapi.model.ArticlesItem;
import com.example.newsapi.model.ResponseNews;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    RecyclerView rvNews;
    NewsAdapter adapter;
    List<ArticlesItem> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.news_adapter);
        rvNews = findViewById(R.id.rv_news);

        getDataNews();
    }

    private void getDataNews() {
        ConfigRetrofit.getInstance().getDataNews().enqueue(new Callback<ResponseNews>() {
            @Override
            public void onResponse(Call<ResponseNews> call, Response<ResponseNews> response) {
                if (response.isSuccessful()) {
                    data = response.body().getArticles();
                    adapter = new NewsAdapter(MainActivity.this,data);
                    rvNews.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                    rvNews.setAdapter(adapter);
                }
            }

            @Override
            public void onFailure(Call<ResponseNews> call, Throwable t) {

            }
        });
    }
}
