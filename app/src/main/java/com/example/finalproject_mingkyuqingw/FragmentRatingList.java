package com.example.finalproject_mingkyuqingw;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;

import java.util.Objects;

public class FragmentRatingList extends Fragment {
    public final static String TAG = "Rating List Fragment";

    Spinner spinner;

    DistanceFragment distanceFragment;
    ScoreFragment scoreFragment;
    PriceFragment priceFragment;

    @Nullable
    @Override
    public View onCreateView (@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        return inflater.inflate(R.layout.fragment_restaurant_ranking,container,false);



    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        spinner = (Spinner) getView().findViewById(R.id.search_spinner);

        distanceFragment = new DistanceFragment();
        scoreFragment = new ScoreFragment();
        priceFragment = new PriceFragment();


        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(Objects.requireNonNull(this.getContext()),
                R.array.rating_type, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);


        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        setFragment(priceFragment);
                        break;
                    case 1:
                        setFragment(scoreFragment);
                        break;
                    case 2:
                        setFragment(distanceFragment);
                        break;
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }
     public void setFragment (Fragment fragment){
         FragmentTransaction fragmentTransaction = getChildFragmentManager().beginTransaction();
         fragmentTransaction.replace(R.id.rating_frame, fragment);
         fragmentTransaction.commit();
     }

    }
