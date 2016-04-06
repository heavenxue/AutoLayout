/*
 * Copyright (c) 2016 by xiaoxue. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.lixue.aibei.autolayoutlib.attr;

import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Administrator on 2016/2/22.
 */
public class WidthAttr extends AutoAttr {
    public WidthAttr(int pxVal, int baseWidth, int baseHeight) {
        super(pxVal, baseWidth, baseHeight);
    }

    @Override
    protected int attrVal() {
        return Attrs.WIDTH;
    }

    @Override
    protected boolean defaultBaseWidth() {
        return true;
    }

    @Override
    protected void execute(View view, int val) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        layoutParams.width = getPercentWidthSize();
    }

    public static WidthAttr generate(int val, int baseFlag) {
        WidthAttr widthAttr = null;
        switch (baseFlag) {
            case AutoAttr.BASE_WIDTH:
                widthAttr = new WidthAttr(val, Attrs.WIDTH, 0);
                break;
            case AutoAttr.BASE_HEIGHT:
                widthAttr = new WidthAttr(val, 0, Attrs.WIDTH);
                break;
            case AutoAttr.BASE_DEFAULT:
                widthAttr = new WidthAttr(val, 0, 0);
                break;
        }
        return widthAttr;
    }
}
