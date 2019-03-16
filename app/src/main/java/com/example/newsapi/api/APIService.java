package com.example.newsapi.api;

import com.example.newsapi.model.ResponseNews;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIService {

    @GET("top-headlines?sources=al-jazeera-english&apiKey=330b805b60f043c79235b6991eeb1c55")
    Call<ResponseNews> getDataNews();

}
