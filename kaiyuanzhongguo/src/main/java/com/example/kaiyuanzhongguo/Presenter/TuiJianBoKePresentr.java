package com.example.kaiyuanzhongguo.Presenter;

import android.os.Handler;
import android.os.Message;

import com.example.kaiyuanzhongguo.Bean.TuiJianBoKeBean;
import com.example.kaiyuanzhongguo.Fragment.ZhongHe.BFragment;
import com.example.kaiyuanzhongguo.Model.ModelInf;
import com.example.kaiyuanzhongguo.Model.TuiJianBoKeModel;
import com.example.kaiyuanzhongguo.View.ViewInf.ViewInf1;

import java.util.List;

/**
 * Created by asus on 2017/11/1.
 */
public class TuiJianBoKePresentr implements PresenterInf {
    private ModelInf modelInf;
    private ViewInf1 viewInf;
    public TuiJianBoKePresentr(BFragment bFragment){
        modelInf = new TuiJianBoKeModel();
        viewInf = bFragment;
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
