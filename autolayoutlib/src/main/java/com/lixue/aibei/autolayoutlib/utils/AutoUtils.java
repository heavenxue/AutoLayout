/*
 * Copyright (c) 2016 by xiaoxue. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.lixue.aibei.autolayoutlib.utils;

import android.view.View;
import android.view.ViewGroup;

import com.lixue.aibei.autolayoutlib.R;
import com.lixue.aibei.autolayoutlib.config.AutoLayoutConfig;

/**
 * Created by Administrator on 2016/2/19.
 */
public class AutoUtils {
    /**
     * 会直接将view的LayoutParams上设置的width，height直接进行百分比处理
     *
     * @param view
     */
    public static void auto(View view) {
        autoSize(view);
        autoPadding(view);
        autoMargin(view);
    }

    public static void autoMargin(View view) {
        if (!(view.getLayoutParams() instanceof ViewGroup.MarginLayoutParams))
            return;

        ViewGroup.MarginLayoutParams lp = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        if (lp == null) return;

        Object tag = view.getTag(R.id.id_tag_autolayout_margin);
        if (tag != null) return;
        view.setTag(R.id.id_tag_autolayout_margin, "Just Identify");

        lp.leftMargin = getPercentWidthSize(lp.leftMargin);
        lp.topMargin = getPercentHeightSize(lp.topMargin);
        lp.rightMargin = getPercentWidthSize(lp.rightMargin);
        lp.bottomMargin = getPercentHeightSize(lp.bottomMargin);

    }

    public static void autoPadding(View view) {
        Object tag = view.getTag(R.id.id_tag_autolayout_padding);
        if (tag != null) return;
        view.setTag(R.id.id_tag_autolayout_padding, "Just Identify");

        int l = view.getPaddingLeft();
        int t = view.getPaddingTop();
        int r = view.getPaddingRight();
        int b = view.getPaddingBottom();

        l = getPercentWidthSize(l);
        t = getPercentHeightSize(t);
        r = getPercentWidthSize(r);
        b = getPercentHeightSize(b);

        view.setPadding(l, t, r, b);
    }

    public static void autoSize(View view) {
        ViewGroup.LayoutParams lp = view.getLayoutParams();

        if (lp == null) return;

        Object tag = view.getTag(R.id.id_tag_autolayout_size);
        if (tag != null) return;

        view.setTag(R.id.id_tag_autolayout_size, "Just Identify");

        if (lp.width > 0) {
            int screenWidth = AutoLayoutConfig.getInstance().getScreenWidth();
            int designWidth = AutoLayoutConfig.getInstance().getDesignWidth();
            lp.width = (int) (lp.width * 1.0f / designWidth * screenWidth);
        }

        if (lp.height > 0) {
            int screenHeight = AutoLayoutConfig.getInstance().getScreenHeight();
            int designHeight = AutoLayoutConfig.getInstance().getDesignHeight();
            lp.height = (int) (lp.height * 1.0f / designHeight * screenHeight);
        }
    }

    public static int getPercentWidthSize(int val) {
        int screenWidth = AutoLayoutConfig.getInstance().getScreenWidth();
        int designWidth = AutoLayoutConfig.getInstance().getDesignWidth();

        return (int) (val * 1.0f / designWidth * screenWidth);
    }

    public static int getPercentHeightSize(int val) {
        int screenHeight = AutoLayoutConfig.getInstance().getScreenHeight();
        int designHeight = AutoLayoutConfig.getInstance().getDesignHeight();

        return (int) (val * 1.0f / designHeight * screenHeight);
    }

    /**最大宽度尺寸的百分比**/
    public static int getPercentWidthSizeBigger(int val){
        int screenWidth = AutoLayoutConfig.getInstance().getScreenWidth();
        int designWidth = AutoLayoutConfig.getInstance().getDesignWidth();
        int res= val * screenWidth;
        if (res % designWidth == 0){
            return res / designWidth;
        }else{
            return  res / designWidth + 1;
        }
    }

    public static int getPercentHeightSizeBigger(int val){
        int screenHeight = AutoLayoutConfig.getInstance().getScreenHeight();
        int designHeight = AutoLayoutConfig.getInstance().getDesignHeight();
        int res = val * screenHeight;
        if (res % designHeight == 0){
            return res/designHeight;
        }else {
            return res / designHeight +1 ;
        }
    }

}
