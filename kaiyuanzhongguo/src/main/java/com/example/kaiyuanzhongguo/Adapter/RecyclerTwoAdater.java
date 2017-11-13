package com.example.kaiyuanzhongguo.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.kaiyuanzhongguo.R;
import com.example.kaiyuanzhongguo.RecyclerViewClickLister;

import java.util.List;

/**
 * Created by asus on 2017/11/9.
 */
public class RecyclerTwoAdater extends RecyclerView.Adapter<RecyclerTwoAdater.ViewHolder> {


    protected Context mContext;
    protected LayoutInflater mInflater;
    private List list;
    private RecyclerViewClickLister recyclerViewClickLister;

    public RecyclerTwoAdater(Context context , List list) {
        mContext = context;
        this.list = list;
        mInflater = LayoutInflater.from(context);
    }

    public void setRecyclerViewClickLister(RecyclerViewClickLister recyclerViewClickLister) {
        this.recyclerViewClickLister = recyclerViewClickLister;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //通过layoutId即可利用我们的通用的ViewHolder生成实例
        ViewHolder viewHolder = null;
        viewHolder = new ViewHolder(mInflater.inflate(R.layout.biaoqian1,parent,false));
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder,final int position) {
        //这里主要用于数据、事件绑定，我们这里直接抽象出去，让用户去操作。
        // 可以看到我们修改了下参数，用户可以拿到当前Item所需要的对象和viewHolder去操作。
        holder.textView.setText(list.get(position).toString());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                recyclerViewClickLister.itemLongClickLister(list.get(position).toString()+";"+(position));
            }
        });
    }


    @Override
    public int getItemCount() {
        return list.size();
    }

    public void adds(String data){
        list.add(data);
        notifyItemInserted(getItemCount());
    }
    public void dlt(String data,int position){
        list.remove(data);
        notifyItemRemoved(position);
        notifyDataSetChanged();
    }

    /**
     * 各种布局，进行重用的view
     */
    public class ViewHolder extends RecyclerView.ViewHolder{

        public TextView textView;

        public ViewHolder(View itemView) {
            super(itemView);
            textView = (TextView)itemView.findViewById(R.id.textView);
        }
    }

}

