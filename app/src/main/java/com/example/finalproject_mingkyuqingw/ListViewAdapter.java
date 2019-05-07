package com.example.finalproject_mingkyuqingw;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class ListViewAdapter extends BaseAdapter {

    Context mContext;
    LayoutInflater inflater;
    List<Model> modellist;
    ArrayList<Model> arrayList;

    public  ListViewAdapter(Context context,List<Model>modellist){
        mContext = context;
        this.modellist = modellist;
        inflater = LayoutInflater.from(mContext);
        this.arrayList = new ArrayList<Model>();
        this.arrayList.addAll(modellist);
    }

    public class ViewHolder{
        TextView mTitleTv,mDescTv;
        ImageView mIconIv;
    }

    @Override
    public int getCount(){
        return modellist.size();
    }

    @Override
    public Object getItem(int i){
        return modellist.get(i);
    }

    @Override
    public long getItemId(int i){
        return i;
    }
    @Override
    public View getView(final int position, View view, ViewGroup parent){
        ViewHolder holder;
        if(view == null){
            holder = new ViewHolder();
            view = inflater.inflate(R.layout.row,null);

            holder.mTitleTv = view.findViewById(R.id.main_title);
            holder.mDescTv = view.findViewById(R.id.main_desc);
            holder.mIconIv = view.findViewById(R.id.main_icon);

            view.setTag(holder);
        }
        else{
            holder = (ViewHolder)view.getTag();
        }
        holder.mTitleTv.setText(modellist.get(position).getTitle());
        holder.mDescTv.setText(modellist.get(position).getDesc());
        holder.mIconIv.setImageResource(modellist.get(position).getIcon());

        view.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){

                if(modellist.get(position).getTitle().equals("one")){

                    Intent intent = new Intent (view.getContext(),ItemActivity.class);
                    intent.putExtra("actionBarTitle","one");
                    intent.putExtra("contentTv","This is one details");
                    view.getContext().startActivity(intent);

                }
                if(modellist.get(position).getTitle().equals("two")){

                    Intent intent = new Intent (view.getContext(),ItemActivity.class);
                    intent.putExtra("actionBarTitle","two");
                    intent.putExtra("contentTv","This is two details");
                    view.getContext().startActivity(intent);

                }
                if(modellist.get(position).getTitle().equals("three")){

                    Intent intent = new Intent (view.getContext(),ItemActivity.class);
                    intent.putExtra("actionBarTitle","three");
                    intent.putExtra("contentTv","This is three details");
                    view.getContext().startActivity(intent);

                }
                if(modellist.get(position).getTitle().equals("four")){

                    Intent intent = new Intent (view.getContext(),ItemActivity.class);
                    intent.putExtra("actionBarTitle","four");
                    intent.putExtra("contentTv","This is four details");
                    view.getContext().startActivity(intent);

                }

            }

        });
        return view;
    }

    public void filter(String charText){
        charText = charText.toLowerCase(Locale.getDefault());
        modellist.clear();
        if(charText.length()== 0){
            modellist.addAll(arrayList);
        }
        else{
            for (Model model:arrayList){
                if(model.getTitle().toLowerCase(Locale.getDefault())
                        .contains(charText)){
                    modellist.add(model);
                }
            }
        }
        notifyDataSetChanged();
    }


}
