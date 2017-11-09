package com.example.kaiyuanzhongguo.View.WoDeActivity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.kaiyuanzhongguo.R;

public class HuoDongActivity extends AppCompatActivity {

    private Toolbar toolbar_huodong;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_huo_dong);
        initView();
    }

    private void initView() {
        toolbar_huodong = (Toolbar) findViewById(R.id.toolbar_huodong);

        toolbar_huodong.setTitle("我的活动");
        toolbar_huodong.setNavigationIcon(R.mipmap.ic_brows_back);
        toolbar_huodong.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
