package com.example.finalproject_mingkyuqingw;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class FragmentLikes extends Fragment {
    public final static String TAG = "Likes Fragment";

    private RecyclerView recyclerView;
    private List<Restaurant> restaurants;
    private FragmentLikesAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_my_likes, container, false);

        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);

        restaurants = new ArrayList<>();
        adapter = new FragmentLikesAdapter(this.getContext(), restaurants);
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
        recyclerView.setAdapter(adapter);


        for (int i = 0; i < 100; i++) {
            if (i % 4 == 0) {
                restaurants.add(new Restaurant(R.string.blue_sky_restaurant, R.drawable.restaurant_one));
            } else if (i % 4 == 1) {
                restaurants.add(new Restaurant(R.string.dream_coffee, R.drawable.restaurant_two));
            } else if (i % 4 == 2) {
                restaurants.add(new Restaurant(R.string.go_brunch, R.drawable.restaurant_three));
            } else if (i % 4 == 3) {
                restaurants.add(new Restaurant(R.string.green_valley, R.drawable.restaurant_four));
            }

        }

        return view;
    }
}





