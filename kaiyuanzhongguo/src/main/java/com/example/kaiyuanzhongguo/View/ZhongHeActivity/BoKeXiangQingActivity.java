package com.example.kaiyuanzhongguo.View.ZhongHeActivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.kaiyuanzhongguo.R;

public class BoKeXiangQingActivity extends AppCompatActivity {

    private WebView webview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bo_ke_xiang_qing);
        initView();

        Intent intent = getIntent();
        String url = intent.getStringExtra("url");
        webview.loadUrl(url);
        webview.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });

    }

    private void initView() {
        webview = (WebView) findViewById(R.id.webview);
    }
}
