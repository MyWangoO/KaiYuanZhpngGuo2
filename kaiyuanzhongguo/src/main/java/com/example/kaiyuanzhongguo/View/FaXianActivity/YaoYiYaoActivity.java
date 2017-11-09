package com.example.kaiyuanzhongguo.View.FaXianActivity;

import android.app.Service;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.os.Vibrator;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.kaiyuanzhongguo.MainActivity;
import com.example.kaiyuanzhongguo.R;

public class YaoYiYaoActivity extends AppCompatActivity implements TabLayout.OnTabSelectedListener, View.OnClickListener, SensorEventListener {

    private ImageView iv_left_back;
    private TabLayout tab;
    private LinearLayout yyy;
    private TextView tv_name;
    private SensorManager sensorManager;
    private Sensor sensor;
    private Vibrator vibrator;
    String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yao_yi_yao);
        initView();
        //添加文字+图片
        tab.addTab(tab.newTab().setText("礼品").setIcon(R.mipmap.btn_shake_gift));
        tab.addTab(tab.newTab().setText("咨询").setIcon(R.mipmap.btn_shake_gift_actived));
        tab.addOnTabSelectedListener(this);
        //默认选中
        tab.getTabAt(0).select();
        tab.getTabAt(0).setIcon(R.mipmap.btn_shake_gift);
        //点击返回
        iv_left_back.setOnClickListener(this);
        //获取传感器管理服务
        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        //获取重力传感器sensor对象
        sensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        vibrator = (Vibrator) this.getSystemService(Service.VIBRATOR_SERVICE);
    }
    private void initView() {
        iv_left_back = (ImageView) findViewById(R.id.iv_left_back);
        tab = (TabLayout) findViewById(R.id.tab);
        tv_name = (TextView) findViewById(R.id.tv_name);
    }
    //选中了tab的逻辑
    @Override
    public void onTabSelected(TabLayout.Tab tabes) {
        int position = tabes.getPosition();

        switch (position) {
            case 0:
                tab.getTabAt(position).setIcon(R.mipmap.btn_shake_gift);
                tv_name.setText("摇一摇抢礼品");
                break;
            case 1:
                tv_name.setText("摇一摇获取资讯");
                tab.getTabAt(1).setIcon(R.mipmap.btn_shake_gift_actived);
                break;
        }
    }
    //未选中tab的逻辑
    @Override
    public void onTabUnselected(TabLayout.Tab tabes) {
        int position = tabes.getPosition();
        switch (position) {
            case 0:
                tab.getTabAt(0).setIcon(R.mipmap.btn_shake_gift);
                break;
            case 1:
                tab.getTabAt(1).setIcon(R.mipmap.btn_shake_gift_actived);
                break;
        }
    }
    //再次选中tab的逻辑
    @Override
    public void onTabReselected(TabLayout.Tab tabes) {
        int position = tabes.getPosition();

        switch (position) {
            case 0:
                tab.getTabAt(position).setIcon(R.mipmap.btn_shake_gift);
                break;
            case 1:
                tab.getTabAt(1).setIcon(R.mipmap.btn_shake_gift_actived);
                break;
        }
    }
    @Override
    public void onClick(View view) {
        finish();
    }
    @Override
    protected void onResume() {
        super.onResume();
        //注册传感器回调函数
        //SensorManager.SENSOR_DELAY_GAME测量的频繁度
        sensorManager.registerListener(this, sensor, SensorManager.SENSOR_DELAY_GAME);
    }
    @Override
    protected void onPause() {
        super.onPause();

        //反注册传感器回调函数
        sensorManager.unregisterListener(this);
    }
    long lastUpdateTime;
    long currentupdateTime;
    long timeInterval;
    static final int UPTATE_INTERVAL_TIME = 50;//两次测量时间间隔
    static final int SPEED_SHRESHOLD = 45;// 这个值越大需要越大的力气来摇晃手机

    float lastX;
    float lastY;
    float lastZ;
    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        currentupdateTime = System.currentTimeMillis();
        timeInterval = currentupdateTime - lastUpdateTime;
        if (timeInterval < UPTATE_INTERVAL_TIME) {
            return;
        }
        lastUpdateTime = currentupdateTime;

        float x = sensorEvent.values[0];
        float y = sensorEvent.values[1];
        float z = sensorEvent.values[2];

        float deltaX = x - lastX;
        float deltaY = y - lastY;
        float deltaZ = z - lastZ;

        lastX = x;
        lastY = y;
        lastZ = z;
        double speed = (Math.sqrt(deltaX * deltaX + deltaY * deltaY + deltaZ
                * deltaZ) / timeInterval) * 100;
        if (speed >= SPEED_SHRESHOLD) {
            vibrator.vibrate(600);
            Toast.makeText(YaoYiYaoActivity.this, "再摇摇看看", Toast.LENGTH_SHORT).show();
        }
    }
    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {
    }
}

