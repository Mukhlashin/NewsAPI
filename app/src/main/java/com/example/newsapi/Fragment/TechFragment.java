package com.example.newsapi.Fragment;


import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.example.newsapi.MainActivity;
import com.example.newsapi.R;
import com.example.newsapi.adapter.TechAdapter;
import com.example.newsapi.api.ConfigRetrofit;
import com.example.newsapi.modelnews.ArticlesItemNews;
import com.example.newsapi.modeltech.ResponseTech;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class TechFragment extends Fragment {

    RecyclerView rvTech;
    TechAdapter adapter;
    List<ArticlesItemNews> data;
    FrameLayout frameLayout;
    AnimationDrawable animationDrawable;


    public TechFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View layout = inflater.inflate(R.layout.fragment_tech, container, false);
        rvTech = layout.findViewById(R.id.rv_tech);
        rvTech.setAdapter(adapter);
        frameLayout = layout.findViewById(R.id.frg_tech);
        animationDrawable = (AnimationDrawable) frameLayout.getBackground();
        animationDrawable.setEnterFadeDuration(2000);
        animationDrawable.setExitFadeDuration(4000);
        animationDrawable.start();
        getDataTech();
        return layout;
    }

    private void getDataTech() {
        ConfigRetrofit.getInstance3().getDataTech().enqueue(new Callback<ResponseTech>() {
            @Override
            public void onResponse(Call<ResponseTech> call, Response<ResponseTech> response) {
                if (response.isSuccessful()) {
                    data = response.body().getArticles();
                    adapter = new TechAdapter(getActivity(), data);
                    rvTech.setLayoutManager(new LinearLayoutManager(getActivity()));
                    rvTech.setAdapter(adapter);
                }
            }

            @Override
            public void onFailure(Call<ResponseTech> call, Throwable t) {

            }
        });
    }

}
