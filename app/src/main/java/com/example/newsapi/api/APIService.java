package com.example.newsapi.api;

import com.example.newsapi.modelhacker.ResponseHacker;
import com.example.newsapi.modelnews.ResponseNews;
import com.example.newsapi.modeltech.ResponseTech;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIService {

    @GET("top-headlines?sources=al-jazeera-english&apiKey=330b805b60f043c79235b6991eeb1c55")
    Call<ResponseNews> getDataNews();

    @GET("top-headlines?sources=hacker-news&apiKey=330b805b60f043c79235b6991eeb1c55")
    Call<ResponseHacker> getDataHacker();

    @GET("top-headlines?sources=techradar&apiKey=330b805b60f043c79235b6991eeb1c55")
    Call<ResponseTech> getDataTech();

}
