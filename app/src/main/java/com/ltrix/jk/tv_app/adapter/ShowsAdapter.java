package com.ltrix.jk.tv_app.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.ltrix.jk.tv_app.R;
import com.ltrix.jk.tv_app.activity.ShowDetailsActivity;
import com.ltrix.jk.tv_app.model.Show;
import com.squareup.picasso.Picasso;

import java.util.List;


/**
 * Created by bindu on 11/09/17.
 */

public class ShowsAdapter extends RecyclerView.Adapter<ShowsAdapter.MyViewHolder> implements View.OnClickListener {

    private List<Show> showsList;

    private  Context context;

    @Override
    public void onClick(View view) {

    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        public TextView title, year, genre;
        public ImageView showImage;

        public MyViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.show_name);
            showImage = (ImageView) view.findViewById(R.id.show_image);
            //  view.setOnClickListener(this);
        }

//        @Override
//        public void onClick(View view) {
//
//            Log.d("RecyclerView", "CLICK!");
//            Intent i = new Intent(context,ShowDetailsActivity.class);
//            context.startActivity(i);
//        }
    }

    public ShowsAdapter(List<Show> showsList, Context context) {
        this.showsList = showsList;
        this.context = context;

        Log.v("shows",""+showsList);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.shows_row, parent, false);
        int width = parent.getMeasuredWidth() / 2;
        itemView.setMinimumWidth(width);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        final Show show = showsList.get(position);
        holder.title.setText(show.getName());
        Log.v("image",show.getImage().getOriginal());
        Picasso.with(context).load(show.getImage().getMedium()).placeholder(R.drawable.demo).fit().centerCrop().into(holder.showImage);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(context, ShowDetailsActivity.class);
                i.putExtra("show",show);
                context.startActivity(i);
            }
        });

    }

    @Override
    public int getItemCount() {
        return showsList.size();
    }

}
