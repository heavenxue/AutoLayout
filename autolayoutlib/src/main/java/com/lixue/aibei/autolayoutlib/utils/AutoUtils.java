/*
 * Copyright (c) 2016 by xiaoxue. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.lixue.aibei.autolayoutlib.utils;

import android.view.View;

import com.lixue.aibei.autolayoutlib.AutoLayoutInfo;
import com.lixue.aibei.autolayoutlib.R;
import com.lixue.aibei.autolayoutlib.attr.Attrs;
import com.lixue.aibei.autolayoutlib.attr.AutoAttr;
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

    /**
     * @param view
     * @param attrs #Attrs.WIDTH|Attrs.HEIGHT
     * @param base  AutoAttr.BASE_WIDTH|AutoAttr.BASE_HEIGHT|AutoAttr.BASE_DEFAULT
     */
    public static void auto(View view, int attrs, int base) {
        AutoLayoutInfo autoLayoutInfo = AutoLayoutInfo.getAttrFromView(view, attrs, base);
        if (autoLayoutInfo != null)
            autoLayoutInfo.fillAttrs(view);
    }

    public static void autoTextSize(View view) {
        auto(view, Attrs.TEXTSIZE, AutoAttr.BASE_DEFAULT);
    }

    public static void autoTextSize(View view, int base) {
        auto(view, Attrs.TEXTSIZE, base);
    }

    public static void autoMargin(View view) {
        auto(view, Attrs.MARGIN, AutoAttr.BASE_DEFAULT);
    }

    public static void autoMargin(View view, int base) {
        auto(view, Attrs.MARGIN, base);
    }

    public static void autoPadding(View view) {
        auto(view, Attrs.PADDING, AutoAttr.BASE_DEFAULT);
    }

    public static void autoPadding(View view, int base) {
        auto(view, Attrs.PADDING, base);
    }

    public static void autoSize(View view) {
        auto(view, Attrs.WIDTH | Attrs.HEIGHT, AutoAttr.BASE_DEFAULT);
    }

    public static void autoSize(View view, int base) {
        auto(view, Attrs.WIDTH | Attrs.HEIGHT, base);
    }

    public static boolean autoed(View view) {
        Object tag = view.getTag(R.id.id_tag_autolayout_size);
        if (tag != null) return true;
        view.setTag(R.id.id_tag_autolayout_size, "Just Identify");
        return false;
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
