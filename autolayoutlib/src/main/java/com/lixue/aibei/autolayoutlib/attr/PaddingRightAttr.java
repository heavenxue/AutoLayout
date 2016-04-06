/*
 * Copyright (c) 2016 by xiaoxue. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.lixue.aibei.autolayoutlib.attr;

import android.view.View;

/**
 * Created by Administrator on 2016/2/22.
 */
public class PaddingRightAttr extends AutoAttr {
    public PaddingRightAttr(int pxVal, int baseWidth, int baseHeight) {
        super(pxVal, baseWidth, baseHeight);
    }

    @Override
    protected int attrVal() {
        return Attrs.PADDING_RIGHT;
    }

    @Override
    protected boolean defaultBaseWidth() {
        return true;
    }

    @Override
    protected void execute(View view, int val) {
        int l = view.getPaddingLeft();
        int t = view.getPaddingTop();
        int r = val;
        int b = view.getPaddingBottom();
        view.setPadding(l,t,r,b);
    }

    public static PaddingRightAttr generate(int val, int baseFlag) {
        PaddingRightAttr attr = null;
        switch (baseFlag) {
            case AutoAttr.BASE_WIDTH:
                attr = new PaddingRightAttr(val, Attrs.PADDING_RIGHT, 0);
                break;
            case AutoAttr.BASE_HEIGHT:
                attr = new PaddingRightAttr(val, 0, Attrs.PADDING_RIGHT);
                break;
            case AutoAttr.BASE_DEFAULT:
                attr = new PaddingRightAttr(val, 0, 0);
                break;
        }
        return attr;
    }
}
