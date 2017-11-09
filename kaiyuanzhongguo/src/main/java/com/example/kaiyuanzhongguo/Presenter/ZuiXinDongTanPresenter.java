package com.example.kaiyuanzhongguo.Presenter;

import android.os.Handler;
import android.os.Message;

import com.example.kaiyuanzhongguo.Bean.ZuiJinDongTanBean;
import com.example.kaiyuanzhongguo.Fragment.DongTan.EFragment;
import com.example.kaiyuanzhongguo.Model.ModelInf;
import com.example.kaiyuanzhongguo.Model.ZuiXinDongTanModel;
import com.example.kaiyuanzhongguo.View.ViewInf.ViewInf2;

import java.util.List;

/**
 * Created by asus on 2017/10/31.
 */
public class ZuiXinDongTanPresenter implements PresenterInf {
    private ModelInf modelInf;
    private ViewInf2 viewInf;
    public ZuiXinDongTanPresenter(EFragment eFragment){
        modelInf = new ZuiXinDongTanModel();
        viewInf = eFragment;
    }
    @Override
    public void ViewToModel() {
        modelInf.getData(handler);
    }
    Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case 100:
                    List<ZuiJinDongTanBean.TweetBean> list = (List<ZuiJinDongTanBean.TweetBean>) msg.obj;
                    viewInf.updataUI(list);
                    break;
            }
        }
    };
}
