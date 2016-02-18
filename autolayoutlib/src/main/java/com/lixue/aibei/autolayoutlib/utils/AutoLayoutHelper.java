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

import com.lixue.aibei.autolayoutlib.config.AutoLayoutConfig;

public class AutoLayoutHelper {
    private static final int[] LL = new int[]{
            android.R.attr.textSize,
            android.R.attr.padding,//
            android.R.attr.paddingLeft,//
            android.R.attr.paddingTop,//
            android.R.attr.paddingRight,//
            android.R.attr.paddingBottom,//
            android.R.attr.layout_width,//
            android.R.attr.layout_height,//
            android.R.attr.layout_margin,//
            android.R.attr.layout_marginLeft,//
            android.R.attr.layout_marginTop,//
            android.R.attr.layout_marginRight,//
            android.R.attr.layout_marginBottom,//
            android.R.attr.maxWidth,//
            android.R.attr.maxHeight,//
            android.R.attr.minWidth,//
            android.R.attr.minHeight,//16843072
    };
    private static final int INDEX_TEXT_SIZE = 0;
    private static final int INDEX_PADDING = 1;
    private static final int INDEX_PADDING_LEFT = 2;
    private static final int INDEX_PADDING_TOP = 3;
    private static final int INDEX_PADDING_RIGHT = 4;
    private static final int INDEX_PADDING_BOTTOM = 5;
    private static final int INDEX_WIDTH = 6;
    private static final int INDEX_HEIGHT = 7;
    private static final int INDEX_MARGIN = 8;
    private static final int INDEX_MARGIN_LEFT = 9;
    private static final int INDEX_MARGIN_TOP = 10;
    private static final int INDEX_MARGIN_RIGHT = 11;
    private static final int INDEX_MARGIN_BOTTOM = 12;
    private static final int INDEX_MAX_WIDTH = 13;
    private static final int INDEX_MAX_HEIGHT = 14;
    private static final int INDEX_MIN_WIDTH = 15;
    private static final int INDEX_MIN_HEIGHT = 16;
    /**
     * move to other place?
     */
    private static AutoLayoutConfig mAutoLayoutConifg;
    private final ViewGroup mHost;

    public AutoLayoutHelper(ViewGroup host) {
        mHost = host;
        if (mAutoLayoutConifg == null) {
            initAutoLayoutConfig(host);
        }
    }

    /**
     * ≥ı ºªØ≈‰÷√
     * *
     */
    private void initAutoLayoutConfig(ViewGroup host) {
        mAutoLayoutConifg = AutoLayoutConfig.getInstance();
        mAutoLayoutConifg.init(mHost.getContext());
    }

    public void adjustChildren() {
        AutoLayoutConfig.getInstance().checkPrams();

        for (int i = 0, n = mHost.getChildCount(); i < n; i++) {
            View view = mHost.getChildAt(i);
            ViewGroup.LayoutParams params = view.getLayoutParams();
//
//            if (params instanceof AutoLayoutParams) {
//                AutoLayoutConfig info =
//                        ((AutoLayoutParams) params).getAutoLayoutInfo();
//                if (info != null) {
//                    info.fillAttrs(view);
//                }
//            }
        }

    }

}
