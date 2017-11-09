package com.example.kaiyuanzhongguo.Model;

import android.os.Handler;

import com.example.kaiyuanzhongguo.Bean.DaiMaPianDuanBean;
import com.thoughtworks.xstream.XStream;

import java.io.IOException;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by asus on 2017/11/8.
 */
public class DaiMaPianDuanModel implements ModelInf {
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
                xStream.alias("oschina", DaiMaPianDuanBean.class);
                xStream.alias("notice", DaiMaPianDuanBean.NoticeBean.class);
                xStream.alias("tweet", DaiMaPianDuanBean.TweetBean.class);
                DaiMaPianDuanBean bean = (DaiMaPianDuanBean) xStream.fromXML(string);
                List<DaiMaPianDuanBean.TweetBean> tweets = bean.getTweets();
                handler.obtainMessage(100,tweets).sendToTarget();
            }
        });
    }
}
