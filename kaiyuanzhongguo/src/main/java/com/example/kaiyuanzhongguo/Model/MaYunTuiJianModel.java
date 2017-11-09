package com.example.kaiyuanzhongguo.Model;

import android.os.Handler;
import android.util.Log;

import com.example.kaiyuanzhongguo.Bean.MaYunTuiJianBean;
import com.thoughtworks.xstream.XStream;

import java.io.IOException;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by asus on 2017/11/6.
 */
public class MaYunTuiJianModel implements ModelInf {
    @Override
    public void getData(final Handler handler) {
        OkHttpClient okHttpClient = new OkHttpClient();
        Request request = new Request.Builder().url("http://www.oschina.net/action/api/software_list").build();
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
            }
            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String string = response.body().string();
                Log.i("login",string);
                XStream xStream = new XStream();
                xStream.alias("oschina", MaYunTuiJianBean.class);
                xStream.alias("notice", MaYunTuiJianBean.NoticeBean.class);
                xStream.alias("software", MaYunTuiJianBean.SoftwareBean.class);
                MaYunTuiJianBean bean = (MaYunTuiJianBean) xStream.fromXML(string);
                List<MaYunTuiJianBean.SoftwareBean> list = bean.getSoftwares();
                handler.obtainMessage(100,list).sendToTarget();
            }
        });
    }
}
