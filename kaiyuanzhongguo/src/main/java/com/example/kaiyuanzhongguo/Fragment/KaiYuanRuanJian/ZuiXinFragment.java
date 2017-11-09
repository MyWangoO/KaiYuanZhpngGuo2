package com.example.kaiyuanzhongguo.Fragment.KaiYuanRuanJian;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.kaiyuanzhongguo.Adapter.MaYuTuiJianAdapter;
import com.example.kaiyuanzhongguo.Bean.MaYunTuiJianBean;
import com.example.kaiyuanzhongguo.Presenter.PresenterInf;
import com.example.kaiyuanzhongguo.Presenter.RuanJian_ZuiXinPresenter;
import com.example.kaiyuanzhongguo.R;
import com.example.kaiyuanzhongguo.View.ViewInf.ViewInf3;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class ZuiXinFragment extends Fragment implements ViewInf3 {


    private ListView lv_zuixin;

    public ZuiXinFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.fragment_zui_xin, container, false);
        initView(inflate);
        PresenterInf presenterInf = new RuanJian_ZuiXinPresenter(this);
        presenterInf.ViewToModel();
        return inflate;
    }

    @Override
    public void updataUI(List<MaYunTuiJianBean.SoftwareBean> list) {
        MaYuTuiJianAdapter adapter = new MaYuTuiJianAdapter(list,getActivity());
        lv_zuixin.setAdapter(adapter);
    }

    private void initView(View inflate) {
        lv_zuixin = (ListView) inflate.findViewById(R.id.lv_zuixin);
    }
}
