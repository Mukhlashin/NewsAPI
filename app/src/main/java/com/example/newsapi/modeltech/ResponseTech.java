package com.example.newsapi.modeltech;

import com.example.newsapi.modelnews.ArticlesItemNews;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ResponseTech{

	@SerializedName("totalResults")
	private int totalResults;

	@SerializedName("articles")
	private List<ArticlesItemNews> articles;

	@SerializedName("status")
	private String status;

	public void setTotalResults(int totalResults){
		this.totalResults = totalResults;
	}

	public int getTotalResults(){
		return totalResults;
	}

	public void setArticles(List<ArticlesItemNews> articles){
		this.articles = articles;
	}

	public List<ArticlesItemNews> getArticles(){
		return articles;
	}

	public void setStatus(String status){
		this.status = status;
	}

	public String getStatus(){
		return status;
	}

	@Override
 	public String toString(){
		return 
			"ResponseTech{" + 
			"totalResults = '" + totalResults + '\'' + 
			",articles = '" + articles + '\'' + 
			",status = '" + status + '\'' + 
			"}";
		}
}