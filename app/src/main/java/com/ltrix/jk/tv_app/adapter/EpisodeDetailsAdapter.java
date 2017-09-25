package com.ltrix.jk.tv_app.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.text.Spanned;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.ltrix.jk.tv_app.R;
import com.ltrix.jk.tv_app.model.Episode;
import com.squareup.picasso.Picasso;

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
            episodeImage = (ImageView)view.findViewById(R.id.episode_image);
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

        episodeNumber.setText(episode.getNumber()+" - "+episode.getName());
        episodeDate.setText("Aired Date : "+episode.getAirdate());
        episodeSummary.setText(stripHtml(episode.getSummary()));
        if (episode.getImage()!=null) {

            Picasso.with(context).load(episode.getImage().getMedium()).placeholder(R.drawable.demo).fit().centerCrop().into(episodeImage);
        }
    }

    @Override
    public int getItemCount() {

        Log.v("count *************** count",""+episodeList.size());
        return episodeList.size();
    }

    public Spanned stripHtml(String html) {
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
            return Html.fromHtml(html, Html.FROM_HTML_MODE_LEGACY);
        } else {
            return Html.fromHtml(html);
        }
    }
}
