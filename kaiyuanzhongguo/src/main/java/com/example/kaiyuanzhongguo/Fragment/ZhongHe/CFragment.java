package com.example.kaiyuanzhongguo.Fragment.ZhongHe;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.kaiyuanzhongguo.Adapter.ZuiXinDongTanLVAdapter;
import com.example.kaiyuanzhongguo.Bean.ZuiJinDongTanBean;
import com.example.kaiyuanzhongguo.Presenter.JiShuWenDaPresenter;
import com.example.kaiyuanzhongguo.Presenter.PresenterInf;
import com.example.kaiyuanzhongguo.R;
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
    public void updataUI(List<ZuiJinDongTanBean.TweetBean> list) {
        ZuiXinDongTanLVAdapter adapter = new ZuiXinDongTanLVAdapter(getActivity(),list);
        jishuwenda_lv.setAdapter(adapter);
    }

    private void initView(View inflate) {
        jishuwenda_lv = (ListView) inflate.findViewById(R.id.jishuwenda_lv);
    }
}
