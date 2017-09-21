package com.ltrix.jk.tv_app.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ltrix.jk.tv_app.R;
import com.ltrix.jk.tv_app.activity.SeasonDetailsActivity;
import com.ltrix.jk.tv_app.model.Season;

import java.util.List;

/**
 * Created by bindu on 18/09/17.
 */

public class SeasonNumberAdapter extends RecyclerView.Adapter<SeasonNumberAdapter.SeasonViewHolder> {

    private Context context;
    private List<Season> seasonList;

    public class SeasonViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public TextView seasonNumber;


        public SeasonViewHolder(View view) {
            super(view);
            seasonNumber = (TextView) view.findViewById(R.id.season_num);
            view.setOnClickListener(this);
        }


        @Override
        public void onClick(View view) {

            Intent i = new Intent(context,SeasonDetailsActivity.class);
            context.startActivity(i);
        }
    }
    public SeasonNumberAdapter(List<Season> seasonList, Context context) {
        this.context = context;
        this.seasonList = seasonList;
    }

    @Override
    public SeasonNumberAdapter.SeasonViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.sesaon_num_row, parent, false);
        return new SeasonViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(SeasonNumberAdapter.SeasonViewHolder holder, int position) {

        Season season = seasonList.get(position);
        holder.seasonNumber.setText(""+season.getNumber());
    }

    @Override
    public int getItemCount() {
        return seasonList.size();
    }
}
