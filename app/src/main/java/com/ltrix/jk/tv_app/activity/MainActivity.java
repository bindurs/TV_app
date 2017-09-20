package com.ltrix.jk.tv_app.activity;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.TextView;

import com.ltrix.jk.tv_app.R;
import com.ltrix.jk.tv_app.Shows;
import com.ltrix.jk.tv_app.adapter.ShowsAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Shows> movieList = new ArrayList<>();
    private RecyclerView recyclerView;
    private ShowsAdapter mAdapter;
    private TextView action_bar_title;
    private TextView action_bar_main_title;

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

        mAdapter = new ShowsAdapter(movieList,MainActivity.this);
        // RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        //recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);

        prepareMovieData();
    }

    private void prepareMovieData() {
        Shows movie = new Shows(0,"Mad Max: Fury Road", "Action & Adventure", "2015",0.0,"","","","","","","https://i.imgur.com/tGbaZCY.jpg");
        movieList.add(movie);

        movie = new Shows(0,"Mad Max: Fury Road", "Action & Adventure", "2015",0.0,"","","","","","","https://assets.mubi.com/images/notebook/post_images/22621/images-w1400.jpg?1481167057");
        movieList.add(movie);

        movie = new Shows(0,"Mad Max: Fury Road", "Action & Adventure", "2015",0.0,"","","","","","","https://i.pinimg.com/736x/c1/ab/78/c1ab782b93344350aa968604dbfdc9d8--fun-recipes-jodie-foster.jpg");
        movieList.add(movie);

        movie = new Shows(0,"Mad Max: Fury Road", "Action & Adventure", "2015",0.0,"","","","","","","https://i.pinimg.com/736x/ec/bc/0e/ecbc0e5cd54c3a7f444c8568231ab9b6--joseph-gordon-levitt-bruce-willis.jpg");
        movieList.add(movie);

        movie = new Shows(0,"Mad Max: Fury Road", "Action & Adventure", "2015",0.0,"","","","","","","http://static.boredpanda.com/blog/wp-content/uploads/2016/11/honest-movie-posters-067-583d73614a3b8__605.jpg");
        movieList.add(movie);

        movie = new Shows(0,"Mad Max: Fury Road", "Action & Adventure", "2015",0.0,"","","","","","","http://static.boredpanda.com/blog/wp-content/uploads/2016/11/honest-movie-posters-031-583d72f44cb26__605.jpg");
        movieList.add(movie);

        mAdapter.notifyDataSetChanged();
    }
}

