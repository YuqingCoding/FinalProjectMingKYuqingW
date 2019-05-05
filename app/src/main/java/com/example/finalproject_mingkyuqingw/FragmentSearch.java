package com.example.finalproject_mingkyuqingw;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toolbar;

import com.miguelcatalan.materialsearchview.MaterialSearchView;

import java.util.ArrayList;
import java.util.List;

public class FragmentSearch extends Fragment {

    public final static String TAG = "Search Fragment";
    private ListView listView;
    private ArrayAdapter<String> adapter;
    Toolbar toolbar;

    String listSource[] = {
            "western food", "Chinese", "Japanese", "southeastern asian", "brunch", "dessert", "fast food"
    };

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_search, container, false);

    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        toolbar = (Toolbar) view.findViewById(R.id.toolbar);
        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle("Material Search");
        toolbar.setTitleTextColor(Color.parseColor("#FFFFFF"));
        setHasOptionsMenu(true);

        listView = (ListView) view.findViewById(R.id.list_view);
        adapter = new ArrayAdapter<String>(FragmentSearch.this,R.layout.search_item,listSource);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String Templistview = listSource[position].toString();
                Intent intent = new Intent(FragmentSearch.this,ItemFragment.class);
                intent.putExtra("Listviewclickvalue", Templistview);
                startActivity(intent);
            }
        });

        MaterialSearchView searchView = (MaterialSearchView) view.findViewById(R.id.search_view);
        searchView.setOnSearchViewListener(new MaterialSearchView.SearchViewListener() {
            @Override
            public void onSearchViewShown() {

            }

            @Override
            public void onSearchViewClosed() {
                listView = (ListView) view.findViewById(R.id.list_view);
                adapter = new ArrayAdapter<String>(FragmentSearch.this,R.layout.search_item,listSource);
                listView.setAdapter(adapter);

            }
        });

        searchView.setOnQueryTextListener(new MaterialSearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                if (newText != null && !newText.isEmpty()) {
                    List<String> listFound = new ArrayList<String>();
                    for (String item : listSource) {
                        if (item.contains(newText))
                            listFound.add(item);
                    }

                    adapter = new ArrayAdapter<String>(FragmentSearch.this, R.layout.search_item, listFound);
                    listView.setAdapter(adapter);
                } else {
                    //if search text is null, return default
                    adapter = new ArrayAdapter<String>(this, R.layout.search_item, listSource);
                    listView.setAdapter(adapter);
                }
                return true;
            }

        });
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_item,menu);
        super.onCreateOptionsMenu(menu,inflater);

    }

}
