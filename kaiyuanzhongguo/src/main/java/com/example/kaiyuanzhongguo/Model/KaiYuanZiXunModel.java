package com.example.kaiyuanzhongguo.Model;

import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.util.Xml;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by asus on 2017/10/30.
 */
public class KaiYuanZiXunModel implements ModelInf {
    @Override
    public void getData(final Handler handler) {
        OkHttpClient okHttpClient = new OkHttpClient();
        Request request = new Request.Builder().url("http://www.oschina.net/action/api/news_list").build();
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
            }
            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Message message = handler.obtainMessage();
                String data = response.body().string();
                handler.sendMessage(toXNL(data,message));
            }
        });
    }
    private Message toXNL(String text, Message message) {
        JSONObject oschina = null;
        JSONObject newsObj = null;
        JSONArray newslist = null;
        try {
            //第一步，实例化xml 的pull解析器
            XmlPullParser xmlPullParser = Xml.newPullParser();
            //第二步，获取一个byte数组字节输入流
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(text.getBytes());
            //第三步，设置输入流编码 utf-8
            xmlPullParser.setInput(byteArrayInputStream,"utf-8");
            //第四步，获取第一个事件
            int event = xmlPullParser.getEventType(); //START_DOCUMENT 标记文档开始读 《xml -----------》
            //第五步，遍历
            while ((event!=xmlPullParser.END_DOCUMENT)){ //END_DOCUMENT ; 标记文档已经读完
                String titleName = xmlPullParser.getName(); //titleNam:标签的名字   《titleName》 。。。。。 《/titleName》
                switch (event){
                    case XmlPullParser.START_TAG:

                        switch (titleName){
                            case "oschina":
                                oschina = new JSONObject();
                                break;
                            case "newslist":
                                newslist = new JSONArray();
                                break;
                            case "news":
                                newsObj = new JSONObject();
                                break;
                            //-------------------实例化对象完毕-----------------------
                            case "id":
                                newsObj.put("id",xmlPullParser.nextText());
                                break;
                            case "title":
                                newsObj.put("title",xmlPullParser.nextText());
                                break;
                            case "body":
                                newsObj.put("body",xmlPullParser.nextText());
                                break;
                            case "commentCount":
                                newsObj.put("commentCount",xmlPullParser.nextText());
                                break;
                            case "author":
                                newsObj.put("author",xmlPullParser.nextText());
                                break;
                            case "pubDate":
                                newsObj.put("pubDate",xmlPullParser.nextText());
                                break;
                            case "url":
                                newsObj.put("url",xmlPullParser.nextText());
                                break;
                        }
                        break;
                    case XmlPullParser.END_TAG:
                        if (titleName.equals("news")){
                            newslist.put(newsObj);
                        }
                        if (titleName.equals("oschina")){
                            oschina.put("newslist",newslist);
                        }
                        break;
                }
                event = xmlPullParser.next();// 第六步  ，再次获取下一个状态值
            }
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (XmlPullParserException e) {

        }
        message.obj = oschina;
        Log.e("---",newslist.toString());
        return message;
    };
}
