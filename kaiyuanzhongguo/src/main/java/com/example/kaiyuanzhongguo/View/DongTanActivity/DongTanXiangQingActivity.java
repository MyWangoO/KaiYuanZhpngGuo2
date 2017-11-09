package com.example.kaiyuanzhongguo.View.DongTanActivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.request.RequestOptions;
import com.example.kaiyuanzhongguo.R;

public class DongTanXiangQingActivity extends AppCompatActivity {

    private ImageView touxiang_xiangqing;
    private TextView biaoti_xiangqing;
    private TextView text_xiangqing;
    private TextView shijian_xiangqing;
    private TabLayout tab_xiangqing;
    private ViewPager vp_xiangqing;
    private Toolbar toolbar_xiangqing;
    private ImageView fengxiang_xiangqing;
    private String name;
    private String text;
    private String shijian;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dong_tan_xiang_qing);
        initView();
        initData();
    }

    private void initData() {
        Intent intent = getIntent();
        String touxiang = intent.getStringExtra("touxiang");
        name = intent.getStringExtra("name");
        text = intent.getStringExtra("text");
        shijian = intent.getStringExtra("shijian");

        biaoti_xiangqing.setText(name);
        text_xiangqing.setText(text);
        shijian_xiangqing.setText(shijian);
        Glide.with(this).load(touxiang).apply(RequestOptions.bitmapTransform(new CircleCrop())).into(touxiang_xiangqing);

    }

    private void initView() {
        touxiang_xiangqing = (ImageView) findViewById(R.id.touxiang_xiangqing);
        biaoti_xiangqing = (TextView) findViewById(R.id.biaoti_xiangqing);
        text_xiangqing = (TextView) findViewById(R.id.text_xiangqing);
        shijian_xiangqing = (TextView) findViewById(R.id.shijian_xiangqing);
        tab_xiangqing = (TabLayout) findViewById(R.id.tab_xiangqing);
        vp_xiangqing = (ViewPager) findViewById(R.id.vp_xiangqing);
        toolbar_xiangqing = (Toolbar) findViewById(R.id.toolbar_xiangqing);
        toolbar_xiangqing.setNavigationIcon(R.mipmap.ic_brows_back);
        toolbar_xiangqing.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        //第三方分享
        fengxiang_xiangqing = (ImageView) findViewById(R.id.fengxiang_xiangqing);
        fengxiang_xiangqing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent textIntent = new Intent(Intent.ACTION_SEND);
                textIntent.setType("text/plain");
                textIntent.putExtra(Intent.EXTRA_TEXT, name+":"+text+"--"+shijian);
                startActivity(Intent.createChooser(textIntent, "分享"));
            }
        });
    }
}
