package com.example.kaiyuanzhongguo.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.kaiyuanzhongguo.Bean.DaiMaPianDuanBean;
import com.example.kaiyuanzhongguo.R;

import java.util.List;

/**
 * Created by asus on 2017/10/31.
 */
public class DaiMaPianDuanLVAdapter extends BaseAdapter {
    private Context context;
    private List<DaiMaPianDuanBean.TweetBean> list;

    public DaiMaPianDuanLVAdapter(Context context, List<DaiMaPianDuanBean.TweetBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.daimapianduanlayout, null);
            viewHolder = new ViewHolder(view);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }
        viewHolder.name_daimapianduan.setText(list.get(i).getAuthor());
        Glide.with(context).load(list.get(i).getPortrait()).into(viewHolder.img_daimapianduan);
        //  Picasso.with(context).load(list.get(i).getPortrait()).into(viewHolder.touxiang_dongtan);
        return view;
    }

    public static class ViewHolder {
        public View rootView;
        public ImageView img_daimapianduan;
        public TextView name_daimapianduan;
        public TextView biaoqian1_daimapianduan;
        public TextView biaoqian2_daimapianduan;

        public ViewHolder(View rootView) {
            this.rootView = rootView;
            this.img_daimapianduan = (ImageView) rootView.findViewById(R.id.img_daimapianduan);
            this.name_daimapianduan = (TextView) rootView.findViewById(R.id.name_daimapianduan);
            this.biaoqian1_daimapianduan = (TextView) rootView.findViewById(R.id.biaoqian1_daimapianduan);
            this.biaoqian2_daimapianduan = (TextView) rootView.findViewById(R.id.biaoqian2_daimapianduan);
        }

    }
}
