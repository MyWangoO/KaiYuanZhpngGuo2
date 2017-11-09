package com.example.kaiyuanzhongguo.View.WoDeActivity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.kaiyuanzhongguo.R;

public class WenDaActivity extends AppCompatActivity {

    private Toolbar toolbar_wenda;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wen_da);
        initView();
    }

    private void initView() {
        toolbar_wenda = (Toolbar) findViewById(R.id.toolbar_wenda);

        toolbar_wenda.setTitle("消息中心");
        toolbar_wenda.setNavigationIcon(R.mipmap.ic_brows_back);
        toolbar_wenda.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
