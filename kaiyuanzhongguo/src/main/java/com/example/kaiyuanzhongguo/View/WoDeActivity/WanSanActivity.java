package com.example.kaiyuanzhongguo.View.WoDeActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.kaiyuanzhongguo.R;

public class WanSanActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView zhanghao_wansan;
    private EditText mima_wansan;
    private Button queding_wansan;
    private String shoujihao;
    private String miam;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wan_san);
        initView();

        Intent intent = getIntent();
        shoujihao = intent.getStringExtra("shoujihao");
        zhanghao_wansan.setText(shoujihao);
        miam = mima_wansan.getText().toString().trim();
    }

    private void initView() {
        zhanghao_wansan = (TextView) findViewById(R.id.zhanghao_wansan);
        mima_wansan = (EditText) findViewById(R.id.mima_wansan);
        queding_wansan = (Button) findViewById(R.id.queding_wansan);

        queding_wansan.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.queding_wansan:
                SharedPreferences xinxi = getSharedPreferences("xinxi", 0);
                SharedPreferences.Editor edit = xinxi.edit();
                edit.putString("zhanghao",shoujihao);
                edit.putString("mima",miam);
                edit.commit();
                finish();
                break;
        }
    }

    private void submit() {
        // validate
        String zhanghao = zhanghao_wansan.getText().toString().trim();
        if (TextUtils.isEmpty(zhanghao)) {
            Toast.makeText(this, "账号", Toast.LENGTH_SHORT).show();
            return;
        }


        if (TextUtils.isEmpty(miam)) {
            Toast.makeText(this, "密码", Toast.LENGTH_SHORT).show();
            return;
        }

        // TODO validate success, do something


    }
}
