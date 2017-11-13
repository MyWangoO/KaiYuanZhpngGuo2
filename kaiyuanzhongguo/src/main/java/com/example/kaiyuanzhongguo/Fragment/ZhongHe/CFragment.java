package com.example.kaiyuanzhongguo.Fragment.ZhongHe;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.kaiyuanzhongguo.Adapter.ZuiXinDongTanLVAdapter;
import com.example.kaiyuanzhongguo.Bean.ZuiJinDongTanBean;
import com.example.kaiyuanzhongguo.Presenter.JiShuWenDaPresenter;
import com.example.kaiyuanzhongguo.Presenter.PresenterInf;
import com.example.kaiyuanzhongguo.R;
import com.example.kaiyuanzhongguo.View.DongTanActivity.DongTanXiangQingActivity;
import com.example.kaiyuanzhongguo.View.ViewInf.ViewInf2;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class CFragment extends Fragment implements ViewInf2 {


    private ListView jishuwenda_lv;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.fragment_c, container, false);
        initView(inflate);

        PresenterInf presenterInf = new JiShuWenDaPresenter(this);
        presenterInf.ViewToModel();
        return inflate;
    }

    @Override
    public void updataUI(final List<ZuiJinDongTanBean.TweetBean> list) {
        ZuiXinDongTanLVAdapter adapter = new ZuiXinDongTanLVAdapter(getActivity(),list);
        jishuwenda_lv.setAdapter(adapter);

        //点击条目跳转
        jishuwenda_lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getActivity(), DongTanXiangQingActivity.class);
                intent.putExtra("touxiang",list.get(i).getPortrait());
                intent.putExtra("name",list.get(i).getAuthor());
                intent.putExtra("text",list.get(i).getBody());
                intent.putExtra("shijian",list.get(i).getPubDate());
                startActivity(intent);
            }
        });
    }

    private void initView(View inflate) {
        jishuwenda_lv = (ListView) inflate.findViewById(R.id.jishuwenda_lv);

    }
}
