package com.ltrix.jk.tv_app.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ltrix.jk.tv_app.R;
import com.ltrix.jk.tv_app.activity.SeasonDetailsActivity;
import com.ltrix.jk.tv_app.model.Season;
import com.ltrix.jk.tv_app.model.Show;

import java.io.Serializable;
import java.util.List;

/**
 * Created by bindu on 18/09/17.
 */

public class SeasonNumberAdapter extends RecyclerView.Adapter<SeasonNumberAdapter.SeasonViewHolder> {

    private Context context;
    private List<Season> seasonList;
    private boolean fromShowDetails;
    private Show show;

    public class SeasonViewHolder extends RecyclerView.ViewHolder {

        public TextView seasonNumber;


        public SeasonViewHolder(View view) {
            super(view);
            seasonNumber = (TextView) view.findViewById(R.id.season_num);
        }

    }
    public SeasonNumberAdapter(List<Season> seasonList, Show show, Boolean fromShowDetails, Context context) {
        this.context = context;
        this.seasonList = seasonList;
        this.fromShowDetails = fromShowDetails;
        this.show = show;
    }

    @Override
    public SeasonNumberAdapter.SeasonViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.sesaon_num_row, parent, false);
        return new SeasonViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(SeasonNumberAdapter.SeasonViewHolder holder, int position) {

        final Season season = seasonList.get(position);
        holder.seasonNumber.setText(""+season.getNumber());

        Log.v("#############################",""+season.getId());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (fromShowDetails) {

                    Intent i = new Intent(context, SeasonDetailsActivity.class);
                    i.putExtra("season", season);
                    i.putExtra("show", show);
                    i.putExtra("seasonList", (Serializable) seasonList);
                    context.startActivity(i);

                } else {


                }
            }
        });
    }


    @Override
    public int getItemCount() {
        return seasonList.size();
    }
}
