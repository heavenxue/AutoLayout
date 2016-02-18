/*
 * Copyright (c) 2016 by xiaoxue. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.lixue.aibei.autolayoutlib.config;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;

import com.lixue.aibei.autolayoutlib.utils.L;
import com.lixue.aibei.autolayoutlib.utils.ScreenUtils;

/**
 * Created by Administrator on 2016/2/18.
 */
public class AutoLayoutConfig {
    private static final String KEY_DESIGN_WIDTH = "design_width";
    private static final String KEY_DESIGN_HEIGHT = "design_height";
    private static AutoLayoutConfig instance = new AutoLayoutConfig();
    private int mDesignWidth;
    private int mDesignHeight;
    private int mScreenWidth;
    private int mScreenHeight;
    private boolean useDeviceSize;//是否用设备本身尺寸

    private AutoLayoutConfig() {

    }

    public static AutoLayoutConfig getInstance() {
        return instance;
    }

    public void checkPrams() {
        if (mDesignWidth <= 0 || mDesignHeight <= 0) {
            throw new RuntimeException("you must set " + KEY_DESIGN_WIDTH + " and " + KEY_DESIGN_HEIGHT + "  in your manifest file.");
        }
    }

    public AutoLayoutConfig useDeviceSize() {
        useDeviceSize = true;
        return this;
    }

    public void init(Context context) {
        getMetaData(context);
        mScreenWidth = ScreenUtils.getScreenSize(context, useDeviceSize)[0];
        mScreenHeight = ScreenUtils.getScreenSize(context, useDeviceSize)[1];
        L.e(" screenWidth =" + mScreenWidth + " ,screenHeight = " + mScreenHeight);
    }

    /**
     * 得到你在AndroidMenifext.xml文件中配置的metdata的实际长和宽*
     */
    private void getMetaData(Context context) {
        PackageManager pm = context.getPackageManager();
        ApplicationInfo applicationInfo;
        try {
            applicationInfo = pm.getApplicationInfo(context.getPackageName(), PackageManager.GET_META_DATA);
            //ApplicationInfo applicationInfo = context.getApplicationInfo();
            if (applicationInfo != null && applicationInfo.metaData != null) {
                mDesignWidth = (int) applicationInfo.metaData.get(KEY_DESIGN_WIDTH);
                mDesignHeight = (int) applicationInfo.metaData.get(KEY_DESIGN_HEIGHT);
            }
        } catch (PackageManager.NameNotFoundException e) {
            throw new RuntimeException("you must set" + KEY_DESIGN_WIDTH + "and" + KEY_DESIGN_HEIGHT + " in your manifest file.", e);
        }
        L.e(" designWidth =" + mDesignWidth + " , designHeight = " + mDesignHeight);
    }

    public int getScreenWidth() {
        return mScreenWidth;
    }

    public int getScreenHeight() {
        return mScreenHeight;
    }

    public int getDesignWidth() {
        return mDesignWidth;
    }

    public int getDesignHeight() {
        return mDesignHeight;
    }

}
