package com.lixue.aibei.autolayout.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lixue.aibei.autolayout.R;
import com.lixue.aibei.slidingtitlebarlib.SlidingTabScript;

/**
 * Created by Administrator on 2016/4/7.
 */
public class CategoryFragment extends Fragment {
    private SlidingTabScript slidingTabScript;
    private ViewPager viewPager;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View w = inflater.inflate(R.layout.fragment_category,container,false);
        initView(w);
        return w;
    }

    private void initView(View v){
        slidingTabScript = (SlidingTabScript) v.findViewById(R.id.slidingTabScript);
        viewPager = (ViewPager) v.findViewById(R.id.viewpager);

        viewPager.setAdapter(new MyPagerAdapter(getActivity().getSupportFragmentManager()));
        slidingTabScript.setViewPager(viewPager);
    }

    private static class MyPagerAdapter extends FragmentPagerAdapter {

        Fragment listFragment;
        Fragment gridFragment;

        public MyPagerAdapter(FragmentManager fm) {
            super(fm);
            listFragment = new ListFragment();
            gridFragment = new PayFragment();
        }

        @Override
        public int getCount() {
            return 2;
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return listFragment;
                case 1:
                    return gridFragment;
                default:
                    return null;
            }
        }
    }
}
