package com.example.kaiyuanzhongguo.Fragment.Zhu;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.kaiyuanzhongguo.Adapter.ZhongHeFragmentAdapter;
import com.example.kaiyuanzhongguo.Fragment.DongTan.EFragment;
import com.example.kaiyuanzhongguo.Fragment.DongTan.FFragment;
import com.example.kaiyuanzhongguo.Fragment.DongTan.GFragment;
import com.example.kaiyuanzhongguo.Fragment.DongTan.HFragment;
import com.example.kaiyuanzhongguo.R;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class DongTanFragment extends Fragment {


    private TabLayout tab2;
    private ViewPager vp2;

    public DongTanFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.fragment_dong_tan, container, false);
        initView(inflate);
        initData();
        return inflate;
    }

    private void initData() {
        List<String> stringList = new ArrayList<>();
        stringList.add("最新动弹");
        stringList.add("热门动弹");
        stringList.add("每日乱弹");
        stringList.add("我的动弹");

        List<Fragment> fragmentList = new ArrayList<>();
        fragmentList.add(new EFragment());
        fragmentList.add(new FFragment());
        fragmentList.add(new GFragment());
        fragmentList.add(new HFragment());

        ZhongHeFragmentAdapter adapter = new ZhongHeFragmentAdapter(getFragmentManager(),stringList,fragmentList);
        tab2.setupWithViewPager(vp2);
        vp2.setAdapter(adapter);
    }

    private void initView(View inflate) {
        tab2 = (TabLayout) inflate.findViewById(R.id.tab2);
        vp2 = (ViewPager) inflate.findViewById(R.id.vp2);
    }
}
