package com.example.kaiyuanzhongguo;

import android.content.Context;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;
import com.youth.banner.loader.ImageLoader;

/**
 * Created by asus on 2017/10/29.
 *
 * Banner无限轮播图需要类
 */
public class GlideImage extends ImageLoader {
    @Override
    public void displayImage(Context context, Object path, ImageView imageView) {
        Picasso.with(context.getApplicationContext()).load((Integer) path).into(imageView);
    }

}
