package com.example.kaiyuanzhongguo.View.ZhongHeActivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.example.kaiyuanzhongguo.R;

public class ZiXunXiangQingActivity extends AppCompatActivity {

    private Toolbar toolbar_zixunxiangqing;
    private TextView title_zixunxiangqing;
    private TextView name_zixunxiangqing;
    private TextView shijian_zixunxiangqing;
    private TextView text_zixunxiangqing;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zhong_he_tiao_zhuan);
        initView();
        initData();
    }

    private void initData() {
        Intent intent = getIntent();
        String title = intent.getStringExtra("title");
        String name = intent.getStringExtra("name");
        String shijian = intent.getStringExtra("shijian");
        String text = intent.getStringExtra("text");

        title_zixunxiangqing.setText(title);
        name_zixunxiangqing.setText(name);
        shijian_zixunxiangqing.setText(shijian);
        text_zixunxiangqing.setText(text);
    }

    private void initView() {
        toolbar_zixunxiangqing = (Toolbar) findViewById(R.id.toolbar_zixunxiangqing);
        title_zixunxiangqing = (TextView) findViewById(R.id.title_zixunxiangqing);
        name_zixunxiangqing = (TextView) findViewById(R.id.name_zixunxiangqing);
        shijian_zixunxiangqing = (TextView) findViewById(R.id.shijian_zixunxiangqing);
        text_zixunxiangqing = (TextView) findViewById(R.id.text_zixunxiangqing);

        toolbar_zixunxiangqing.setTitle("资讯详情");
        toolbar_zixunxiangqing.setNavigationIcon(R.mipmap.ic_brows_back);
        toolbar_zixunxiangqing.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
