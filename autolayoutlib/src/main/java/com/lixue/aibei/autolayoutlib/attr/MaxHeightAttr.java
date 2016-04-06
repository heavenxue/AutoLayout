/*
 * Copyright (c) 2016 by xiaoxue. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.lixue.aibei.autolayoutlib.attr;

import android.view.View;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by Administrator on 2016/2/22.
 */
public class MaxHeightAttr extends AutoAttr{
    public MaxHeightAttr(int pxVal, int baseWidth, int baseHeight) {
        super(pxVal, baseWidth, baseHeight);
    }

    @Override
    protected int attrVal() {
        return Attrs.MAX_HEIGHT;
    }

    @Override
    protected boolean defaultBaseWidth() {
        return true;
    }

    @Override
    protected void execute(View view, int val) {
        try {
            Method heightMethod = view.getClass().getMethod("setMaxHeight",int.class);
            heightMethod.invoke(view,val);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public static MaxHeightAttr generate(int val, int baseFlag) {
        MaxHeightAttr attr = null;
        switch (baseFlag) {
            case AutoAttr.BASE_WIDTH:
                attr = new MaxHeightAttr(val, Attrs.MAX_HEIGHT, 0);
                break;
            case AutoAttr.BASE_HEIGHT:
                attr = new MaxHeightAttr(val, 0, Attrs.MAX_HEIGHT);
                break;
            case AutoAttr.BASE_DEFAULT:
                attr = new MaxHeightAttr(val, 0, 0);
                break;
        }
        return attr;
    }

    public static int getMaxHeight(View view) {
        try {
            Method setMaxWidthMethod = view.getClass().getMethod("getMaxHeight");
            return (int) setMaxWidthMethod.invoke(view);
        } catch (Exception ignore) {
        }
        return 0;
    }
}
