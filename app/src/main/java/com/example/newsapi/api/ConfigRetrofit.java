package com.example.newsapi.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ConfigRetrofit {

    public static String url = "https://newsapi.org/v2/";

    public static Retrofit setInit() {
        return new Retrofit.Builder().baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static Retrofit setInit2() {
        return new Retrofit.Builder().baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static Retrofit setInit3() {
        return new Retrofit.Builder().baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static APIService getInstance() {
        return setInit().create(APIService.class);

    }

    public static APIService getInstance2() {
        return setInit2().create(APIService.class);
    }

    public static APIService getInstance3() {
        return setInit3().create(APIService.class);
    }
}
