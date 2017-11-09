package com.example.kaiyuanzhongguo.Model;

import android.os.Handler;
import android.util.Log;

import com.example.kaiyuanzhongguo.Bean.ZuiJinDongTanBean;
import com.thoughtworks.xstream.XStream;

import java.io.IOException;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by asus on 2017/10/31.
 */
public class ZuiXinDongTanModel implements ModelInf {
    @Override
    public void getData(final Handler handler) {
        OkHttpClient okHttpClient = new OkHttpClient();
        Request request = new Request.Builder().url("http://www.oschina.net/action/api/tweet_list").build();
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
            }
            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String string = response.body().string();
                XStream xStream = new XStream();
                xStream.alias("oschina", ZuiJinDongTanBean.class);
                xStream.alias("notice", ZuiJinDongTanBean.NoticeBean.class);
                xStream.alias("tweet", ZuiJinDongTanBean.TweetBean.class);
                ZuiJinDongTanBean bean = (ZuiJinDongTanBean) xStream.fromXML(string);
                List<ZuiJinDongTanBean.TweetBean> list = bean.getTweets();

                handler.obtainMessage(100,list).sendToTarget();
            }
        });
    }
}

