package com.example.kaiyuanzhongguo.Fragment.KaiYuanRuanJian;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.kaiyuanzhongguo.Adapter.RuanJian_FenLeiAdapter;
import com.example.kaiyuanzhongguo.R;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class FenLeiFragment extends Fragment {


    private ListView lv_kaiyuanruanjian_fenlei;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.fragment_fen_lei, container, false);
        initView(inflate);
        initData();
        return inflate;
    }

    private void initData() {
        List<String> list = new ArrayList<>();
        list.add("编程语言");
        list.add("Web应用开发");
        list.add("手机/移动开发");
        list.add("iOS代码库");
        list.add("程序开发");
        list.add("开发工具");
        list.add("jQuery插件");
        list.add("建站系统");
        list.add("企业应用");
        list.add("编程语言");
        list.add("服务器软件");
        list.add("数据库相关");
        list.add("应用工具");
        list.add("插件扩展");
        list.add("游戏娱乐");
        list.add("管理和监控");
        list.add("其他开源");

        RuanJian_FenLeiAdapter adapter = new RuanJian_FenLeiAdapter(getActivity(),list);
        lv_kaiyuanruanjian_fenlei.setAdapter(adapter);
    }

    private void initView(View inflate) {
        lv_kaiyuanruanjian_fenlei = (ListView) inflate.findViewById(R.id.lv_kaiyuanruanjian_fenlei);
    }
}
