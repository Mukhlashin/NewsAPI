package com.example.newsapi.Fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.newsapi.MainActivity;
import com.example.newsapi.R;
import com.example.newsapi.adapter.HackerAdapter;
import com.example.newsapi.api.ConfigRetrofit;
import com.example.newsapi.modelhacker.ResponseHacker;
import com.example.newsapi.modelnews.ArticlesItemNews;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class HackerFragment extends Fragment {

    RecyclerView rvHacker;
    HackerAdapter adapter;
    List<ArticlesItemNews> data;


    public HackerFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View layout = inflater.inflate(R.layout.fragment_hacker, container, false);
        rvHacker = layout.findViewById(R.id.rv_hacker);
        rvHacker.setAdapter(adapter);
        getDataHacker();
        return layout;
    }

    private void getDataHacker() {
        ConfigRetrofit.getInstance2().getDataHacker().enqueue(new Callback<ResponseHacker>() {
            @Override
            public void onResponse(Call<ResponseHacker> call, Response<ResponseHacker> response) {
                if (response.isSuccessful()) {
                    data = response.body().getArticles();
                    adapter = new HackerAdapter(getActivity(), data);
                    rvHacker.setLayoutManager(new LinearLayoutManager(getActivity()));
                    rvHacker.setAdapter(adapter);
                }
            }

            @Override
            public void onFailure(Call<ResponseHacker> call, Throwable t) {

            }
        });
    }

}
