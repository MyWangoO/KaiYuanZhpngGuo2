package com.example.kaiyuanzhongguo.View.WoDeActivity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.kaiyuanzhongguo.R;

public class ZiLiaoActivity extends AppCompatActivity {

    private Toolbar toolbar_ziliao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zi_liao);
        initView();
    }

    private void initView() {
        toolbar_ziliao = (Toolbar) findViewById(R.id.toolbar_ziliao);

        toolbar_ziliao.setTitle("我的资料");
        toolbar_ziliao.setNavigationIcon(R.mipmap.ic_brows_back);
        toolbar_ziliao.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
