/*
 * Copyright (c) 2016 by xiaoxue. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.lixue.aibei.autolayoutlib.attr;

import android.view.View;

import com.lixue.aibei.autolayoutlib.utils.AutoUtils;
import com.lixue.aibei.autolayoutlib.utils.L;

/**
 * Created by Administrator on 2016/2/19.
 */
public abstract class AutoAttr {
    protected int pxVal;
    protected int baseWidth;
    protected int baseHeight;

    public AutoAttr(int pxVal, int baseWidth, int baseHeight) {
        this.pxVal = pxVal;
        this.baseWidth = baseWidth;
        this.baseHeight = baseHeight;
    }

    public void apply(View view) {
        boolean log = view.getTag() != null && view.getTag().toString().equals("auto");
        if (log) {
            L.e("pxval = " + pxVal + "," + this.getClass().getSimpleName());
        }
        int val;
        //使用默认尺寸
        if (useDefault()) {
            val = defaultBaseWidth() ? getPercentWidthSize() : getPercentHeightSize();
            if (log) {
                L.e(" useDefault val= " + val);
            }
        } else if (baseWidth()) {
            val = getPercentWidthSize();
            if (log) {
                L.e(" baseWidth val= " + val);
            }
        } else {
            val = getPercentHeightSize();
            if (log) {
                L.e(" baseHeight val= " + val);
            }
        }

        val = Math.max(val, 1);//for very thin divider
        execute(view, val);
    }

    protected int getPercentWidthSize() {
        return AutoUtils.getPercentWidthSizeBigger(pxVal);
    }

    protected int getPercentHeightSize() {
        return AutoUtils.getPercentHeightSizeBigger(pxVal);
    }


    protected boolean baseWidth() {
        return contains(baseWidth, attrVal());
    }

    protected boolean useDefault() {
        return !contains(baseHeight, attrVal()) && !contains(baseWidth, attrVal());
    }

    protected boolean contains(int baseVal, int flag) {
        /**0&0=0;   0&1=0;    1&0=0;     1&1=1;如果其中一个为0则true**/
        return (baseVal & flag) != 0;
    }

    protected abstract int attrVal();

    protected abstract boolean defaultBaseWidth();

    protected abstract void execute(View view, int val);

    @Override
    public String toString() {
        return "AutoAttr{" +
                "pxVal=" + pxVal +
                ", baseWidth=" + baseWidth() +
                ", defaultBaseWidth=" + defaultBaseWidth() +
                '}';
    }

}
