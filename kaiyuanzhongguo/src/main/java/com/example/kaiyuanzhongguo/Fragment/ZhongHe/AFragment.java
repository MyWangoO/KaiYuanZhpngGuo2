package com.example.kaiyuanzhongguo.Fragment.ZhongHe;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.kaiyuanzhongguo.Adapter.KaiYuanZiXunLVAdapter;
import com.example.kaiyuanzhongguo.GlideImage;
import com.example.kaiyuanzhongguo.Presenter.KaiYuanZiXunPresenter;
import com.example.kaiyuanzhongguo.Presenter.PresenterInf;
import com.example.kaiyuanzhongguo.R;
import com.example.kaiyuanzhongguo.View.ViewInf.ViewInf;
import com.example.kaiyuanzhongguo.View.ZhongHeActivity.ZiXunXiangQingActivity;
import com.scwang.smartrefresh.header.MaterialHeader;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.constant.SpinnerStyle;
import com.scwang.smartrefresh.layout.footer.BallPulseFooter;
import com.scwang.smartrefresh.layout.listener.OnLoadmoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class AFragment extends Fragment implements ViewInf {


    private Banner banner_kaiyuanzixun;
    private ListView lv_kaiyuanzixun;
    private ArrayList<Object> list2;
    private SmartRefreshLayout srl;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.fragment_a, container, false);
        initView(inflate);
        initLuBoTu();
        PresenterInf presenterInf = new KaiYuanZiXunPresenter(this);
        presenterInf.ViewToModel();
        return inflate;
    }

    private void initTiaoZhuan(final JSONObject jsonObject) {
        lv_kaiyuanzixun.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getActivity(), ZiXunXiangQingActivity.class);
                try {
                    JSONArray newslist = jsonObject.getJSONArray("newslist");
                    intent.putExtra("title", newslist.getJSONObject(i).getString("title"));
                    intent.putExtra("name", newslist.getJSONObject(i).getString("author"));
                    intent.putExtra("shijian", newslist.getJSONObject(i).getString("pubDate"));
                    intent.putExtra("text", newslist.getJSONObject(i).getString("body"));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                startActivity(intent);
            }
        });
    }

    private void initLuBoTu() {
        List<Integer> stringList = new ArrayList<>();
        stringList.add(R.mipmap.x);
        stringList.add(R.mipmap.y);
        stringList.add(R.mipmap.z);
        stringList.add(R.mipmap.meme);
        stringList.add(R.mipmap.haha);
        stringList.add(R.mipmap.hehe);
        banner_kaiyuanzixun.setImages(stringList)//添加图片集合或图片url集合
                .setDelayTime(2000)//设置轮播时间
                .setBannerStyle(BannerConfig.CIRCLE_INDICATOR)
                .setImageLoader(new GlideImage())//加载图片
                .setIndicatorGravity(BannerConfig.CENTER)//设置指示器位置
                .start();
    }

    private void initView(View inflate) {
        banner_kaiyuanzixun = (Banner) inflate.findViewById(R.id.banner_kaiyuanzixun);
        lv_kaiyuanzixun = (ListView) inflate.findViewById(R.id.lv_kaiyuanzixun);
        srl = (SmartRefreshLayout) inflate.findViewById(R.id.srl);
    }

    @Override
    public void updataUI(JSONObject jsonObject) {

        srl.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshlayout) {
                refreshlayout.finishRefresh(2000);

            }
        });
        srl.setOnLoadmoreListener(new OnLoadmoreListener() {
            @Override
            public void onLoadmore(RefreshLayout refreshlayout) {
                refreshlayout.finishLoadmore(2000);

            }
        });


        //设置 Header 为 Material风格
        srl.setRefreshHeader(new MaterialHeader(getActivity()).setShowBezierWave(true));
        //设置 Footer 为 球脉冲
        srl.setRefreshFooter(new BallPulseFooter(getActivity()).setSpinnerStyle(SpinnerStyle.Scale));

//        list2 = new ArrayList<>();
        KaiYuanZiXunLVAdapter adapter = new KaiYuanZiXunLVAdapter(getActivity(), jsonObject);
        lv_kaiyuanzixun.setAdapter(adapter);
        initTiaoZhuan(jsonObject);
    }
}
