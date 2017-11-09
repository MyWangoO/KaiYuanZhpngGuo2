package com.example.kaiyuanzhongguo.View.WoDeActivity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.kaiyuanzhongguo.R;

public class TuanDuiActivity extends AppCompatActivity {

    private Toolbar toolbar_tuandui;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tuan_dui);
        initView();
    }

    private void initView() {
        toolbar_tuandui = (Toolbar) findViewById(R.id.toolbar_tuandui);

        toolbar_tuandui.setTitle("v");
        toolbar_tuandui.setNavigationIcon(R.mipmap.ic_brows_back);
        toolbar_tuandui.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
