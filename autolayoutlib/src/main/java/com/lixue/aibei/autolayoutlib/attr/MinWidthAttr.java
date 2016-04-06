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
public class MinWidthAttr extends AutoAttr {
    public MinWidthAttr(int pxVal, int baseWidth, int baseHeight) {
        super(pxVal, baseWidth, baseHeight);
    }

    @Override
    protected int attrVal() {
        return Attrs.MIN_WIDTH;
    }

    @Override
    protected boolean defaultBaseWidth() {
        return true;
    }

    @Override
    protected void execute(View view, int val) {
        try {
            view.setMinimumWidth(val);
//            Method setMaxWidthMethod = view.getClass().getMethod("setMinWidth", int.class);
//            setMaxWidthMethod.invoke(view, val);
        } catch (Exception ignore) {
        }
    }

    public static int getMinWidth(View view) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN)
            return view.getMinimumWidth();
        try {
            Field minWidth = view.getClass().getField("mMinWidth");
            minWidth.setAccessible(true);
            return (int) minWidth.get(view);
        } catch (Exception ignore) {
        }
        return 0;
    }


    public static MinWidthAttr generate(int val, int baseFlag) {
        MinWidthAttr attr = null;
        switch (baseFlag) {
            case AutoAttr.BASE_WIDTH:
                attr = new MinWidthAttr(val, Attrs.MIN_WIDTH, 0);
                break;
            case AutoAttr.BASE_HEIGHT:
                attr = new MinWidthAttr(val, 0, Attrs.MIN_WIDTH);
                break;
            case AutoAttr.BASE_DEFAULT:
                attr = new MinWidthAttr(val, 0, 0);
                break;
        }
        return attr;
    }
}
