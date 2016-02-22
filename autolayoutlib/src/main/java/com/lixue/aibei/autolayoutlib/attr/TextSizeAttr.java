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
public class TextSizeAttr extends AutoAttr{

    public TextSizeAttr(int pxVal, int baseWidth, int baseHeight) {
        super(pxVal, baseWidth, baseHeight);
    }

    @Override
    protected int attrVal() {
        return Attrs.TEXTSIZE;
    }

    @Override
    protected boolean defaultBaseWidth() {
        return false;
    }

    @Override
    protected void execute(View view, int val) {
        view.setPadding(val,val,val,val);
    }

    @Override
    public void apply(View view) {
        int l,t,r,b;
        if (useDefault()){
            l = r = getPercentWidthSize();
            t = b = getPercentHeightSize();
            view.setPadding(l,t,r,b);
            return;
        }
        super.apply(view);
    }
}
