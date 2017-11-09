package com.example.kaiyuanzhongguo.View.FaXianActivity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.kaiyuanzhongguo.Adapter.KaiYuanRuanJianFragmentAdapter;
import com.example.kaiyuanzhongguo.Fragment.KaiYuanRuanJian.FenLeiFragment;
import com.example.kaiyuanzhongguo.Fragment.KaiYuanRuanJian.GuoCanFragment;
import com.example.kaiyuanzhongguo.Fragment.KaiYuanRuanJian.ReMenFragment;
import com.example.kaiyuanzhongguo.Fragment.KaiYuanRuanJian.TuiJianFragment;
import com.example.kaiyuanzhongguo.Fragment.KaiYuanRuanJian.ZuiXinFragment;
import com.example.kaiyuanzhongguo.R;

import java.util.ArrayList;
import java.util.List;

public class KaiYuanRuanJianActivity extends AppCompatActivity {

    private Toolbar tolbar_kaiyuan;
    private TabLayout tab_kaiyuan;
    private ViewPager vp_kaiyuan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kai_yuan_ruan_jian);
        initView();
        initData();
        initTab();
    }

    private void initTab() {
        List<String> stringList = new ArrayList<>();
        stringList.add("分类");
        stringList.add("推荐");
        stringList.add("最新");
        stringList.add("热门");
        stringList.add("国产");
        List<Fragment> fragmentList = new ArrayList<>();
        fragmentList.add(new FenLeiFragment());
        fragmentList.add(new TuiJianFragment());
        fragmentList.add(new ZuiXinFragment());
        fragmentList.add(new ReMenFragment());
        fragmentList.add(new GuoCanFragment());
        KaiYuanRuanJianFragmentAdapter adapter = new KaiYuanRuanJianFragmentAdapter(getSupportFragmentManager(),stringList,fragmentList);
        tab_kaiyuan.setupWithViewPager(vp_kaiyuan);
        vp_kaiyuan.setAdapter(adapter);
    }

    private void initData() {
        tolbar_kaiyuan.setTitle("代码片段");
        tolbar_kaiyuan.setNavigationIcon(R.mipmap.ic_brows_back);
        tolbar_kaiyuan.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    private void initView() {
        tolbar_kaiyuan = (Toolbar) findViewById(R.id.tolbar_kaiyuan);
        tab_kaiyuan = (TabLayout) findViewById(R.id.tab_kaiyuan);
        vp_kaiyuan = (ViewPager) findViewById(R.id.vp_kaiyuan);
    }
}
