package com.example.finalproject_mingkyuqingw;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

public class fragmentSearch extends Fragment {
    ThingsAdapter adapter;
    FragmentActivity listener;
    public final static String TAG = "Search Fragment";
    private ListView listSearch;
    private EditText editSearch;
    private ArrayAdapter<String> arrayAdapter;


    @Override
    public void onAttach(Context context){
        super.onAttach(context);
        if(context instanceof Activity){
            this.listener = FragmentActivity(context);
        }

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ArrayList<Thing> things = new ArrayList<Thing>();
        adapter = new ThingsAdapter(getActivity(), things);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.search_fragment,container,false);
        return view;

    }
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        listSearch = (ListView) view.findViewById(R.id.list_search);
        listSearch.setAdapter(adapter);
    }

}

