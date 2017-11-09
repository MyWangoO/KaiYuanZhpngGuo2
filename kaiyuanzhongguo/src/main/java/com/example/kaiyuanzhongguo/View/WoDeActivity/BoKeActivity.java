package com.example.kaiyuanzhongguo.View.WoDeActivity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.kaiyuanzhongguo.R;

public class BoKeActivity extends AppCompatActivity {

    private Toolbar toolbar_boke;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bo_ke);
        initView();
    }

    private void initView() {
        toolbar_boke = (Toolbar) findViewById(R.id.toolbar_boke);

        toolbar_boke.setTitle("用户博客列表");
        toolbar_boke.setNavigationIcon(R.mipmap.ic_brows_back);
        toolbar_boke.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
