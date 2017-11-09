package com.example.kaiyuanzhongguo.Fragment.Zhu;


import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.example.kaiyuanzhongguo.R;
import com.example.kaiyuanzhongguo.View.WoDeActivity.BoKeActivity;
import com.example.kaiyuanzhongguo.View.WoDeActivity.DengLuActivity;
import com.example.kaiyuanzhongguo.View.WoDeActivity.DongTanActivity;
import com.example.kaiyuanzhongguo.View.WoDeActivity.FenSiActivity;
import com.example.kaiyuanzhongguo.View.WoDeActivity.GuanZhuActivity;
import com.example.kaiyuanzhongguo.View.WoDeActivity.HuoDongActivity;
import com.example.kaiyuanzhongguo.View.WoDeActivity.SheZhiActivity;
import com.example.kaiyuanzhongguo.View.WoDeActivity.ShouCangActivity;
import com.example.kaiyuanzhongguo.View.WoDeActivity.TuanDuiActivity;
import com.example.kaiyuanzhongguo.View.WoDeActivity.WenDaActivity;
import com.example.kaiyuanzhongguo.View.WoDeActivity.XiaoXiActivity;
import com.example.kaiyuanzhongguo.View.WoDeActivity.ZiLiaoActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class WoDeFragment extends Fragment implements View.OnClickListener {


    private ImageView shezhi_wode;
    private ImageView erweima_wode;
    private TextView name_wode;
    private LinearLayout touxiang_wode;
    private TextView dongtan_wode;
    private TextView shoucang_wode;
    private TextView guanzhu_wode;
    private TextView fensi_wode;
    private LinearLayout xiaoxi_wode;
    private LinearLayout ziliao_wode;
    private LinearLayout boke_wode;
    private LinearLayout wenda_wode;
    private LinearLayout huodong_wode;
    private LinearLayout tuandui_wode;
    private LinearLayout liner_wode;

    public WoDeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.fragment_wo_de, container, false);
        initView(inflate);
        initDianJi();
        return inflate;
    }

    private void initView(View inflate) {
        shezhi_wode = (ImageView) inflate.findViewById(R.id.shezhi_wode);
        erweima_wode = (ImageView) inflate.findViewById(R.id.erweima_wode);
        name_wode = (TextView) inflate.findViewById(R.id.name_wode);
        touxiang_wode = (LinearLayout) inflate.findViewById(R.id.touxiang_wode);
        dongtan_wode = (TextView) inflate.findViewById(R.id.dongtan_wode);
        shoucang_wode = (TextView) inflate.findViewById(R.id.shoucang_wode);
        guanzhu_wode = (TextView) inflate.findViewById(R.id.guanzhu_wode);
        fensi_wode = (TextView) inflate.findViewById(R.id.fensi_wode);
        xiaoxi_wode = (LinearLayout) inflate.findViewById(R.id.xiaoxi_wode);
        ziliao_wode = (LinearLayout) inflate.findViewById(R.id.ziliao_wode);
        boke_wode = (LinearLayout) inflate.findViewById(R.id.boke_wode);
        wenda_wode = (LinearLayout) inflate.findViewById(R.id.wenda_wode);
        huodong_wode = (LinearLayout) inflate.findViewById(R.id.huodong_wode);
        tuandui_wode = (LinearLayout) inflate.findViewById(R.id.tuandui_wode);


        liner_wode = (LinearLayout) inflate.findViewById(R.id.liner_wode);
    }

    private void initDianJi() {
        shezhi_wode.setOnClickListener(this);
        erweima_wode.setOnClickListener(this);
        name_wode.setOnClickListener(this);
        touxiang_wode.setOnClickListener(this);
        dongtan_wode.setOnClickListener(this);
        shoucang_wode.setOnClickListener(this);
        guanzhu_wode.setOnClickListener(this);
        fensi_wode.setOnClickListener(this);
        xiaoxi_wode.setOnClickListener(this);
        ziliao_wode.setOnClickListener(this);
        boke_wode.setOnClickListener(this);
        wenda_wode.setOnClickListener(this);
        huodong_wode.setOnClickListener(this);
        tuandui_wode.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.shezhi_wode:
                Intent intent1 = new Intent(getActivity(), SheZhiActivity.class);
                startActivity(intent1);
                break;
            case R.id.erweima_wode:
                View inflate = LayoutInflater.from(getActivity()).inflate(R.layout.erweima, null);
                PopupWindow popupWindow = new PopupWindow(inflate, ViewGroup.LayoutParams.MATCH_PARENT, 500);
                popupWindow.setFocusable(true);
                popupWindow.setBackgroundDrawable(new BitmapDrawable());
                popupWindow.showAtLocation(liner_wode, Gravity.CENTER,0,0);
                break;
            case R.id.name_wode:
                break;
            case R.id.touxiang_wode:
                Intent intent2 = new Intent(getActivity(), DengLuActivity.class);
                startActivity(intent2);
                break;
            case R.id.dongtan_wode:
                Intent intent3 = new Intent(getActivity(), DongTanActivity.class);
                startActivity(intent3);
                break;
            case R.id.shoucang_wode:
                Intent intent4 = new Intent(getActivity(), ShouCangActivity.class);
                startActivity(intent4);
                break;
            case R.id.guanzhu_wode:
                Intent intent5 = new Intent(getActivity(), GuanZhuActivity.class);
                startActivity(intent5);
                break;
            case R.id.fensi_wode:
                Intent intent6 = new Intent(getActivity(), FenSiActivity.class);
                startActivity(intent6);
                break;
            case R.id.xiaoxi_wode:
                Intent intent7 = new Intent(getActivity(), XiaoXiActivity.class);
                startActivity(intent7);
                break;
            case R.id.ziliao_wode:
                Intent intent8 = new Intent(getActivity(), ZiLiaoActivity.class);
                startActivity(intent8);
                break;
            case R.id.boke_wode:
                Intent intent9 = new Intent(getActivity(), BoKeActivity.class);
                startActivity(intent9);
                break;
            case R.id.wenda_wode:
                Intent intent10 = new Intent(getActivity(), WenDaActivity.class);
                startActivity(intent10);
                break;
            case R.id.huodong_wode:
                Intent intent11 = new Intent(getActivity(), HuoDongActivity.class);
                startActivity(intent11);
                break;
            case R.id.tuandui_wode:
                Intent intent12 = new Intent(getActivity(), TuanDuiActivity.class);
                startActivity(intent12);
                break;
        }
    }
}
