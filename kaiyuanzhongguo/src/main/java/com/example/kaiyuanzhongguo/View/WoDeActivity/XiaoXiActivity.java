package com.example.kaiyuanzhongguo.View.WoDeActivity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.kaiyuanzhongguo.Adapter.WoDeXiaoXiFragmentAdapter;
import com.example.kaiyuanzhongguo.Fragment.WoDeXiaoXi.PingLunFragment;
import com.example.kaiyuanzhongguo.Fragment.WoDeXiaoXi.SiXinFragment;
import com.example.kaiyuanzhongguo.Fragment.WoDeXiaoXi.WoFragment;
import com.example.kaiyuanzhongguo.R;

import java.util.ArrayList;
import java.util.List;

public class XiaoXiActivity extends AppCompatActivity {

    private TabLayout tab_xiaoxifenye;
    private ViewPager vp_xiaoxifenye;
    private Toolbar toolbar_xiaoxi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xiao_xi);
        initView();
        initData();
    }

    private void initData() {
        List<String> stringList = new ArrayList<>();
        stringList.add("@我");
        stringList.add("评论");
        stringList.add("私信");
        List<Fragment> fragmentList = new ArrayList<>();
        fragmentList.add(new WoFragment());
        fragmentList.add(new PingLunFragment());
        fragmentList.add(new SiXinFragment());
        WoDeXiaoXiFragmentAdapter adapter = new WoDeXiaoXiFragmentAdapter(getSupportFragmentManager(), stringList, fragmentList);
        tab_xiaoxifenye.setupWithViewPager(vp_xiaoxifenye);
        vp_xiaoxifenye.setAdapter(adapter);
    }

    private void initView() {
        tab_xiaoxifenye = (TabLayout) findViewById(R.id.tab_xiaoxifenye);
        vp_xiaoxifenye = (ViewPager) findViewById(R.id.vp_xiaoxifenye);
        toolbar_xiaoxi = (Toolbar) findViewById(R.id.toolbar_xiaoxi);

        toolbar_xiaoxi.setTitle("消息中心");
        toolbar_xiaoxi.setNavigationIcon(R.mipmap.ic_brows_back);
        toolbar_xiaoxi.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
