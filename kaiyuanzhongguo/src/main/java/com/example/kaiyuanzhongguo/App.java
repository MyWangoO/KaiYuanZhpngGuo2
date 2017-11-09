package com.example.kaiyuanzhongguo;

import android.app.Application;

import com.mob.MobSDK;
import com.umeng.socialize.PlatformConfig;
import com.umeng.socialize.UMShareAPI;

/**
 * Created by asus on 2017/11/2.
 */
public class App extends Application {
    {

        PlatformConfig.setWeixin("wx967daebe835fbeac", "5bb696d9ccd75a38c8a0bfe0675559b3");
        PlatformConfig.setQQZone("100424468", "c7394704798a158208a74ab60104f0ba");
        PlatformConfig.setSinaWeibo("3921700954", "04b48b094faeb16683c32669824ebdad", "http://sns.whalecloud.com");
    }
    //初始化
    @Override
    public void onCreate() {
        super.onCreate();
        UMShareAPI.get(this);

        super.onCreate();
        MobSDK.init(this, this.a(), this.b());

    }

    public App() {
    }

    protected String a() {
        return null;
    }

    protected String b() {
        return null;
    }
}
