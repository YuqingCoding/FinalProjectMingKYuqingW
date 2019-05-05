package com.example.finalproject_mingkyuqingw;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;


import java.util.List;

public class FragmentLikesAdapter extends RecyclerView.Adapter<MyViewHolder> {

    private Context context;

    private List<Integer> restaurantData;

    public FragmentLikesAdapter(Context context, List <Integer> restaurantData){
        this.context = context;
        this.restaurantData = restaurantData;


    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        MyViewHolder holder = new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.activity_fragment_likes_adapter, parent, false));
        return holder;
    }


    @Override
    public void OnBindViewHolder(MyViewHolder holder, int position){
        holder.imageView.setImageResource(this.restaurantData.get(position));

        if (position % 2 == 0) {
            holder.imageView.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 250));
        } else {
            holder.imageView.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 350));

        }
    }

        @Override
        public int getItemCount() {
            return this.restaurantData.size();
        }
}
