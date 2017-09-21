package com.ltrix.jk.tv_app.activity;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.ltrix.jk.tv_app.Episode;
import com.ltrix.jk.tv_app.R;
import com.ltrix.jk.tv_app.adapter.EpisodeDetailsAdapter;

import java.util.ArrayList;
import java.util.List;

public class SeasonDetailsActivity extends AppCompatActivity {

    private RecyclerView episodeListView;
    private EpisodeDetailsAdapter eAdapter;
    private List<Episode> episodeList = new ArrayList<>();
    private TextView action_bar_title;
    private TextView action_bar_main_title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.season_details);

        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.action_bar);

        action_bar_main_title = (TextView)findViewById(R.id.action_bar_main_title);
        action_bar_title = (TextView)findViewById(R.id.action_bar_title);

        action_bar_title.setVisibility(View.VISIBLE);
        action_bar_main_title.setVisibility(View.GONE);

        LinearLayoutManager layoutManager1 = new LinearLayoutManager(this);
        layoutManager1.setOrientation(LinearLayoutManager.VERTICAL);

        episodeListView = (RecyclerView) findViewById(R.id.episodeList);
        eAdapter = new EpisodeDetailsAdapter(episodeList, SeasonDetailsActivity.this);
        episodeListView.setLayoutManager(layoutManager1);
        episodeListView.setItemAnimator(new DefaultItemAnimator());
        episodeListView.setAdapter(eAdapter);

        prepareEpisode();
    }

    void prepareEpisode() {

        Episode episode = new Episode(1,1,1,1,"vdcfvds","dsfds","","fdsfs","sdfdsf");
        episodeList.add(episode);

        episode = new Episode(2,2,2,2,"fesdesz","rftwed","","fdssfsd","fddsf");
        episodeList.add(episode);

        episode = new Episode(3,3,3,3,"fsddsf","sdfdsf","","sdfsdfd","fedefd");
        episodeList.add(episode);

        eAdapter.notifyDataSetChanged();
    }
}
