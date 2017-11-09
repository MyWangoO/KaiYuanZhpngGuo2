package com.example.kaiyuanzhongguo.Presenter;

import android.os.Handler;
import android.os.Message;

import com.example.kaiyuanzhongguo.Bean.MaYunTuiJianBean;
import com.example.kaiyuanzhongguo.Fragment.KaiYuanRuanJian.TuiJianFragment;
import com.example.kaiyuanzhongguo.Model.MaYunTuiJianModel;
import com.example.kaiyuanzhongguo.Model.ModelInf;
import com.example.kaiyuanzhongguo.View.ViewInf.ViewInf3;

import java.util.List;

/**
 * Created by asus on 2017/11/8.
 */
public class RuanJian_TuiJianPresenter implements PresenterInf {

    private ModelInf modelInf;
    private ViewInf3 viewInf;

    public RuanJian_TuiJianPresenter(TuiJianFragment tuiJianFragment) {
        this.modelInf = new MaYunTuiJianModel();
        this.viewInf = tuiJianFragment;
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
