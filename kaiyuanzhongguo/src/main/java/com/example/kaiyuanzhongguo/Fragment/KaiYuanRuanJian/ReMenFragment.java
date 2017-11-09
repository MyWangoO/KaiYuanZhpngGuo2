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
import com.example.kaiyuanzhongguo.Presenter.RuanJian_ReMenPresenter;
import com.example.kaiyuanzhongguo.R;
import com.example.kaiyuanzhongguo.View.ViewInf.ViewInf3;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class ReMenFragment extends Fragment implements ViewInf3 {


    private ListView lv_renmen;

    public ReMenFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.fragment_re_men, container, false);
        initView(inflate);
        PresenterInf presenterInf = new RuanJian_ReMenPresenter(this);
        presenterInf.ViewToModel();
        return inflate;
    }

    @Override
    public void updataUI(List<MaYunTuiJianBean.SoftwareBean> list) {
        MaYuTuiJianAdapter adapter = new MaYuTuiJianAdapter(list, getActivity());
        lv_renmen.setAdapter(adapter);
    }

    private void initView(View inflate) {
        lv_renmen = (ListView) inflate.findViewById(R.id.lv_renmen);
    }
}
