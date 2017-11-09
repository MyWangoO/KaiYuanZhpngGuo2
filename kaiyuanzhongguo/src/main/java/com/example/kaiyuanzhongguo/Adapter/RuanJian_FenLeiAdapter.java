package com.example.kaiyuanzhongguo.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.kaiyuanzhongguo.R;

import java.util.List;

/**
 * Created by asus on 2017/11/8.
 */
public class RuanJian_FenLeiAdapter extends BaseAdapter {
    private Context context;
    private List<String> list;

    public RuanJian_FenLeiAdapter(Context context, List<String> list) {
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
        ViewHolder vh;
        if (view==null){
            view = LayoutInflater.from(context).inflate(R.layout.ruanjian_fenleilayout, null);
            vh = new ViewHolder(view);
            view.setTag(vh);
        }else {
            vh = (ViewHolder) view.getTag();
        }
        vh.name_fenlei.setText(list.get(i));
        return view;
    }

    public static class ViewHolder {
        public View rootView;
        public TextView name_fenlei;

        public ViewHolder(View rootView) {
            this.rootView = rootView;
            this.name_fenlei = (TextView) rootView.findViewById(R.id.name_fenlei);
        }

    }
}
