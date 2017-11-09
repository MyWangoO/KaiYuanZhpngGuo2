package com.example.kaiyuanzhongguo.Presenter;

import android.os.Handler;
import android.os.Message;

import com.example.kaiyuanzhongguo.Bean.ZuiJinDongTanBean;
import com.example.kaiyuanzhongguo.Fragment.ZhongHe.CFragment;
import com.example.kaiyuanzhongguo.Model.ModelInf;
import com.example.kaiyuanzhongguo.Model.ZuiXinDongTanModel;
import com.example.kaiyuanzhongguo.View.ViewInf.ViewInf2;

import java.util.List;

/**
 * Created by asus on 2017/11/1.
 */
public class JiShuWenDaPresenter implements PresenterInf {
    private ModelInf modelInf;
    private ViewInf2 viewInf;
    public JiShuWenDaPresenter(CFragment cFragment){
        modelInf = new ZuiXinDongTanModel();
        viewInf = cFragment;
    }
    @Override
    public void ViewToModel() {
        modelInf.getData(handler);
    }
    Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            List<ZuiJinDongTanBean.TweetBean> list = (List<ZuiJinDongTanBean.TweetBean>) msg.obj;
            viewInf.updataUI(list);
        }
    };
}
