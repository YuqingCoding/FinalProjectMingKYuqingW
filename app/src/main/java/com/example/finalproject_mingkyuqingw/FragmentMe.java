package com.example.finalproject_mingkyuqingw;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;

import java.util.ArrayList;

public class FragmentMe extends Fragment {
    public final static String TAG = "Me Fragment";

    ListView listView;
    Context thisContext;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        thisContext = container.getContext();
        return inflater.inflate(R.layout.fragment_me, container, false);


    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {

        listView = (ListView) getView().findViewById(R.id.user_setting_list);

        ArrayList<String>arrayList = new ArrayList<>();

        arrayList.add("User: Detective Pikachu");
        arrayList.add("My Activity");
        arrayList.add("Message");
        arrayList.add("General Setting");

        ArrayAdapter arrayAdapter = new ArrayAdapter(thisContext,android.R.layout.simple_list_item_1,arrayList);
        listView.setAdapter(arrayAdapter);

    }

}