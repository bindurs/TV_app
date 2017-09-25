package com.ltrix.jk.tv_app.activity;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.ltrix.jk.tv_app.R;
import com.ltrix.jk.tv_app.adapter.EpisodeDetailsAdapter;
import com.ltrix.jk.tv_app.adapter.SeasonNumberAdapter;
import com.ltrix.jk.tv_app.model.Episode;
import com.ltrix.jk.tv_app.model.Season;
import com.ltrix.jk.tv_app.model.Show;
import com.ltrix.jk.tv_app.webservice.RestServiceBuilder;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SeasonDetailsActivity extends AppCompatActivity {

    private RecyclerView episodeListView;
    private RecyclerView seasonListView;

    private EpisodeDetailsAdapter eAdapter;
    private SeasonNumberAdapter sAdapter;

    private List<Episode> episodeList = new ArrayList<>();
    private List<Season> seasonList = new ArrayList<>();
    private List<Episode> filteredEpisodeList = new ArrayList<>();

    private TextView action_bar_title;
    private TextView action_bar_main_title;
    private Season season;
    private Show show;
    private TextView seasonNumber;

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

        initFields();

        season = (Season) getIntent().getSerializableExtra("season");
        show = (Show) getIntent().getSerializableExtra("show");
        seasonList = (List<Season>)getIntent().getSerializableExtra("seasonList");

        if (season != null && seasonList!=null) {

            prepareEpisode();
            setupFields();
        }

    }
    void initFields() {

        seasonNumber = (TextView)findViewById(R.id.season_number);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        episodeListView = (RecyclerView) findViewById(R.id.episodeList);
        episodeListView.setLayoutManager(layoutManager);
        episodeListView.setItemAnimator(new DefaultItemAnimator());

        LinearLayoutManager layoutManager1 = new LinearLayoutManager(this);
        layoutManager1.setOrientation(LinearLayoutManager.HORIZONTAL);

        seasonListView = (RecyclerView) findViewById(R.id.seasonList);
        seasonListView.setLayoutManager(layoutManager1);
        seasonListView.setItemAnimator(new DefaultItemAnimator());

    }
    void prepareEpisode() {

        Log.v("************************id", String.valueOf(season.getNumber()));
        RestServiceBuilder.getApiService().getEpisodes(show.getId()).enqueue(new Callback<List<Episode>>() {
            @Override
            public void onResponse(Call<List<Episode>> call, Response<List<Episode>> response) {

                episodeList = response.body();


                for (Episode episode : episodeList) {

                    Log.e("aired season",""+episode.getSeason());
                    Log.e("season number",""+season.getNumber());

                    if (episode.getSeason().equals(season.getNumber())) {
                        filteredEpisodeList.add(episode);

                        Log.e("filtered data",""+filteredEpisodeList);

                    }
                }

                if (filteredEpisodeList.size() !=0 ) {
                    eAdapter = new EpisodeDetailsAdapter(filteredEpisodeList, SeasonDetailsActivity.this);
                    episodeListView.setAdapter(eAdapter);
                }
            }

            @Override
            public void onFailure(Call<List<Episode>> call, Throwable t) {
                Log.e("ERROR",""+t.getMessage());

            }
        });

    }
    void setupFields () {

        seasonNumber.setText("Season : "+season.getNumber());
        sAdapter = new SeasonNumberAdapter(seasonList,show,false,SeasonDetailsActivity.this);
        seasonListView.setAdapter(sAdapter);
    }


}
