package com.example.kaiyuanzhongguo.Fragment.Zhu;


import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.example.kaiyuanzhongguo.Adapter.ZhongHeFragmentAdapter;
import com.example.kaiyuanzhongguo.Fragment.ZhongHe.AFragment;
import com.example.kaiyuanzhongguo.Fragment.ZhongHe.BFragment;
import com.example.kaiyuanzhongguo.Fragment.ZhongHe.CFragment;
import com.example.kaiyuanzhongguo.Fragment.ZhongHe.DFragment;
import com.example.kaiyuanzhongguo.R;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class ZhongHeFragment extends Fragment {


    private TextView tianjia;
    private ViewPager vp1;
    private TabLayout tab1;
    private View v;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.fragment_zhong_he, container, false);
        initView(inflate);
        initData();
        return inflate;
    }

    private void initData() {
        List<String> stringList = new ArrayList<>();
        stringList.add("开源资讯");
        stringList.add("推荐博客");
        stringList.add("技术问答");
        stringList.add("每日一搏");
        List<Fragment> fragmentList = new ArrayList<>();
        fragmentList.add(new AFragment());
        fragmentList.add(new BFragment());
        fragmentList.add(new CFragment());
        fragmentList.add(new DFragment());

        ZhongHeFragmentAdapter adapter = new ZhongHeFragmentAdapter(getFragmentManager(),stringList,fragmentList);
        tab1.setupWithViewPager(vp1);
        vp1.setAdapter(adapter);
    }

    private void initView(View inflate) {
        tianjia = (TextView) inflate.findViewById(R.id.tianjia);
        tab1 = inflate.findViewById(R.id.tab1);
        vp1 = (ViewPager) inflate.findViewById(R.id.vp1);

        tianjia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //显示popuwindow
                v = LayoutInflater.from(getActivity()).inflate(R.layout.tianjia, null);
                //创建一个popuwindow对象
                PopupWindow popu = new PopupWindow(v, ViewGroup.LayoutParams.MATCH_PARENT, 300);
                //默认获取不到焦点，设置获取焦点
                popu.setFocusable(true);
                //点击窗口以外区域，窗口消失
                popu.setBackgroundDrawable(new BitmapDrawable());
                //弹出或者消失的时候带动画效果
//                popu.setAnimationStyle(R.style.mypopu);
                //显示popuwindow
                popu.showAtLocation(v, Gravity.BOTTOM, 0, 0);
            }
        });
    }
}
