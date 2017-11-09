package com.example.kaiyuanzhongguo.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.kaiyuanzhongguo.Bean.TuiJianBoKeBean;
import com.example.kaiyuanzhongguo.R;

import java.util.List;

/**
 * Created by asus on 2017/11/1.
 */
public class TuiJianBoKeAdapter extends BaseAdapter {
    private Context context;
    private List<TuiJianBoKeBean.BlogBean> list;

    public TuiJianBoKeAdapter(Context context, List<TuiJianBoKeBean.BlogBean> list) {
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
            view = LayoutInflater.from(context).inflate(R.layout.tuijianboke_lv, null);
            vh = new ViewHolder(view);
            view.setTag(vh);
        }else {
            vh= (ViewHolder) view.getTag();
        }
        vh.biaoti_tuijian.setText(list.get(i).getTitle());
        vh.text_tuijian.setText(list.get(i).getBody());
        vh.name_tuijian.setText(list.get(i).getAuthorname());
        vh.pinglun_tuijian.setText(list.get(i).getCommentCount());
        return view;
    }

    public static class ViewHolder {
        public View rootView;
        public TextView biaoti_tuijian;
        public TextView text_tuijian;
        public TextView name_tuijian;
        public TextView shijian_zixun;
        public TextView pinglun_tuijian;

        public ViewHolder(View rootView) {
            this.rootView = rootView;
            this.biaoti_tuijian = (TextView) rootView.findViewById(R.id.biaoti_tuijian);
            this.text_tuijian = (TextView) rootView.findViewById(R.id.text_tuijian);
            this.name_tuijian = (TextView) rootView.findViewById(R.id.name_tuijian);
            this.shijian_zixun = (TextView) rootView.findViewById(R.id.shijian_zixun);
            this.pinglun_tuijian = (TextView) rootView.findViewById(R.id.pinglun_tuijian);
        }

    }
}
