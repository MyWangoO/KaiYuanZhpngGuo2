package com.example.kaiyuanzhongguo.View;

import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.kaiyuanzhongguo.Fragment.Zhu.DongTanFragment;
import com.example.kaiyuanzhongguo.Fragment.Zhu.FaXianFragment;
import com.example.kaiyuanzhongguo.Fragment.Zhu.WoDeFragment;
import com.example.kaiyuanzhongguo.Fragment.Zhu.ZhongHeFragment;
import com.example.kaiyuanzhongguo.R;

public class HomeActivity extends AppCompatActivity {

    private RelativeLayout rl;
    private FrameLayout fragelayout;
    private RadioButton zhonghe;
    private RadioButton dongtan;
    private ImageView tanchu;
    private RadioButton faxian;
    private RadioButton wode;
    private TextView biaoti;
    private ImageView shoushuo;
    private RelativeLayout tab;
    private View v;

    private RadioGroup rg;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        initView();
    }

    private void initView() {
        rl = (RelativeLayout) findViewById(R.id.tab);
        fragelayout = (FrameLayout) findViewById(R.id.fragelayout);
        zhonghe = (RadioButton) findViewById(R.id.zhonghe);
        dongtan = (RadioButton) findViewById(R.id.dongtan);
        tanchu = (ImageView) findViewById(R.id.tanchu);
        faxian = (RadioButton) findViewById(R.id.faxian);
        wode = (RadioButton) findViewById(R.id.wode);
        biaoti = (TextView) findViewById(R.id.biaoti);
        shoushuo = (ImageView) findViewById(R.id.shoushuo);
        rg = (RadioGroup) findViewById(R.id.rg1);

        tanchu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                initTanChu();
            }
        });

        //填充Fragment
        //获取Fragment管理类对象
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        //开启一个事物
        FragmentTransaction fragmentTransaction = supportFragmentManager.beginTransaction();
        //添加Fragment
//        supportFragmentManager.beginTransaction().add(R.id.fragelayout, new ZhongHeFragment()).commit();

        final ZhongHeFragment zhongHeFragment = new ZhongHeFragment();
        final DongTanFragment dongTanFragment = new DongTanFragment();
        final FaXianFragment faXianFragment = new FaXianFragment();
        final WoDeFragment woDeFragment = new WoDeFragment();
        fragmentTransaction.add(R.id.fragelayout, zhongHeFragment);
        fragmentTransaction.add(R.id.fragelayout, dongTanFragment);
        fragmentTransaction.add(R.id.fragelayout, faXianFragment);
        fragmentTransaction.add(R.id.fragelayout, woDeFragment);
        fragmentTransaction.show(zhongHeFragment).hide(dongTanFragment).hide(faXianFragment).hide(woDeFragment);
        //开启
        fragmentTransaction.commit();

        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                //获取Fragment管理类对象
                FragmentManager supportFragmentManager = getSupportFragmentManager();
                //开启一个事物
                FragmentTransaction fragmentTransaction = supportFragmentManager.beginTransaction();
                //底部切换
                switch (i) {
                    case R.id.zhonghe:
                        fragmentTransaction.show(zhongHeFragment).hide(dongTanFragment).hide(faXianFragment).hide(woDeFragment);
//                        supportFragmentManager.beginTransaction().replace(R.id.fragelayout, new ZhongHeFragment()).commit();
                        //显示控件
                        biaoti.setVisibility(View.VISIBLE);
                        shoushuo.setVisibility(View.VISIBLE);
                        biaoti.setText("综合");
                        break;
                    case R.id.dongtan:
                        fragmentTransaction.show(dongTanFragment).hide(zhongHeFragment).hide(faXianFragment).hide(woDeFragment);
//                        supportFragmentManager.beginTransaction().replace(R.id.fragelayout, new DongTanFragment()).commit();
                        biaoti.setVisibility(View.VISIBLE);
                        shoushuo.setVisibility(View.VISIBLE);
                        biaoti.setText("动弹");
                        break;
                    case R.id.faxian:
                        fragmentTransaction.show(faXianFragment).hide(zhongHeFragment).hide(dongTanFragment).hide(woDeFragment);
//                        supportFragmentManager.beginTransaction().replace(R.id.fragelayout, new FaXianFragment()).commit();
                        biaoti.setVisibility(View.VISIBLE);
                        shoushuo.setVisibility(View.VISIBLE);
                        biaoti.setText("发现");
                        break;
                    case R.id.wode:
                        fragmentTransaction.show(woDeFragment).hide(zhongHeFragment).hide(dongTanFragment).hide(faXianFragment);
//                        supportFragmentManager.beginTransaction().replace(R.id.fragelayout, new WoDeFragment()).commit();
                        //隐藏控件
                        biaoti.setVisibility(View.INVISIBLE);
                        shoushuo.setVisibility(View.INVISIBLE);
                        break;
                }
                fragmentTransaction.commit();
            }
        });

        shoushuo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this, SouSuoActivity.class);
                startActivity(intent);
            }
        });

    }

    private void initTanChu() {
        //控件旋转130度
        tanchu.animate().rotation(130);
        //获取背景
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        //背景颜色设置0.5透明度
        attributes.alpha = 0.5f;
        getWindow().setAttributes(attributes);
        //显示popuwindow
        v = LayoutInflater.from(HomeActivity.this).inflate(R.layout.tanchu, null);
        //创建一个popuwindow对象
        PopupWindow popu = new PopupWindow(v, ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        //默认获取不到焦点，设置获取焦点
        popu.setFocusable(true);
//        popu.setTouchable(true);
        //点击窗口以外区域，窗口消失
        popu.setBackgroundDrawable(new BitmapDrawable());
        //弹出或者消失的时候带动画效果
        //popu.setAnimationStyle(R.style.mypopu);
        popu.showAtLocation(rg, Gravity.BOTTOM, 0, 0);

        //PopupWindow销毁
        popu.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                WindowManager.LayoutParams attributes = getWindow().getAttributes();
                attributes.alpha = 1.0f;
                getWindow().setAttributes(attributes);
                tanchu.animate().rotation(-90);
            }
        });
    }
}
