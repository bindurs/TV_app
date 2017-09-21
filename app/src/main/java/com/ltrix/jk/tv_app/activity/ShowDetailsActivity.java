package com.ltrix.jk.tv_app.activity;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.text.Spanned;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.ltrix.jk.tv_app.R;
import com.ltrix.jk.tv_app.ShowsInfo;
import com.ltrix.jk.tv_app.adapter.ActorAdapter;
import com.ltrix.jk.tv_app.adapter.SeasonNumberAdapter;
import com.ltrix.jk.tv_app.model.Actor;
import com.ltrix.jk.tv_app.model.Season;
import com.ltrix.jk.tv_app.model.Show;
import com.ltrix.jk.tv_app.webservice.RestServiceBuilder;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ShowDetailsActivity extends AppCompatActivity {

    private List<Season> seasonList = new ArrayList<>();
    private List<Actor> actorsList = new ArrayList<>();

    private TextView action_bar_title;
    private TextView action_bar_main_title;
    private SeasonNumberAdapter sAdapter;
    private ActorAdapter actorAdaptor;
    private RecyclerView recyclerView;
    private RecyclerView actorsListView;
    private ShowsInfo showInfo;
    private ImageView showImage;
    private Show show;
    private TextView textShowDesc,textShowStatus,textShowPremieredDate,textShowRunTime,textShowOfficialSite,textShowUrl,textShowRating;
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
        initFields();

        show = (Show) getIntent().getSerializableExtra("show");
        if (show != null) {
            prepareSeason(show.getId());
            prepareActors(show.getId());
            setFields();
        }
    }

    private void initFields() {

        showImage = (ImageView)findViewById(R.id.show_image);
        textShowDesc = (TextView)findViewById(R.id.show_desc);
        textShowPremieredDate = (TextView)findViewById(R.id.txt_premiered_date);
        textShowOfficialSite = (TextView)findViewById(R.id.txt_officialsite);
        textShowRunTime = (TextView)findViewById(R.id.txt_runtime);
        textShowStatus = (TextView)findViewById(R.id.txt_vw_status);
        textShowUrl =  (TextView)findViewById(R.id.txt_url);
        textShowRating = (TextView)findViewById(R.id.txt_rating);

        LinearLayoutManager layoutManager1 = new LinearLayoutManager(this);
        layoutManager1.setOrientation(LinearLayoutManager.HORIZONTAL);

        recyclerView = (RecyclerView) findViewById(R.id.seasonList);
        recyclerView.setLayoutManager(layoutManager1);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        LinearLayoutManager layoutManager2 = new LinearLayoutManager(this);
        layoutManager2.setOrientation(LinearLayoutManager.VERTICAL);

        actorsListView = (RecyclerView) findViewById(R.id.actorsList);
        actorsListView.setLayoutManager(layoutManager2);
        actorsListView.setItemAnimator(new DefaultItemAnimator());
    }

    private void setFields () {

        Picasso.with(this).load(show.getImage().getMedium()).placeholder(R.drawable.demo).fit().centerCrop().into(showImage);
        textShowDesc.setText(stripHtml(show.getSummary()));
        textShowPremieredDate.setText(": "+show.getPremiered());
        textShowOfficialSite.setText(": "+show.getOfficialSite());
        textShowRunTime.setText(": "+show.getRuntime()+"");
        textShowStatus.setText(": "+show.getStatus());
        textShowUrl.setText(": "+show.getUrl());
        textShowRating.setText(": "+show.getRating());

    }

    public Spanned stripHtml(String html) {
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
            return Html.fromHtml(html, Html.FROM_HTML_MODE_LEGACY);
        } else {
            return Html.fromHtml(html);
        }
    }

    private void prepareSeason (Integer showID) {

        RestServiceBuilder.getApiService().getSeasons(showID).enqueue(new Callback<List<Season>>() {
            @Override
            public void onResponse(Call<List<Season>> call, Response<List<Season>> response) {


                seasonList = response.body();
                Log.e("response",""+seasonList);
                sAdapter = new SeasonNumberAdapter(seasonList, ShowDetailsActivity.this);
                recyclerView.setAdapter(sAdapter);

            }

            @Override
            public void onFailure(Call<List<Season>> call, Throwable t) {
                Log.e("ERROR",""+t.getMessage());

            }
        });

    }

    private void prepareActors (Integer showID) {

        RestServiceBuilder.getApiService().getActors(showID).enqueue(new Callback<List<Actor>>() {
            @Override
            public void onResponse(Call<List<Actor>> call, Response<List<Actor>> response) {

                actorsList = response.body();
                actorAdaptor = new ActorAdapter(actorsList,ShowDetailsActivity.this);
                actorsListView.setAdapter(actorAdaptor);

            }

            @Override
            public void onFailure(Call<List<Actor>> call, Throwable t) {
                Log.e("ERROR",""+t.getMessage());
            }
        });
    }
}
