package com.example.kaiyuanzhongguo.View.FaXianActivity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ListView;

import com.example.kaiyuanzhongguo.Adapter.DaiMaPianDuanLVAdapter;
import com.example.kaiyuanzhongguo.Bean.DaiMaPianDuanBean;
import com.example.kaiyuanzhongguo.Presenter.DaiMaPianDuanPresenter;
import com.example.kaiyuanzhongguo.R;
import com.example.kaiyuanzhongguo.View.ViewInf.ViewInf4;

import java.util.List;

public class DaiMaPianDuanActivity extends AppCompatActivity implements ViewInf4{

    private Toolbar tolbar_pianduan;
    private ListView lv_pianduan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dai_ma_pian_duan);
        initView();
        initData();

        DaiMaPianDuanPresenter presenter = new DaiMaPianDuanPresenter(this);
        presenter.ViewToModel();
    }
    private void initData() {
        tolbar_pianduan.setTitle("代码片段");
        tolbar_pianduan.setNavigationIcon(R.mipmap.ic_brows_back);
        tolbar_pianduan.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    private void initView() {
        tolbar_pianduan = (Toolbar) findViewById(R.id.tolbar_pianduan);
        lv_pianduan = (ListView) findViewById(R.id.lv_pianduan);
    }

    @Override
    public void updateUI(List<DaiMaPianDuanBean.TweetBean> list) {
        DaiMaPianDuanLVAdapter adapter = new DaiMaPianDuanLVAdapter(this,list);
        lv_pianduan.setAdapter(adapter                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            );
    }
}
