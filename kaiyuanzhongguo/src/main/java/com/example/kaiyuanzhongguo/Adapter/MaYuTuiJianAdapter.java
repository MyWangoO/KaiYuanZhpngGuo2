package com.example.kaiyuanzhongguo.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.kaiyuanzhongguo.Bean.MaYunTuiJianBean;
import com.example.kaiyuanzhongguo.R;

import java.util.List;

/**
 * Created by asus on 2017/11/6.
 */
public class MaYuTuiJianAdapter extends BaseAdapter {
    private List<MaYunTuiJianBean.SoftwareBean> list;
    private Context context;

    public MaYuTuiJianAdapter(List<MaYunTuiJianBean.SoftwareBean> list, Context context) {
        this.list = list;
        this.context = context;
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
            view = LayoutInflater.from(context).inflate(R.layout.mayuntuijian, null);
            vh = new ViewHolder(view);
            view.setTag(vh);
        }else {
            vh = (ViewHolder) view.getTag();
        }
        vh.name.setText(list.get(i).getName());
        vh.text.setText(list.get(i).getDescription());

        return view;
    }

    public static class ViewHolder {
        public View rootView;
        public TextView name;
        public TextView text;

        public ViewHolder(View rootView) {
            this.rootView = rootView;
            this.name = (TextView) rootView.findViewById(R.id.name);
            this.text = (TextView) rootView.findViewById(R.id.text);
        }

    }
}
