package com.example.kaiyuanzhongguo.Adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by asus on 2017/10/26.
 */
public class ZhongHeFragmentAdapter extends FragmentPagerAdapter {
    private List<String> stringList;
    private List<Fragment> fragmentList;

    public ZhongHeFragmentAdapter(FragmentManager fm, List<String> stringList, List<Fragment> fragmentList) {
        super(fm);
        this.stringList = stringList;
        this.fragmentList = fragmentList;
    }

    public ZhongHeFragmentAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return stringList.get(position);
    }
}
