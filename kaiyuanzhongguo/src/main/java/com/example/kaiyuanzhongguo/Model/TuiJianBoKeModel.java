package com.example.kaiyuanzhongguo.Model;

import android.os.Handler;
import android.util.Log;

import com.example.kaiyuanzhongguo.Bean.TuiJianBoKeBean;
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
public class TuiJianBoKeModel implements ModelInf {
    @Override
    public void getData(final Handler handler) {
        OkHttpClient okHttpClient = new OkHttpClient();
        Request request = new Request.Builder().url("http://www.oschina.net/action/api/blog_list").build();
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
            }
            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String string = response.body().string();
                Log.i("login",string);
                XStream xStream = new XStream();
                xStream.alias("oschina", TuiJianBoKeBean.class);
                xStream.alias("notice", TuiJianBoKeBean.NoticeBean.class);
                xStream.alias("blog", TuiJianBoKeBean.BlogBean.class);
                TuiJianBoKeBean bean = (TuiJianBoKeBean) xStream.fromXML(string);
                List<TuiJianBoKeBean.BlogBean> list = bean.getBlogs();

                handler.obtainMessage(100,list).sendToTarget();
            }
        });
    }
}

