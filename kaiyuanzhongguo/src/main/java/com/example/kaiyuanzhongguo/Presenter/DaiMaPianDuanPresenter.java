package com.example.kaiyuanzhongguo.Presenter;

import android.os.Handler;
import android.os.Message;

import com.example.kaiyuanzhongguo.Bean.DaiMaPianDuanBean;
import com.example.kaiyuanzhongguo.Model.DaiMaPianDuanModel;
import com.example.kaiyuanzhongguo.Model.ModelInf;
import com.example.kaiyuanzhongguo.View.FaXianActivity.DaiMaPianDuanActivity;
import com.example.kaiyuanzhongguo.View.ViewInf.ViewInf4;

import java.util.List;

/**
 * Created by asus on 2017/11/8.
 */
public class DaiMaPianDuanPresenter implements PresenterInf {
    private ModelInf modelInf;
    private ViewInf4 viewInf;

    public DaiMaPianDuanPresenter(DaiMaPianDuanActivity daiMaPianDuanActivity) {
        this.modelInf = new DaiMaPianDuanModel();
        this.viewInf = daiMaPianDuanActivity;
    }

    @Override
    public void ViewToModel() {
        modelInf.getData(handler);
    }
    Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            List<DaiMaPianDuanBean.TweetBean> list = (List<DaiMaPianDuanBean.TweetBean>) msg.obj;
            viewInf.updateUI(list);
        }
    };
}
