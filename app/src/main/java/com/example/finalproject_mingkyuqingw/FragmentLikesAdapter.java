package com.example.finalproject_mingkyuqingw;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;


import java.util.List;

public class FragmentLikesAdapter extends RecyclerView.Adapter<FragmentLikesAdapter.ResViewHolder> {

    private Context context;

    private List<Restaurant> restaurants;

    public FragmentLikesAdapter(Context context, List<Restaurant> restaurants) {
        this.context = context;
        this.restaurants = restaurants;

    }

    @Override
    public ResViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ResViewHolder(LayoutInflater.from(context).inflate(R.layout.activity_fragment_likes_adapter, parent, false));
    }


    @Override
    public void onBindViewHolder(ResViewHolder viewHolder, final int position) {



        viewHolder.textView.setText(restaurants.get(position).getName());
        viewHolder.imageView.setImageResource(restaurants.get(position).getPhotoId());

        if (position % 2 == 0) {
            viewHolder.imageView.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 500));
            viewHolder.textView.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 100));
        } else {
            viewHolder.imageView.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 600));

            viewHolder.textView.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 100));

        }

    }

    @Override
    public int getItemCount() {
        return restaurants.size();
    }


    class ResViewHolder extends RecyclerView.ViewHolder {

        private ImageView imageView;
        private TextView textView;

        public ResViewHolder(View itemView) {
            super(itemView);
            this.imageView = (ImageView) itemView.findViewById(R.id.restaurant_image1);
            this.textView = (TextView) itemView.findViewById(R.id.name_restaurant);

        }
    }
}



