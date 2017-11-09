package com.example.kaiyuanzhongguo.Fragment.DongTan;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.kaiyuanzhongguo.Adapter.ZuiXinDongTanLVAdapter;
import com.example.kaiyuanzhongguo.Bean.ZuiJinDongTanBean;
import com.example.kaiyuanzhongguo.Presenter.PresenterInf;
import com.example.kaiyuanzhongguo.Presenter.ReMenDongTanPresenter;
import com.example.kaiyuanzhongguo.R;
import com.example.kaiyuanzhongguo.View.ViewInf.ViewInf2;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class FFragment extends Fragment implements ViewInf2{


    private ListView remendongtan_lv;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.fragment_f, container, false);
        initView(inflate);
        PresenterInf presenterInf = new ReMenDongTanPresenter(this);
        presenterInf.ViewToModel();
        return inflate;
    }

    private void initView(View inflate) {
        remendongtan_lv = (ListView) inflate.findViewById(R.id.remendongtan_lv);
    }

    @Override
    public void updataUI(List<ZuiJinDongTanBean.TweetBean> list) {
        ZuiXinDongTanLVAdapter adapter = new ZuiXinDongTanLVAdapter(getActivity(),list);
        remendongtan_lv.setAdapter(adapter);
    }
}
