package com.ltrix.jk.tv_app.activity;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.ltrix.jk.tv_app.Actors;
import com.ltrix.jk.tv_app.Episode;
import com.ltrix.jk.tv_app.R;
import com.ltrix.jk.tv_app.Season;
import com.ltrix.jk.tv_app.ShowsInfo;
import com.ltrix.jk.tv_app.adapter.ActorAdapter;
import com.ltrix.jk.tv_app.adapter.SeasonNumberAdapter;

import java.util.ArrayList;
import java.util.List;

public class ShowDetailsActivity extends AppCompatActivity {

    private List<Season> seasonList = new ArrayList<>();
    private List<Episode> episodeList = new ArrayList<>();
    private List<Actors> actorsList = new ArrayList<>();
    private TextView action_bar_title;
    private TextView action_bar_main_title;
    private SeasonNumberAdapter sAdapter;
    private ActorAdapter actorAdaptor;
    private RecyclerView recyclerView;
    private RecyclerView actorsListView;
    private ShowsInfo showInfo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.show_details);

        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.action_bar);

        action_bar_main_title = (TextView)findViewById(R.id.action_bar_main_title);
        action_bar_title = (TextView)findViewById(R.id.action_bar_title);

        action_bar_title.setVisibility(View.VISIBLE);
        action_bar_main_title.setVisibility(View.GONE);


//        ImageView image = (ImageView)findViewById(R.id.backView);
//        BlurringView blurringView = (BlurringView)findViewById(R.id.blurringView);
//        blurringView.setBlurRadius(11);
//        blurringView.setAlpha((float) 0.7);
//
//        Picasso.with(getApplicationContext()).load("https://i.pinimg.com/736x/ec/bc/0e/ecbc0e5cd54c3a7f444c8568231ab9b6--joseph-gordon-levitt-bruce-willis.jpg").fit().centerCrop().into(image, new Callback() {
//            @Override
//            public void onSuccess() {
//                Log.v("success","success");
//            }
//
//            @Override
//            public void onError() {
//                Log.v("failed","failed");
//            }
//        });-
//
//        blurringView.setBlurredView(image);

        LinearLayoutManager layoutManager1 = new LinearLayoutManager(this);
        layoutManager1.setOrientation(LinearLayoutManager.HORIZONTAL);

        recyclerView = (RecyclerView) findViewById(R.id.seasonList);
        sAdapter = new SeasonNumberAdapter(seasonList, ShowDetailsActivity.this);
        recyclerView.setLayoutManager(layoutManager1);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(sAdapter);

        LinearLayoutManager layoutManager2 = new LinearLayoutManager(this);
        layoutManager2.setOrientation(LinearLayoutManager.VERTICAL);

        actorsListView = (RecyclerView) findViewById(R.id.actorsList);
        actorAdaptor = new ActorAdapter(actorsList,ShowDetailsActivity.this);
        actorsListView.setLayoutManager(layoutManager2);
        actorsListView.setItemAnimator(new DefaultItemAnimator());
        actorsListView.setAdapter(actorAdaptor);

        prepareSeason();

    }

    private void prepareSeason () {

        Season season = new Season(1,1,1,"","fdds","","","","", "");
        season.setSeasonID(1);

        seasonList.add(season);

        season = new Season(2,2,2,"","","","", "","","");
        seasonList.add(season);

        season = new Season(3,3,3,"","","","","","","");
        seasonList.add(season);

        sAdapter.notifyDataSetChanged();

        Actors actor = new Actors("fhbv","erge");
        actorsList.add(actor);

        actor = new Actors("uy","ert");
        actorsList.add(actor);

        actor = new Actors("cszd","sdffr");
        actorsList.add(actor);

//        Episode episode = new Episode(1,1,1,1,"","","","","");
//        episodeList.add(episode);
//
//        episode = new Episode(2,2,2,2,"","","","","");
//        episodeList.add(episode);
//
//        episode = new Episode(3,3,3,3,"","","","","");
//        episodeList.add(episode);
//
//        showInfo = new ShowsInfo(seasonList,episodeList);

    }
}
