package com.example.kaiyuanzhongguo.Presenter;

import android.os.Handler;
import android.os.Message;

import com.example.kaiyuanzhongguo.Bean.MaYunTuiJianBean;
import com.example.kaiyuanzhongguo.Model.MaYunTuiJianModel;
import com.example.kaiyuanzhongguo.Model.ModelInf;
import com.example.kaiyuanzhongguo.View.FaXianActivity.MaYunTuiJianActivity;
import com.example.kaiyuanzhongguo.View.ViewInf.ViewInf3;

import java.util.List;

/**
 * Created by asus on 2017/11/6.
 */
public class MaYunTuiJianPresenter implements PresenterInf {
    private ModelInf modelInf;
    private ViewInf3 viewInf;
    public MaYunTuiJianPresenter(MaYunTuiJianActivity maYunTuiJianActivity){
        modelInf = new MaYunTuiJianModel();
        viewInf = maYunTuiJianActivity;
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
