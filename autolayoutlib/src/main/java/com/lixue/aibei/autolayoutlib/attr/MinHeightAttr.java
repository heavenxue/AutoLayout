/*
 * Copyright (c) 2016 by xiaoxue. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.lixue.aibei.autolayoutlib.attr;

import android.os.Build;
import android.view.View;

import java.lang.reflect.Field;

/**
 * Created by Administrator on 2016/2/22.
 */
public class MinHeightAttr extends AutoAttr {
    public MinHeightAttr(int pxVal, int baseWidth, int baseHeight) {
        super(pxVal, baseWidth, baseHeight);
    }

    @Override
    protected int attrVal() {
        return Attrs.MIN_HEIGHT;
    }

    @Override
    protected boolean defaultBaseWidth() {
        return true;
    }

    @Override
    protected void execute(View view, int val) {
        try {
            view.setMinimumHeight(val);
//            Method setMaxWidthMethod = view.getClass().getMethod("setMinHeight", int.class);
//            setMaxWidthMethod.invoke(view, val);
        } catch (Exception ignore) {
        }
    }

    public static MinHeightAttr generate(int val, int baseFlag) {
        MinHeightAttr attr = null;
        switch (baseFlag) {
            case AutoAttr.BASE_WIDTH:
                attr = new MinHeightAttr(val, Attrs.MIN_HEIGHT, 0);
                break;
            case AutoAttr.BASE_HEIGHT:
                attr = new MinHeightAttr(val, 0, Attrs.MIN_HEIGHT);
                break;
            case AutoAttr.BASE_DEFAULT:
                attr = new MinHeightAttr(val, 0, 0);
                break;
        }
        return attr;
    }

    public static int getMinHeight(View view) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            return view.getMinimumHeight();
        } else {
            try {
                Field minHeight = view.getClass().getField("mMinHeight");
                minHeight.setAccessible(true);
                return (int) minHeight.get(view);
            } catch (Exception e) {
            }
        }

        return 0;
    }
}
