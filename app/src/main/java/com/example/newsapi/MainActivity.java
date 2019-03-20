package com.example.newsapi;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;

import com.example.newsapi.Fragment.HackerFragment;
import com.example.newsapi.Fragment.NewsFragment;
import com.example.newsapi.Fragment.TechFragment;
import com.example.newsapi.adapter.HackerAdapter;
import com.example.newsapi.adapter.NewsAdapter;
import com.example.newsapi.adapter.TechAdapter;
import com.example.newsapi.api.ConfigRetrofit;
import com.example.newsapi.modelhacker.ArticlesItemHacker;
import com.example.newsapi.modelhacker.ResponseHacker;
import com.example.newsapi.modelnews.ArticlesItemNews;
import com.example.newsapi.modelnews.ResponseNews;
import com.example.newsapi.modeltech.ArticlesItemTech;
import com.example.newsapi.modeltech.ResponseTech;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    RecyclerView rvNews, rvHacker, rvTech;
    NewsAdapter adapter;
    HackerAdapter adapter2;
    TechAdapter adapter3;
    List<ArticlesItemNews> data;
    List<ArticlesItemHacker> data2;
    List<ArticlesItemTech> data3;
    FragmentManager fm;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
            fm = getSupportFragmentManager();
            switch (menuItem.getItemId()) {
                case R.id.rvNews:
                    fm.beginTransaction().replace(R.id.main_container, new NewsFragment()).commit();
                    return true;
                case R.id.rvHacker:
                    fm.beginTransaction().replace(R.id.main_container, new HackerFragment()).commit();
                    return true;
                case R.id.rvTech:
                    fm.beginTransaction().replace(R.id.main_container, new TechFragment()).commit();
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fm = getSupportFragmentManager();
        fm.beginTransaction().add(R.id.main_container, new NewsFragment()).commit();
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }
}
