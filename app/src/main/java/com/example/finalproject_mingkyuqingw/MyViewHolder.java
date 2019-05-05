package com.example.finalproject_mingkyuqingw;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

public class MyViewHolder extends RecyclerView.ViewHolder {

    private ImageView imageView;

    public MyViewHolder(View itemView){
        super(itemView);
        this.imageView =(ImageView)itemView.findViewById(R.id.restaurant_image1);
    }
}
