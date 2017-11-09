package com.example.kaiyuanzhongguo.Fragment.ZhongHe;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.kaiyuanzhongguo.Adapter.TuiJianBoKeAdapter;
import com.example.kaiyuanzhongguo.Bean.TuiJianBoKeBean;
import com.example.kaiyuanzhongguo.Presenter.MeiRiYiBoPresentr;
import com.example.kaiyuanzhongguo.Presenter.PresenterInf;
import com.example.kaiyuanzhongguo.R;
import com.example.kaiyuanzhongguo.View.ViewInf.ViewInf1;
import com.example.kaiyuanzhongguo.View.ZhongHeActivity.BoKeXiangQingActivity;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class DFragment extends Fragment implements ViewInf1 {


    private ListView meiriyibo_lv;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.fragment_d, container, false);
        initView(inflate);

        PresenterInf presenterInf = new MeiRiYiBoPresentr(this);
        presenterInf.ViewToModel();
        return inflate;
    }

    @Override
    public void updataUI(final List<TuiJianBoKeBean.BlogBean> list) {
        TuiJianBoKeAdapter adapter = new TuiJianBoKeAdapter(getActivity(),list);
        meiriyibo_lv.setAdapter(adapter);

        meiriyibo_lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getActivity(), BoKeXiangQingActivity.class);
                intent.putExtra("url",list.get(i).getUrl());
                startActivity(intent);
            }
        });
    }

    private void initView(View inflate) {
        meiriyibo_lv = (ListView) inflate.findViewById(R.id.meiriyibo_lv);
    }
}
