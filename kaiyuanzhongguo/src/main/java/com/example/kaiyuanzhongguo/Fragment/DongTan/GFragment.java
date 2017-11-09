package com.example.kaiyuanzhongguo.Fragment.DongTan;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.kaiyuanzhongguo.Adapter.TuiJianBoKeAdapter;
import com.example.kaiyuanzhongguo.Bean.TuiJianBoKeBean;
import com.example.kaiyuanzhongguo.Presenter.MeiRiLuanTanPresentr;
import com.example.kaiyuanzhongguo.Presenter.PresenterInf;
import com.example.kaiyuanzhongguo.R;
import com.example.kaiyuanzhongguo.View.ViewInf.ViewInf1;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class GFragment extends Fragment implements ViewInf1 {


    private ListView meiriluantan_lv;

    public GFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.fragment_g, container, false);
        initView(inflate);
        PresenterInf presenterInf = new MeiRiLuanTanPresentr(this);
        presenterInf.ViewToModel();
        return inflate;
    }

    @Override
    public void updataUI(List<TuiJianBoKeBean.BlogBean> list) {
        TuiJianBoKeAdapter adapter = new TuiJianBoKeAdapter(getActivity(), list);
        meiriluantan_lv.setAdapter(adapter);

    }

    private void initView(View inflate) {
        meiriluantan_lv = (ListView) inflate.findViewById(R.id.meiriluantan_lv);
    }
}
