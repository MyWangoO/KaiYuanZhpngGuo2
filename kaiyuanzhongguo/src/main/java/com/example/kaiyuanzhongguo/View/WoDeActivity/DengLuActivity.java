package com.example.kaiyuanzhongguo.View.WoDeActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.kaiyuanzhongguo.R;
import com.umeng.socialize.UMAuthListener;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.bean.SHARE_MEDIA;

import java.util.Map;

public class DengLuActivity extends AppCompatActivity implements View.OnClickListener {

    private Toolbar toolbar_denglu;
    private EditText zhanghao_denglu;
    private EditText mima_denglu;
    private TextView wangji_denglu;
    private TextView disanfang;
    private Button denglu_denglu;
    private Button zhuce_denglu;
    private ImageView qingchu1_denglu;
    private ImageView qingchu2_denglu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deng_lu2);
//        嵌入是状态栏
//        getWindow().setStatusBarColor(0xff24cf5f);
        initView();
        submit();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        UMShareAPI.get(this).onActivityResult(requestCode, resultCode, data);
    }

    private void initView() {
        toolbar_denglu = (Toolbar) findViewById(R.id.toolbar_denglu);
        zhanghao_denglu = (EditText) findViewById(R.id.zhanghao_denglu);
        mima_denglu = (EditText) findViewById(R.id.mima_denglu);
        wangji_denglu = (TextView) findViewById(R.id.wangji_denglu);
        disanfang = (TextView) findViewById(R.id.disanfang);
        denglu_denglu = (Button) findViewById(R.id.denglu_denglu);
        zhuce_denglu = (Button) findViewById(R.id.zhuce_denglu);

        denglu_denglu.setOnClickListener(this);
        zhuce_denglu.setOnClickListener(this);
        disanfang.setOnClickListener(this);

        toolbar_denglu.setNavigationIcon(R.mipmap.ic_brows_back);
        toolbar_denglu.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        qingchu1_denglu = (ImageView) findViewById(R.id.qingchu1_denglu);
        qingchu1_denglu.setOnClickListener(this);
        qingchu2_denglu = (ImageView) findViewById(R.id.qingchu2_denglu);
        qingchu2_denglu.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.denglu_denglu:
                SharedPreferences xinxi = getSharedPreferences("xinxi", 0);
                String zhanghao = xinxi.getString("zhanghao", "z");
                String mima = xinxi.getString("mima", "m");

                String s1 = zhanghao_denglu.getText().toString().trim();
                String s2 = mima_denglu.getText().toString().trim();

                if (s1.equals(zhanghao)&&s2.equals(mima)){
                    Toast.makeText(DengLuActivity.this, "账号密码正确", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(DengLuActivity.this, "账号密码不正确", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.zhuce_denglu:
                Intent intent = new Intent(this, ZhuCeActivity.class);
                startActivity(intent);
                break;
            case R.id.wangji_denglu:

                break;
            case R.id.disanfang:
                UMShareAPI.get(this).getPlatformInfo(this, SHARE_MEDIA.QQ, new UMAuthListener() {
                    @Override
                    public void onStart(SHARE_MEDIA share_media) {
                        Toast.makeText(DengLuActivity.this, "开始登陆", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onComplete(SHARE_MEDIA share_media, int i, Map<String, String> map) {
                        Toast.makeText(DengLuActivity.this, "成功", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onError(SHARE_MEDIA share_media, int i, Throwable throwable) {
                        Toast.makeText(DengLuActivity.this, "失败", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onCancel(SHARE_MEDIA share_media, int i) {
                        Toast.makeText(DengLuActivity.this, "取消", Toast.LENGTH_SHORT).show();
                    }
                });
                break;
            case R.id.qingchu1_denglu:
                zhanghao_denglu.setText("");
                break;
            case R.id.qingchu2_denglu:
                mima_denglu.setText("");
                break;
        }
    }

    private void submit() {
        zhanghao_denglu.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (charSequence.length() == 0){
                    qingchu1_denglu.setVisibility(View.GONE);
                }else {
                    qingchu1_denglu.setVisibility(View.VISIBLE);
                }
            }
            @Override
            public void afterTextChanged(Editable editable) {
            }
        });
        //获取输入框的实时监听
        mima_denglu.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                //判断是否藏毒为0
                if (charSequence.length() == 0) {
                    //设置控件为隐藏
                    qingchu2_denglu.setVisibility(View.GONE);
                }else {
                    //设置控件为显示
                    qingchu2_denglu.setVisibility(View.VISIBLE);
                }
                if (charSequence.length() != 0 && TextUtils.isEmpty(zhanghao_denglu.getText().toString())) {
                    //显示按钮
                    denglu_denglu.setEnabled(true);
                    Toast.makeText(DengLuActivity.this, "账号不能为空", Toast.LENGTH_SHORT).show();
                    denglu_denglu.setBackgroundDrawable(getResources().getDrawable(R.drawable.login_btn));
                } else {
                    //隐藏按钮
                    denglu_denglu.setEnabled(false);
                    denglu_denglu.setBackgroundDrawable(getResources().getDrawable(R.drawable.login_btn2));
                }
                if (charSequence.length() != 0 && !TextUtils.isEmpty(zhanghao_denglu.getText().toString())) {
                    denglu_denglu.setEnabled(true);
                    denglu_denglu.setBackgroundDrawable(getResources().getDrawable(R.drawable.login_btn));
//                    Toast.makeText(DengLuActivity.this, "成功", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

    }
}
