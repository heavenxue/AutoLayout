/*
 * Copyright (c) 2016 by xiaoxue. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.lixue.aibei.autolayoutlib.attr;

import android.view.View;

import java.lang.reflect.Method;

/**
 * Created by Administrator on 2016/2/22.
 */
public class MaxWidthAttr extends AutoAttr {
    public MaxWidthAttr(int pxVal, int baseWidth, int baseHeight) {
        super(pxVal, baseWidth, baseHeight);
    }

    @Override
    protected int attrVal() {
        return Attrs.MAX_WIDTH;
    }

    @Override
    protected boolean defaultBaseWidth() {
        return true;
    }

    @Override
    protected void execute(View view, int val) {
        try {
            Method setMaxWidthMethod = view.getClass().getMethod("setMaxWidth", int.class);
            setMaxWidthMethod.invoke(view, val);
        } catch (Exception ignore) {
        }
    }

    public static MaxWidthAttr generate(int val, int baseFlag) {
        MaxWidthAttr attr = null;
        switch (baseFlag) {
            case AutoAttr.BASE_WIDTH:
                attr = new MaxWidthAttr(val, Attrs.MAX_WIDTH, 0);
                break;
            case AutoAttr.BASE_HEIGHT:
                attr = new MaxWidthAttr(val, 0, Attrs.MAX_WIDTH);
                break;
            case AutoAttr.BASE_DEFAULT:
                attr = new MaxWidthAttr(val, 0, 0);
                break;
        }
        return attr;
    }

    public static int getMaxWidth(View view) {
        try {
            Method setMaxWidthMethod = view.getClass().getMethod("getMaxWidth");
            return (int) setMaxWidthMethod.invoke(view);
        } catch (Exception ignore) {
        }
        return 0;
    }
}
