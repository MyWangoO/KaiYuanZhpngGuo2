package com.example.kaiyuanzhongguo.View.WoDeActivity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.kaiyuanzhongguo.R;

import cn.smssdk.EventHandler;
import cn.smssdk.SMSSDK;

public class ZhuCeActivity extends AppCompatActivity implements View.OnClickListener {

    private Toolbar toolbar_denglu;
    private TextView huoquyanzhengma;
    private Button zhuce_zhuce;
    private EventHandler eventHandler;
    private EditText shoujihao_zhuce;
    private EditText yanzhengma_zhuce;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zhu_ce);
        initView();
        // 如果希望在读取通信录的时候提示用户，可以添加下面的代码，并且必须在其他代码调用之前，否则不起作用；如果没这个需求，可以不加这行代码
        // SMSSDK.setAskPermisionOnReadContact(boolShowInDialog)

        // 创建EventHandler对象
        eventHandler = new EventHandler() {
            public void afterEvent(int event, int result, Object data) {
                if (data instanceof Throwable) {
                    Throwable throwable = (Throwable) data;
                    final String msg = throwable.getMessage();
                    Log.i("login", msg + "------");
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(ZhuCeActivity.this, msg, Toast.LENGTH_SHORT).show();
                        }
                    });
                } else {
                    if (event == SMSSDK.EVENT_GET_VERIFICATION_CODE) {
                    } else if (event == SMSSDK.EVENT_SUBMIT_VERIFICATION_CODE) {
                        //注册成功的逻辑
                        Log.i("login", "验证成功");
                        finish();
                    }
                }
            }
        };
        // 注册监听器
        SMSSDK.registerEventHandler(eventHandler);
    }

    //在onDestroy中注销SDK
    protected void onDestroy() {
        super.onDestroy();
        SMSSDK.unregisterEventHandler(eventHandler);
    }

    private void initView() {
        toolbar_denglu = (Toolbar) findViewById(R.id.toolbar_denglu);
        huoquyanzhengma = (TextView) findViewById(R.id.huoquyanzhengma);
        zhuce_zhuce = (Button) findViewById(R.id.zhuce_zhuce);
        shoujihao_zhuce = (EditText) findViewById(R.id.shoujihao_zhuce);
        yanzhengma_zhuce = (EditText) findViewById(R.id.yanzhengma_zhuce);

        toolbar_denglu.setNavigationIcon(R.mipmap.ic_brows_back);
        toolbar_denglu.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        zhuce_zhuce.setOnClickListener(this);
        huoquyanzhengma.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.zhuce_zhuce:
                SMSSDK.submitVerificationCode("86", shoujihao_zhuce.getText().toString(), yanzhengma_zhuce.getText().toString());
                break;
            case R.id.huoquyanzhengma:
                SMSSDK.getVerificationCode("86", shoujihao_zhuce.getText().toString());
                break;
        }
    }
}
