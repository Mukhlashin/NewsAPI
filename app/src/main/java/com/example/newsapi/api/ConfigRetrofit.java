package com.example.newsapi.api;

import com.example.newsapi.model.ResponseNews;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

public class ConfigRetrofit {

    public static String url = "https://newsapi.org/v2/";

    public static Retrofit setInit() {
        return new Retrofit.Builder().baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static APIService getInstance() {
        return setInit().create(APIService.class);

    }
}
