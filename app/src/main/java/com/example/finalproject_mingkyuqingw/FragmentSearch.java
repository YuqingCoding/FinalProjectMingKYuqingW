package com.example.finalproject_mingkyuqingw;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.support.v7.widget.SearchView;

import java.util.ArrayList;

public class FragmentSearch extends Fragment {
    public final static String TAG = "Search Fragment";
    ListView listView;
    ListViewAdapter adapter;
    String[] title;
    String[] description;
    int[] icon;
    ArrayList<Model> arrayList = new ArrayList<Model>();


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_search,container,false);

    }

    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ActionBar actionBar = ((AppCompatActivity)getActivity()).getSupportActionBar();
        actionBar.setTitle("Food Map");

        title = new String[]{"Blue Sky","Dream Coffee","Go Brunch","Green Valley"};
        description = new String[]{"American Food","Coffee Shop","Brunch","Salad"};
        icon = new int[]{R.drawable.restaurant_one,R.drawable.restaurant_two,R.drawable.restaurant_three,R.drawable.restaurant_four};

        listView = view.findViewById(R.id.list_view);
        setHasOptionsMenu(true);

        for(int i = 0;i<title.length;i++){
            Model model = new Model(title[i],description[i],icon[i]);
            arrayList.add(model);
        }

        adapter = new ListViewAdapter(getView().getContext(),arrayList);
        listView.setAdapter(adapter);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu,menu);
        MenuItem myActionMenuItem = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView)myActionMenuItem.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                if(TextUtils.isEmpty(newText)){
                    adapter.filter("");
                    listView.clearTextFilter();
                }
                else{
                    adapter.filter(newText);
                }
                return true;
            }
        });
        super.onCreateOptionsMenu(menu,inflater);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();
        if(id == R.id.action_settings){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}