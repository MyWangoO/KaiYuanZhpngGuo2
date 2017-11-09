package com.example.kaiyuanzhongguo.Adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.kaiyuanzhongguo.Bean.ZuiJinDongTanBean;
import com.example.kaiyuanzhongguo.R;

import java.util.List;

/**
 * Created by asus on 2017/10/31.
 */
public class ZuiXinDongTanLVAdapter extends BaseAdapter {
    private Context context;
    private List<ZuiJinDongTanBean.TweetBean> list;

    public ZuiXinDongTanLVAdapter(Context context, List<ZuiJinDongTanBean.TweetBean> list) {
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
        if (view==null){
            view = LayoutInflater.from(context).inflate(R.layout.zuixindongtan_lv, null);
            viewHolder = new ViewHolder(view);
            view.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) view.getTag();
        }
        viewHolder.biaoti_zixun.setText(list.get(i).getAuthor());
        viewHolder.text_zixun.setText(list.get(i).getBody());
        Log.i("login",list.get(i).getPortrait());

        Glide.with(context).load(list.get(i).getPortrait()).into(viewHolder.touxiang_dongtan);
      //  Picasso.with(context).load(list.get(i).getPortrait()).into(viewHolder.touxiang_dongtan);
        return view;
    }

    public static class ViewHolder {
        public View rootView;
        public ImageView touxiang_dongtan;
        public TextView biaoti_zixun;
        public TextView text_zixun;
        public TextView shijian_zixun;

        public ViewHolder(View rootView) {
            this.rootView = rootView;
            this.touxiang_dongtan = (ImageView) rootView.findViewById(R.id.touxiang_dongtan);
            this.biaoti_zixun = (TextView) rootView.findViewById(R.id.biaoti_zixun);
            this.text_zixun = (TextView) rootView.findViewById(R.id.text_zixun);
            this.shijian_zixun = (TextView) rootView.findViewById(R.id.shijian_zixun);
        }

    }
}
