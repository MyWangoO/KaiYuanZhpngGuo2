package com.example.kaiyuanzhongguo.Presenter;

import android.os.Handler;
import android.os.Message;

import com.example.kaiyuanzhongguo.Bean.MaYunTuiJianBean;
import com.example.kaiyuanzhongguo.Fragment.KaiYuanRuanJian.ReMenFragment;
import com.example.kaiyuanzhongguo.Model.MaYunTuiJianModel;
import com.example.kaiyuanzhongguo.Model.ModelInf;
import com.example.kaiyuanzhongguo.View.ViewInf.ViewInf3;

import java.util.List;

/**
 * Created by asus on 2017/11/8.
 */
public class RuanJian_ReMenPresenter implements PresenterInf {

    private ModelInf modelInf;
    private ViewInf3 viewInf;

    public RuanJian_ReMenPresenter(ReMenFragment reMenFragment) {
        this.modelInf = new MaYunTuiJianModel();
        this.viewInf = reMenFragment;
    }

    @Override
    public void ViewToModel() {
        modelInf.getData(handler);
    }
    Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            List<MaYunTuiJianBean.SoftwareBean> list = (List<MaYunTuiJianBean.SoftwareBean>) msg.obj;
            viewInf.updataUI(list);
        }
    };
}
