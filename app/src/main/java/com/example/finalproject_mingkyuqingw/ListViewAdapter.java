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

                if(modellist.get(position).getTitle().equals("Blue Sky")){

                    Intent intent = new Intent (view.getContext(),ItemActivity.class);
                    intent.putExtra("actionBarTitle","Blue Sky");
                    intent.putExtra("contentTv","Blue Sky");
                    view.getContext().startActivity(intent);

                }
                if(modellist.get(position).getTitle().equals("Dream Coffee")){

                    Intent intent = new Intent (view.getContext(),Item2Activity.class);
                    intent.putExtra("actionBarTitle","Dream Coffee");
                    intent.putExtra("contentTv","Dream Coffee");
                    view.getContext().startActivity(intent);

                }
                if(modellist.get(position).getTitle().equals("Go Brunch")){

                    Intent intent = new Intent (view.getContext(),ItemActivity.class);
                    intent.putExtra("actionBarTitle","Go Brunch");
                    intent.putExtra("contentTv","Go Brunch");
                    view.getContext().startActivity(intent);

                }
                if(modellist.get(position).getTitle().equals("Green Valley")){

                    Intent intent = new Intent (view.getContext(),ItemActivity.class);
                    intent.putExtra("actionBarTitle","Green Valley");
                    intent.putExtra("contentTv","Green Valley");
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
