package com.example.newsapi.Fragment;


import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.example.newsapi.MainActivity;
import com.example.newsapi.R;
import com.example.newsapi.adapter.NewsAdapter;
import com.example.newsapi.api.ConfigRetrofit;
import com.example.newsapi.modelnews.ArticlesItemNews;
import com.example.newsapi.modelnews.ResponseNews;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class NewsFragment extends Fragment {

    RecyclerView rvNews;
    NewsAdapter adapter;
    List<ArticlesItemNews> data;
    FrameLayout frameLayout;
    AnimationDrawable animationDrawable;


    public NewsFragment() {
        // Required empty public constructor
    }




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       View layout = inflater.inflate(R.layout.fragment_news, container, false);
        frameLayout = layout.findViewById(R.id.frg_news);
        animationDrawable = (AnimationDrawable) frameLayout.getBackground();
        animationDrawable.setEnterFadeDuration(2000);
        animationDrawable.setExitFadeDuration(4000);
        animationDrawable.start();
        rvNews = layout.findViewById(R.id.rv_news);
       rvNews.setAdapter(adapter);
       getDataNews();
       return layout;
    }

    private void getDataNews() {
        ConfigRetrofit.getInstance().getDataNews().enqueue(new Callback<ResponseNews>() {
            @Override
            public void onResponse(Call<ResponseNews> call, Response<ResponseNews> response) {
                if (response.isSuccessful()) {
                    data = response.body().getArticles();
                    adapter = new NewsAdapter(getActivity(), data);
                    rvNews.setLayoutManager(new LinearLayoutManager(getActivity()));
                    rvNews.setAdapter(adapter);
                }
            }

            @Override
            public void onFailure(Call<ResponseNews> call, Throwable t) {

            }
        });
    }

}
