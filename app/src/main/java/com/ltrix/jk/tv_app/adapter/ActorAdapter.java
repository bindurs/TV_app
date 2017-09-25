package com.ltrix.jk.tv_app.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.ltrix.jk.tv_app.R;
import com.ltrix.jk.tv_app.model.Actor;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by bindu on 19/09/17.
 */

public class ActorAdapter extends RecyclerView.Adapter<ActorAdapter.ActorViewHolder> {

    private Context context;
    private List<Actor> actorList;
    public TextView actorName,characterName;
    public ImageView actorImage,characterImage;

    public class ActorViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {


        public ActorViewHolder(View view) {
            super(view);

            actorName = (TextView) view.findViewById(R.id.actor_name);
            characterName = (TextView) view.findViewById(R.id.character_name);

            actorImage = (ImageView)view.findViewById(R.id.actor_image);
            characterImage = (ImageView)view.findViewById(R.id.character_image);

        }

        @Override
        public void onClick(View view) {


        }
    }
    public ActorAdapter(List<Actor> actorList, Context context) {
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

        Actor actor = actorList.get(position);

        actorName.setText(actor.getPerson().getName());
        characterName.setText(actor.getCharacter().getName());

        if (actor.getCharacter().getImage()!=null) {

            Picasso.with(context).load(actor.getPerson().getImage().getMedium()).placeholder(R.drawable.demo).fit().centerCrop().into(actorImage);
            Picasso.with(context).load(actor.getCharacter().getImage().getMedium()).placeholder(R.drawable.demo).fit().centerCrop().into(characterImage);
        }
    }

    @Override
    public int getItemCount() {

        Log.v("***************", String.valueOf(actorList.size()));
        return actorList.size();
    }

}
