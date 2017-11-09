package com.example.kaiyuanzhongguo.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.kaiyuanzhongguo.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by asus on 2017/10/30.
 */
public class KaiYuanZiXunLVAdapter extends BaseAdapter {
    private Context context;
    private JSONArray list;

    public KaiYuanZiXunLVAdapter(Context context, JSONObject jsonObject) {
        this.context = context;
        try {
            this.list = jsonObject.getJSONArray("newslist");
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int getCount() {
        return list.length();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder vh;
        if (view==null){
            view = LayoutInflater.from(context).inflate(R.layout.kaiyuanzixun_lv, null);
            vh = new ViewHolder(view);
            view.setTag(vh);
        }else {
            vh= (ViewHolder) view.getTag();
        }
        try {
            vh.biaoti_zixun.setText(list.getJSONObject(i).getString("title"));
            vh.text_zixun.setText(list.getJSONObject(i).getString("body"));
            vh.name_zixun.setText(list.getJSONObject(i).getString("author"));
            vh.pinglun_zixun.setText(list.getJSONObject(i).getString("commentCount"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return view;
    }

    public static class ViewHolder {
        public View rootView;
        public TextView biaoti_zixun;
        public TextView text_zixun;
        public TextView name_zixun;
        public TextView shijian_zixun;
        public TextView pinglun_zixun;

        public ViewHolder(View rootView) {
            this.rootView = rootView;
            this.biaoti_zixun = (TextView) rootView.findViewById(R.id.biaoti_zixun);
            this.text_zixun = (TextView) rootView.findViewById(R.id.text_zixun);
            this.name_zixun = (TextView) rootView.findViewById(R.id.name_zixun);
            this.shijian_zixun = (TextView) rootView.findViewById(R.id.shijian_zixun);
            this.pinglun_zixun = (TextView) rootView.findViewById(R.id.pinglun_zixun);
        }

    }
}
