package com.example.kaiyuanzhongguo.Fragment.Zhu;


import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.example.kaiyuanzhongguo.Adapter.MyRecyclerView1Adapter;
import com.example.kaiyuanzhongguo.Adapter.RecyclerTwoAdater;
import com.example.kaiyuanzhongguo.Adapter.ZhongHeFragmentAdapter;
import com.example.kaiyuanzhongguo.Fragment.ZhongHe.AFragment;
import com.example.kaiyuanzhongguo.Fragment.ZhongHe.BFragment;
import com.example.kaiyuanzhongguo.Fragment.ZhongHe.CFragment;
import com.example.kaiyuanzhongguo.Fragment.ZhongHe.DFragment;
import com.example.kaiyuanzhongguo.R;
import com.example.kaiyuanzhongguo.RecyclerViewClickLister;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class ZhongHeFragment extends Fragment implements View.OnClickListener {

    private ViewPager vipa;
    private TabLayout tab;
    private View v;
    private TextView qie;
    private TextView dele;
    private ImageView biao;
    private LinearLayout lin;

    private RecyclerView recycler1;
    private TextView textView7;
    private RecyclerView recycler2;
    private LinearLayout line11;
    private LinearLayout linearLayout;

    private MyRecyclerView1Adapter myRecyclerView1Adapter;
    private RecyclerTwoAdater recyclerTwoAdater;
    private GridLayoutManager gridLayout1;


    String[] str = {"码云推荐", "热门资讯", "最新翻译", "移动开发"
            , "开源硬件", "云计算", "软件工程", "系统运维"
            , "图像多媒体", "企业开发", "数据库", "编程语言"
            , "游戏开发", "服务端开发", "前端开发", "源创君"
            , "最新博客", "热门博客", "站务建议", "职业生涯"
            , "行业杂烩", "技术分享", "开源访谈", "高手问答"
            , "最新软件"};
    String[] str1 = {"码云推荐", "热门资讯", "最新翻译", "移动开发"
            , "开源硬件", "云计算", "软件工程", "系统运维"
            , "图像多媒体", "企业开发", "数据库", "编程语言"
            , "游戏开发", "服务端开发", "前端开发", "源创君"
            , "最新博客", "热门博客", "站务建议", "职业生涯"
            , "行业杂烩", "技术分享", "开源访谈", "高手问答"
            , "最新软件"};
    private List<String> stringList;
    private List<Fragment> fragmentList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.fragment_zhong_he, container, false);
        v = LayoutInflater.from(getActivity()).inflate(R.layout.tianjia, null);
        recycler1 = (RecyclerView) v.findViewById(R.id.recycler1);
        textView7 = (TextView) v.findViewById(R.id.textView7);
        recycler2 = (RecyclerView) v.findViewById(R.id.recycler2);
        line11 = (LinearLayout) v.findViewById(R.id.line11);
        linearLayout = (LinearLayout) v.findViewById(R.id.linearLayout);
        initView(inflate);
        initData();
        initAdapter();
        final ArrayList<String> recyc1 = new ArrayList<>();
        ArrayList<String> recyc2 = new ArrayList<>();
        for (int i = 0; i < str.length; i++) {
            recyc1.add(str1[i]);
            recyc2.add(str1[i]);
        }

        one(recyc1);

        two(recyc2);

        biao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation animation = AnimationUtils.loadAnimation(getActivity(), R.anim.shunshizhen_raotate);
                biao.setAnimation(animation);
                biao.startAnimation(animation);
                tab.setVisibility(View.INVISIBLE);
                vipa.setVisibility(View.GONE);
                dele.setVisibility(View.VISIBLE);
                qie.setVisibility(View.VISIBLE);
                showpop();
            }
        });


        return inflate;
    }

    private void two(ArrayList<String> recyc2) {
        gridLayout1 = new GridLayoutManager(getActivity(), 4);
        recycler2.setLayoutManager(gridLayout1);
        recyclerTwoAdater = new RecyclerTwoAdater(getActivity(),recyc2);

        recycler2.setAdapter(recyclerTwoAdater);
        recycler2.setItemAnimator(new DefaultItemAnimator());
        //实例化适配器里的item点击事件的接口
        recyclerTwoAdater.setRecyclerViewClickLister(new RecyclerViewClickLister() {
            @Override
            public void itemLongClickLister(String data) {
                Toast.makeText(getActivity(), data, Toast.LENGTH_LONG).show();
                //获取点击条目的数据
                recyclerTwoAdater.dlt(data.split(";")[0], Integer.valueOf(data.split(";")[1]));
                myRecyclerView1Adapter.adds(data.split(";")[0]);
            }

            @Override
            public void itemClickLister(String data) {

            }
        });
    }

    private void one(final ArrayList<String> recyc1) {
        GridLayoutManager gridLayout = new GridLayoutManager(getActivity(), 4);
        recycler1.setLayoutManager(gridLayout);
        myRecyclerView1Adapter = new MyRecyclerView1Adapter(recyc1, getActivity());

        recycler1.setAdapter(myRecyclerView1Adapter);
        recycler1.setItemAnimator(new DefaultItemAnimator());


        myRecyclerView1Adapter.setRecyclerViewClickLister(new RecyclerViewClickLister() {
            @Override
            public void itemLongClickLister(String data) {
                Toast.makeText(getActivity(), data, Toast.LENGTH_LONG).show();
                myRecyclerView1Adapter.setaBoolean(true);
                myRecyclerView1Adapter.notifyDataSetChanged();
            }

            @Override
            public void itemClickLister(String data) {
                myRecyclerView1Adapter.dlt(data.split(";")[0], Integer.valueOf(data.split(";")[1]));
            }
        });
        final ItemTouchHelper itemTouchHelper = new ItemTouchHelper(new ItemTouchHelper.Callback() {
            @Override
            public int getMovementFlags(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
                if (viewHolder.itemView.getTag(R.id.mydt_name).equals("yes")) {
                    final int dragFlags = ItemTouchHelper.UP | ItemTouchHelper.DOWN |
                            ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT;
                    final int swipeFlags = 0;
                    return makeMovementFlags(dragFlags, swipeFlags);
                }
                return 0;
            }

            @Override
            public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
                //最原始的item id
                int fromPosition = viewHolder.getAdapterPosition();  //13
                //拿到当前拖拽到的item的viewHolder
                int toPosition = target.getAdapterPosition();  //14
                if (fromPosition < 4) {
                    return true;
                }
                if (fromPosition < toPosition) {
                    for (int i = fromPosition; i < toPosition; i++) {
                        Collections.swap(recyc1, i, i + 1); //小的数据往大的后面移动
                    }
                } else {
                    for (int i = fromPosition; i > toPosition; i--) {
                        Collections.swap(recyc1, i, i - 1); //大的position的标准往小的后面放
                    }
                }
                myRecyclerView1Adapter.notifyItemMoved(fromPosition, toPosition);
                return true;
            }

            //swiped -- 刷卡
            @Override
            public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
            }

            //选中的item
            @Override
            public void onSelectedChanged(RecyclerView.ViewHolder viewHolder, int actionState) {
                //当前状态的如果不是静止状态的话,就给选中的item 添加一个北京颜色
                if (actionState != ItemTouchHelper.ACTION_STATE_IDLE && viewHolder.itemView.getTag(R.id.mydt_name).equals("yes")) {
                    viewHolder.itemView.setBackgroundColor(Color.RED);
                }
                super.onSelectedChanged(viewHolder, actionState);
            }

            //放手后的一个重新绘制item的方法,其过程就是恢复原先的北京
            @Override
            public void clearView(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
                super.clearView(recyclerView, viewHolder);
                viewHolder.itemView.setBackgroundColor(0);
            }
        });
        itemTouchHelper.attachToRecyclerView(recycler1);
    }

    private void showpop() {
        PopupWindow popupWindow1 = new PopupWindow(v, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        popupWindow1.setFocusable(true);
        popupWindow1.setWidth(ViewGroup.LayoutParams.MATCH_PARENT);
        popupWindow1.setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
        popupWindow1.setBackgroundDrawable(new BitmapDrawable());
        popupWindow1.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Animation animation2 = AnimationUtils.loadAnimation(getActivity(), R.anim.nishizhen_rotate);
                        biao.setAnimation(animation2);
                        tab.setVisibility(View.VISIBLE);
                        vipa.setVisibility(View.VISIBLE);
                        dele.setVisibility(View.GONE);
                        qie.setVisibility(View.GONE);
                    }
                });
            }

        });
        popupWindow1.showAtLocation(biao, Gravity.BOTTOM, 0, 500);
    }

    private void initAdapter() {

        ZhongHeFragmentAdapter adapter = new ZhongHeFragmentAdapter(getFragmentManager(), stringList, fragmentList);
        tab.setupWithViewPager(vipa);
        vipa.setCurrentItem(0);
        vipa.setOffscreenPageLimit(2);
        vipa.setAdapter(adapter);;
    }

    private void initData() {
        stringList = new ArrayList<>();
        stringList.add("开源资讯");
        stringList.add("推荐博客");
        stringList.add("技术问答");
        stringList.add("每日一搏");
        fragmentList = new ArrayList<>();
        fragmentList.add(new AFragment());
        fragmentList.add(new BFragment());
        fragmentList.add(new CFragment());
        fragmentList.add(new DFragment());


    }

    private void initView(View inflate) {

        tab = inflate.findViewById(R.id.tab1);
        vipa = (ViewPager) inflate.findViewById(R.id.vp1);
        qie = (TextView) inflate.findViewById(R.id.qie);
        qie.setOnClickListener(this);
        dele = (TextView) inflate.findViewById(R.id.dele);
        dele.setOnClickListener(this);
        biao = (ImageView) inflate.findViewById(R.id.biao);
        biao.setOnClickListener(this);
        lin = (LinearLayout) inflate.findViewById(R.id.lin);
        lin.setOnClickListener(this);

        biao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //显示popuwindow
                v = LayoutInflater.from(getActivity()).inflate(R.layout.tianjia, null);
                //创建一个popuwindow对象
                PopupWindow popu = new PopupWindow(v, ViewGroup.LayoutParams.MATCH_PARENT, 300);
                //默认获取不到焦点，设置获取焦点
                popu.setFocusable(true);
                //点击窗口以外区域，窗口消失
                popu.setBackgroundDrawable(new BitmapDrawable());
                //弹出或者消失的时候带动画效果
//                popu.setAnimationStyle(R.style.mypopu);
                //显示popuwindow
                popu.showAtLocation(v, Gravity.BOTTOM, 0, 0);
            }
        });
    }

    @Override
    public void onClick(View view) {

    }
}
