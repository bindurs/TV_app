package com.ltrix.jk.tv_app.activity;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.ltrix.jk.tv_app.R;
import com.ltrix.jk.tv_app.adapter.ShowsAdapter;
import com.ltrix.jk.tv_app.model.Show;
import com.ltrix.jk.tv_app.webservice.RestServiceBuilder;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private List<Show> movieList = new ArrayList<>();
    private RecyclerView recyclerView;
    private ShowsAdapter mAdapter;
    private TextView action_bar_title;
    private TextView action_bar_main_title;
    private int pageNumber = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.action_bar);

        action_bar_main_title = (TextView)findViewById(R.id.action_bar_main_title);
        action_bar_title = (TextView)findViewById(R.id.action_bar_title);

        action_bar_title.setVisibility(View.GONE);
        action_bar_main_title.setVisibility(View.VISIBLE);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL));
        recyclerView.setItemAnimator(new DefaultItemAnimator());


        prepareMovieData();
    }

    private void prepareMovieData() {

        RestServiceBuilder.getApiService().getShows(pageNumber).enqueue(new Callback<List<Show>>() {
            @Override
            public void onResponse(Call<List<Show>> call, Response<List<Show>> response) {
                movieList=response.body();
                mAdapter = new ShowsAdapter(movieList,MainActivity.this);
                recyclerView.setAdapter(mAdapter);
                Log.e("response",""+movieList.size());
//                mAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<List<Show>> call, Throwable t) {
                Log.e("ERROR",""+t.getMessage());
            }
        });

    }
}

