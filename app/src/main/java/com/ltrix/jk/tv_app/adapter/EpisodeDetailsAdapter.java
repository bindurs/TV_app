package com.ltrix.jk.tv_app.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.ltrix.jk.tv_app.Episode;
import com.ltrix.jk.tv_app.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bindu on 20/09/17.
 */

public class EpisodeDetailsAdapter extends RecyclerView.Adapter<EpisodeDetailsAdapter.EpisodeViewHolder> {

    private Context context;
    private List<Episode> episodeList = new ArrayList<>();
    private TextView episodeNumber,episodeDate,episodeSummary;
    private ImageView episodeImage;

    public class EpisodeViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        public EpisodeViewHolder(View view) {
            super(view);

            episodeNumber = (TextView) view.findViewById(R.id.episodeNumber);
            episodeDate = (TextView) view.findViewById(R.id.episodeDate);
            episodeSummary = (TextView) view.findViewById(R.id.episodeSummary);
        }
        @Override
        public void onClick(View view) {

        }
    }

    public EpisodeDetailsAdapter(List<Episode> episodeList, Context context1) {

        this.context = context1;
        this.episodeList = episodeList;
    }

    @Override
    public EpisodeDetailsAdapter.EpisodeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.episode_details, parent, false);
        return new EpisodeViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(EpisodeDetailsAdapter.EpisodeViewHolder holder, int position) {

        Episode episode = episodeList.get(position);

        episodeNumber.setText("Episode "+ episode.getEpisodeNumber());
//        episodeDate.setText("Aired Date :"+episode.getAiredSeason());
//        episodeSummary.setText(episode.getSummary());
    }

    @Override
    public int getItemCount() {
        return episodeList.size();
    }
}
