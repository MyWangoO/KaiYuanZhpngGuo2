package com.example.kaiyuanzhongguo.Fragment.Zhu;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.kaiyuanzhongguo.R;
import com.example.kaiyuanzhongguo.View.FaXianActivity.DaiMaPianDuanActivity;
import com.example.kaiyuanzhongguo.View.FaXianActivity.FuJinDeActivity;
import com.example.kaiyuanzhongguo.View.FaXianActivity.KaiYuanRuanJianActivity;
import com.example.kaiyuanzhongguo.View.FaXianActivity.MaYunTuiJianActivity;
import com.example.kaiyuanzhongguo.View.FaXianActivity.XianXiaHuoDongActivity;
import com.example.kaiyuanzhongguo.View.FaXianActivity.YaoYiYaoActivity;
import com.example.kaiyuanzhongguo.zxing.activity.CaptureActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class FaXianFragment extends Fragment implements View.OnClickListener {


    private LinearLayout mayun;
    private LinearLayout ruanjian;
    private LinearLayout pianduan;
    private LinearLayout saoyisao;
    private LinearLayout yaoyiyao;
    private LinearLayout fujin;
    private LinearLayout xianxia;

    public FaXianFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.fragment_fa_xian, container, false);
        initView(inflate);
        initData();
        return inflate;
    }

    private void initData() {
        mayun.setOnClickListener(this);
        ruanjian.setOnClickListener(this);
        pianduan.setOnClickListener(this);
        saoyisao.setOnClickListener(this);
        fujin.setOnClickListener(this);
        xianxia.setOnClickListener(this);
        yaoyiyao.setOnClickListener(this);
    }

    private void initView(View inflate) {
        mayun = (LinearLayout) inflate.findViewById(R.id.mayun);
        ruanjian = (LinearLayout) inflate.findViewById(R.id.ruanjian);
        pianduan = (LinearLayout) inflate.findViewById(R.id.pianduan);
        saoyisao = (LinearLayout) inflate.findViewById(R.id.saoyisao);
        yaoyiyao = (LinearLayout) inflate.findViewById(R.id.yaoyiyao);
        fujin = (LinearLayout) inflate.findViewById(R.id.fujin);
        xianxia = (LinearLayout) inflate.findViewById(R.id.xianxia);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.mayun:
                Intent intent1 = new Intent(getActivity(), MaYunTuiJianActivity.class);
                startActivity(intent1);
                break;
            case R.id.ruanjian:
                Intent intent2 = new Intent(getActivity(), KaiYuanRuanJianActivity.class);
                startActivity(intent2);
                break;
            case R.id.pianduan:
                Intent intent3 = new Intent(getActivity(), DaiMaPianDuanActivity.class);
                startActivity(intent3);
                break;
            case R.id.saoyisao:
                startActivity(new Intent(getActivity(), CaptureActivity.class));
                break;
            case R.id.yaoyiyao:
                Intent intent5 = new Intent(getActivity(), YaoYiYaoActivity.class);
                startActivity(intent5);
                break;
            case R.id.fujin:
                Intent intent6 = new Intent(getActivity(), FuJinDeActivity.class);
                startActivity(intent6);
                break;
            case R.id.xianxia:
                Intent intent7 = new Intent(getActivity(), XianXiaHuoDongActivity.class);
                startActivity(intent7);
                break;
        }
    }
}
