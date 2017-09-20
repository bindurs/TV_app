package com.ltrix.jk.tv_app.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ltrix.jk.tv_app.Actors;
import com.ltrix.jk.tv_app.R;

import java.util.List;

/**
 * Created by bindu on 19/09/17.
 */

public class ActorAdapter extends RecyclerView.Adapter<ActorAdapter.ActorViewHolder> {

    private Context context;
    private List<Actors> actorList;

    public class ActorViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView seasonNumber;


        public ActorViewHolder(View view) {
            super(view);
//            seasonNumber = (TextView) view.findViewById(R.id.season_num);
//            view.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {

//            Log.d("RecyclerView", "CLICK!");
//            Intent i = new Intent(context,ShowDetailsActivity.class);
//            context.startActivity(i);
        }
    }
    public ActorAdapter(List<Actors> actorList, Context context) {
        this.context = context;
        this.actorList = actorList;
    }

    @Override
    public ActorAdapter.ActorViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.actor_row, parent, false);
        return new ActorViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ActorAdapter.ActorViewHolder holder, int position) {

        Actors season = actorList.get(position);
       // holder.seasonNumber.setText(""+season.getNumber());
    }

    @Override
    public int getItemCount() {
        return actorList.size();
    }
}
