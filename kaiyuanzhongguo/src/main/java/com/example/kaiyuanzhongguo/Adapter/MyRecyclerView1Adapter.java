package com.example.kaiyuanzhongguo.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.kaiyuanzhongguo.R;
import com.example.kaiyuanzhongguo.RecyclerViewClickLister;

import java.util.ArrayList;

/**
 * Created by asus on 2017/11/9.
 */
public class MyRecyclerView1Adapter extends RecyclerView.Adapter<MyRecyclerView1Adapter.MyViewHoder1> {
    ArrayList<String> title;
    Context cont;
    public boolean aBoolean = false;
    private RecyclerViewClickLister recyclerViewClickLister;
    public MyRecyclerView1Adapter(ArrayList<String> title, Context cont) {
        this.title = title;
        this.cont = cont;

    }
    public void setRecyclerViewClickLister(RecyclerViewClickLister recyclerViewClickLister) {
        this.recyclerViewClickLister = recyclerViewClickLister;
    }

    public void setaBoolean(boolean aBoolean) {
        this.aBoolean = aBoolean;
    }
    @Override
    public MyViewHoder1 onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(cont).inflate(R.layout.biaoqian1, parent, false);
        MyViewHoder1 myViewHoder1=new MyViewHoder1(view);
        return myViewHoder1;
    }

    @Override
    public void onBindViewHolder(MyViewHoder1 holder, final int position) {
/*holder.name.setText(title.get(position));*/
        if (position<4){
            holder.itemView.setTag(R.id.mydt_name,"no");
            holder.textView.setTextColor(cont.getResources().getColor(android.R.color.holo_blue_bright));
        }else {
            holder.itemView.setTag(R.id.mydt_name,"yes");
            holder.textView.setTextColor(cont.getResources().getColor(android.R.color.background_dark));
        }
        if (aBoolean && position>3){
            holder.imageView.setVisibility(View.VISIBLE);
        }else {
            holder.imageView.setVisibility(View.GONE);
        }
        holder.textView.setText(title.get(position).toString());
        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                recyclerViewClickLister.itemLongClickLister(title.get(position).toString()+";"+position);
                return true;
            }
        });
        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                recyclerViewClickLister.itemClickLister(title.get(position)+";"+position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return title.size();
    }

    public void adds(String data){
        title.add(data);
        notifyItemInserted(getItemCount());
    }
    public void dlt(String data,int position){
        title.remove(data);
        notifyItemRemoved(position);
        notifyDataSetChanged();
    }

    public class MyViewHoder1 extends RecyclerView.ViewHolder {
        public TextView textView;
        public ImageView imageView;
        public MyViewHoder1(View itemView) {
            super(itemView);
            textView = (TextView)itemView.findViewById(R.id.textView);
            imageView = (ImageView)itemView.findViewById(R.id.imageView3);
        }
    }
}


