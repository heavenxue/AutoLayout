package com.lixue.aibei.autolayout;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.WindowManager;

import com.lixue.aibei.autolayout.fragment.ListFragment;
import com.lixue.aibei.autolayout.fragment.PayFragment;
import com.lixue.aibei.autolayout.fragment.RecyclerViewFragment;
import com.lixue.aibei.autolayout.fragment.RecyclerViewGridFragment;
import com.lixue.aibei.autolayout.fragment.RegisterFragment;
import com.lixue.aibei.autolayoutlib.AutoFrameLayout;
import com.lixue.aibei.autolayoutlib.AutoLayoutActivity;
import com.lixue.aibei.autolayoutlib.utils.AutoLayoutHelper;

import java.util.ArrayList;


public class MainActivity extends AutoLayoutActivity {
    private ViewPager mViewPager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setImmersionStatus();
        setContentView(R.layout.activity_main);

        initView();
        initDatas();

    }

    private void setImmersionStatus(){
        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.KITKAT){
            //透明状态栏
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            //透明导航栏
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        }
    }

    private void initView(){
        mViewPager = (ViewPager) findViewById(R.id.id_viewpager);
    }

    private void initDatas(){
        ArrayList<Fragment> mList = new ArrayList<Fragment>();
        mList.add(new ListFragment());
        mList.add(new RegisterFragment());
        mList.add(new PayFragment());
        mList.add(new RecyclerViewFragment());
        mList.add(new RecyclerViewGridFragment());
        mViewPager.setAdapter(new MyAdapter(getSupportFragmentManager(), mList));
    }

    public class MyAdapter extends FragmentPagerAdapter {
        ArrayList<Fragment> tabs = null;

        public MyAdapter(FragmentManager fm, ArrayList<Fragment> tabs) {
            super(fm);
            this.tabs = tabs;
        }

        @Override
        public Fragment getItem(int pos) {
            return tabs.get(pos);
        }

        @Override
        public int getCount() {
            return tabs.size();
        }
    }

}
