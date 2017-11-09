package com.example.kaiyuanzhongguo.View.WoDeActivity;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;

import com.example.kaiyuanzhongguo.R;

public class SheZhiActivity extends AppCompatActivity implements View.OnClickListener {

    private Toolbar shezhi_toolbar;
    private LinearLayout shezhi_qingchu;
    private TextView shezhi_tuichu;
    private ImageView shezhi_qiehuan;
    private TextView shezhi_yijian;
    private TextView shezhi_guanyu;
    private TextView shezhi_gengxin;
    private TextView shezhi_zhuxiao;
    private TextView shezhi_shuju;
    private Switch switch1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_she_zhi);
        initView();
        initToolbar();
        initDianJi();
    }

    private void initToolbar() {
        shezhi_toolbar.setTitle("设置");
        shezhi_toolbar.setNavigationIcon(R.mipmap.ic_brows_back);
        shezhi_toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    private void initView() {
        shezhi_toolbar = (Toolbar) findViewById(R.id.shezhi_toolbar);
        shezhi_qingchu = (LinearLayout) findViewById(R.id.shezhi_qingchu);
        shezhi_tuichu = (TextView) findViewById(R.id.shezhi_tuichu);
        shezhi_yijian = (TextView) findViewById(R.id.shezhi_yijian);
        shezhi_guanyu = (TextView) findViewById(R.id.shezhi_guanyu);
        shezhi_gengxin = (TextView) findViewById(R.id.shezhi_gengxin);
        shezhi_zhuxiao = (TextView) findViewById(R.id.shezhi_zhuxiao);
        shezhi_shuju = (TextView) findViewById(R.id.shezhi_shuju);
        switch1 = (Switch) findViewById(R.id.switch1);

    }

    private void initDianJi() {
        shezhi_qingchu.setOnClickListener(this);
        shezhi_tuichu.setOnClickListener(this);
        shezhi_yijian.setOnClickListener(this);
        shezhi_guanyu.setOnClickListener(this);
        shezhi_gengxin.setOnClickListener(this);
        shezhi_zhuxiao.setOnClickListener(this);
        switch1.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.shezhi_qingchu:
                Dialog dialog = new AlertDialog.Builder(this)
                        .setMessage("是否清空缓存")
                        .setPositiveButton("取消", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                finish();
                            }
                        })
                        .setNegativeButton("确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                shezhi_shuju.setText("0.00KB");
                            }
                        })
                        .create();
                dialog.show();
                break;
            case R.id.shezhi_tuichu:
                break;
            case R.id.switch1:
                switch1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                    }
                });
                break;
            case R.id.shezhi_yijian:
                break;
            case R.id.shezhi_guanyu:
                break;
            case R.id.shezhi_gengxin:
                break;
            case R.id.shezhi_zhuxiao:
                break;
        }
    }
}
