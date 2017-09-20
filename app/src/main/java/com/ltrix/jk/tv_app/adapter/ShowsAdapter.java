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
import com.ltrix.jk.tv_app.Shows;
import com.ltrix.jk.tv_app.activity.ShowDetailsActivity;
import com.squareup.picasso.Picasso;

import java.util.List;


/**
 * Created by bindu on 11/09/17.
 */

public class ShowsAdapter extends RecyclerView.Adapter<ShowsAdapter.MyViewHolder>   {

    private List<Shows> showsList;

    private  Context context;

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public TextView title, year, genre;
        public ImageView showImage;

        public MyViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.show_name);
            showImage = (ImageView) view.findViewById(R.id.show_image);
            view.setOnClickListener(this);
        }


        @Override
        public void onClick(View view) {

            Log.d("RecyclerView", "CLICK!");
            Intent i = new Intent(context,ShowDetailsActivity.class);
            context.startActivity(i);
        }
    }

    public ShowsAdapter(List<Shows> showsList,Context context) {
        this.showsList = showsList;
        this.context = context;
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

        Shows show = showsList.get(position);
        holder.title.setText(show.getTitle());
        Picasso.with(context).load(show.getImageURL()).placeholder(R.drawable.demo).fit().centerCrop().into(holder.showImage);


        Log.d("item width", "Value: " + Integer.toString(holder.itemView.getWidth()));

    }

    @Override
    public int getItemCount() {
        return showsList.size();
    }

}
