package com.example.kaiyuanzhongguo.Presenter;

import android.os.Handler;
import android.os.Message;

import com.example.kaiyuanzhongguo.Fragment.ZhongHe.AFragment;
import com.example.kaiyuanzhongguo.Model.KaiYuanZiXunModel;
import com.example.kaiyuanzhongguo.Model.ModelInf;
import com.example.kaiyuanzhongguo.View.ViewInf.ViewInf;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by asus on 2017/10/30.
 */
public class KaiYuanZiXunPresenter implements PresenterInf {

    private ModelInf modelInf;
    private ViewInf viewInf;
    public KaiYuanZiXunPresenter(AFragment aFragment){
        modelInf = new KaiYuanZiXunModel();
        viewInf = aFragment;
    }
    @Override
    public void ViewToModel() {
        modelInf.getData(handler);
    }
    Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            try {
                viewInf.updataUI(new JSONObject(msg.obj.toString()));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    };
}
