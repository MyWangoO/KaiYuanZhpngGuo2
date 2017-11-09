package com.example.kaiyuanzhongguo.View.FaXianActivity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ListView;

import com.example.kaiyuanzhongguo.Adapter.MaYuTuiJianAdapter;
import com.example.kaiyuanzhongguo.Bean.MaYunTuiJianBean;
import com.example.kaiyuanzhongguo.Presenter.MaYunTuiJianPresenter;
import com.example.kaiyuanzhongguo.Presenter.PresenterInf;
import com.example.kaiyuanzhongguo.R;
import com.example.kaiyuanzhongguo.View.ViewInf.ViewInf3;

import java.util.List;

public class MaYunTuiJianActivity extends AppCompatActivity implements ViewInf3{

    private Toolbar tolbar_mayun;
    private ListView lv_mayun;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ma_yun_tui_jian);
        initView();
        initData();
        PresenterInf presenterInf = new MaYunTuiJianPresenter(this);
        presenterInf.ViewToModel();
    }

    private void initData() {
        tolbar_mayun.setTitle("码云推荐");
        tolbar_mayun.setNavigationIcon(R.mipmap.ic_brows_back);
        tolbar_mayun.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }

    private void initView() {
        tolbar_mayun = (Toolbar) findViewById(R.id.tolbar_mayun);
        lv_mayun = (ListView) findViewById(R.id.lv_mayun);
    }

    @Override
    public void updataUI(List<MaYunTuiJianBean.SoftwareBean> list) {
        MaYuTuiJianAdapter adapter = new MaYuTuiJianAdapter(list,this);
        lv_mayun.setAdapter(adapter);
    }
}
