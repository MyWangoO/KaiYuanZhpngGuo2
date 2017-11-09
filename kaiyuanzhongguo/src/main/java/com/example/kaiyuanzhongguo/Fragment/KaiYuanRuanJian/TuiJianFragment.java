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
import com.example.kaiyuanzhongguo.Presenter.RuanJian_TuiJianPresenter;
import com.example.kaiyuanzhongguo.R;
import com.example.kaiyuanzhongguo.View.ViewInf.ViewInf3;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class TuiJianFragment extends Fragment implements ViewInf3 {


    private ListView lv_fenlei;

    public TuiJianFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.fragment_tui_jian, container, false);
        PresenterInf presenterInf = new RuanJian_TuiJianPresenter(this);
        presenterInf.ViewToModel();
        initView(inflate);
        return inflate;
    }

    @Override
    public void updataUI(List<MaYunTuiJianBean.SoftwareBean> list) {
        MaYuTuiJianAdapter adapter = new MaYuTuiJianAdapter(list,getActivity());
        lv_fenlei.setAdapter(adapter);
    }

    private void initView(View inflate) {
        lv_fenlei = (ListView) inflate.findViewById(R.id.lv_fenlei);
    }
}
