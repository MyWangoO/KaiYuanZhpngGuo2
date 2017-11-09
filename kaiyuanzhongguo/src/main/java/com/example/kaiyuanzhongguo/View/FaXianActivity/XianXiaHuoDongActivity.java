package com.example.kaiyuanzhongguo.View.FaXianActivity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ListView;

import com.example.kaiyuanzhongguo.R;

public class XianXiaHuoDongActivity extends AppCompatActivity {

    private Toolbar toolbar_xianxia;
    private ListView lv_xianxia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xian_xia_huo_dong);
        initView();
    }

    private void initView() {
        toolbar_xianxia = (Toolbar) findViewById(R.id.toolbar_xianxia);
        lv_xianxia = (ListView) findViewById(R.id.lv_xianxia);

        toolbar_xianxia.setTitle("线下活动");
        toolbar_xianxia.setNavigationIcon(R.mipmap.ic_brows_back);
        toolbar_xianxia.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
