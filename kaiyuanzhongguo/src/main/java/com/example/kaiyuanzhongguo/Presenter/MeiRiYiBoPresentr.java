package com.example.kaiyuanzhongguo.Presenter;

import android.os.Handler;
import android.os.Message;

import com.example.kaiyuanzhongguo.Bean.TuiJianBoKeBean;
import com.example.kaiyuanzhongguo.Fragment.ZhongHe.DFragment;
import com.example.kaiyuanzhongguo.Model.ModelInf;
import com.example.kaiyuanzhongguo.Model.TuiJianBoKeModel;
import com.example.kaiyuanzhongguo.View.ViewInf.ViewInf1;

import java.util.List;

/**
 * Created by asus on 2017/11/1.
 */
public class MeiRiYiBoPresentr implements PresenterInf {
    private ModelInf modelInf;
    private ViewInf1 viewInf;
    public MeiRiYiBoPresentr(DFragment dFragment){
        modelInf = new TuiJianBoKeModel();
        viewInf = dFragment;
    }
    @Override
    public void ViewToModel() {
        modelInf.getData(handler);
    }
    Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            List<TuiJianBoKeBean.BlogBean> list = (List<TuiJianBoKeBean.BlogBean>) msg.obj;
            viewInf.updataUI(list);
        }
    };
}
