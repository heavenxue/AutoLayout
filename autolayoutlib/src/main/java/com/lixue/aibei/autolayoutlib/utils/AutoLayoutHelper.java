/*
 * Copyright (c) 2016 by xiaoxue. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */
package com.lixue.aibei.autolayoutlib.utils;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;

import com.lixue.aibei.autolayoutlib.AutoLayoutInfo;
import com.lixue.aibei.autolayoutlib.R;
import com.lixue.aibei.autolayoutlib.attr.HeightAttr;
import com.lixue.aibei.autolayoutlib.attr.MarginAttr;
import com.lixue.aibei.autolayoutlib.attr.MarginBottomAttr;
import com.lixue.aibei.autolayoutlib.attr.MarginLeftAttr;
import com.lixue.aibei.autolayoutlib.attr.MarginRightAttr;
import com.lixue.aibei.autolayoutlib.attr.MarginTopAttr;
import com.lixue.aibei.autolayoutlib.attr.MaxHeightAttr;
import com.lixue.aibei.autolayoutlib.attr.MaxWidthAttr;
import com.lixue.aibei.autolayoutlib.attr.MinHeightAttr;
import com.lixue.aibei.autolayoutlib.attr.MinWidthAttr;
import com.lixue.aibei.autolayoutlib.attr.PaddingAttr;
import com.lixue.aibei.autolayoutlib.attr.PaddingBottomAttr;
import com.lixue.aibei.autolayoutlib.attr.PaddingLeftAttr;
import com.lixue.aibei.autolayoutlib.attr.PaddingRightAttr;
import com.lixue.aibei.autolayoutlib.attr.PaddingTopAttr;
import com.lixue.aibei.autolayoutlib.attr.TextSizeAttr;
import com.lixue.aibei.autolayoutlib.attr.WidthAttr;
import com.lixue.aibei.autolayoutlib.config.AutoLayoutConfig;

public class AutoLayoutHelper {
    private static final int[] LL = new int[]{
            android.R.attr.textSize,//字体尺寸
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

    public static AutoLayoutInfo getAutoLayoutInfo(Context context, AttributeSet attributeSet) {
        AutoLayoutInfo layoutInfo = new AutoLayoutInfo();
        TypedArray typedArray = context.obtainStyledAttributes(attributeSet, R.styleable.AutoLayout_Layout);
        int baseWidth = typedArray.getInt(R.styleable.AutoLayout_Layout_layout_auto_basewidth, 0);
        int baseHeight = typedArray.getInt(R.styleable.AutoLayout_Layout_layout_auto_baseheight, 0);
        typedArray.recycle();

        TypedArray array = context.obtainStyledAttributes(attributeSet, LL);

        int n = array.getIndexCount();

        for (int i = 0; i < n; i++) {
            int index = array.getIndex(i);
            if (!isPxVal(array.peekValue(index))) continue;

            int pxVal = 0;
            pxVal = array.getDimensionPixelOffset(index, 0);

            switch (index) {
                case INDEX_TEXT_SIZE:
                    layoutInfo.addAttr(new TextSizeAttr(pxVal, baseWidth, baseHeight));
                    break;
                case INDEX_PADDING:
                    layoutInfo.addAttr(new PaddingAttr(pxVal, baseWidth, baseHeight));
                    break;
                case INDEX_PADDING_LEFT:
                    layoutInfo.addAttr(new PaddingLeftAttr(pxVal, baseWidth, baseHeight));
                    break;
                case INDEX_PADDING_TOP:
                    layoutInfo.addAttr(new PaddingTopAttr(pxVal, baseWidth, baseHeight));
                    break;
                case INDEX_PADDING_RIGHT:
                    layoutInfo.addAttr(new PaddingRightAttr(pxVal, baseWidth, baseHeight));
                    break;
                case INDEX_PADDING_BOTTOM:
                    layoutInfo.addAttr(new PaddingBottomAttr(pxVal, baseWidth, baseHeight));
                    break;
                case INDEX_WIDTH:
                    layoutInfo.addAttr(new WidthAttr(pxVal, baseWidth, baseHeight));
                    break;
                case INDEX_HEIGHT:
                    layoutInfo.addAttr(new HeightAttr(pxVal, baseWidth, baseHeight));
                    break;
                case INDEX_MARGIN:
                    layoutInfo.addAttr(new MarginAttr(pxVal, baseWidth, baseHeight));
                    break;
                case INDEX_MARGIN_LEFT:
                    layoutInfo.addAttr(new MarginLeftAttr(pxVal, baseWidth, baseHeight));
                    break;
                case INDEX_MARGIN_TOP:
                    layoutInfo.addAttr(new MarginTopAttr(pxVal, baseWidth, baseHeight));
                    break;
                case INDEX_MARGIN_RIGHT:
                    layoutInfo.addAttr(new MarginRightAttr(pxVal, baseWidth, baseHeight));
                    break;
                case INDEX_MARGIN_BOTTOM:
                    layoutInfo.addAttr(new MarginBottomAttr(pxVal, baseWidth, baseHeight));
                    break;
                case INDEX_MAX_WIDTH:
                    layoutInfo.addAttr(new MaxWidthAttr(pxVal, baseWidth, baseHeight));
                    break;
                case INDEX_MAX_HEIGHT:
                    layoutInfo.addAttr(new MaxHeightAttr(pxVal, baseWidth, baseHeight));
                    break;
                case INDEX_MIN_WIDTH:
                    layoutInfo.addAttr(new MinWidthAttr(pxVal, baseWidth, baseHeight));
                    break;
                case INDEX_MIN_HEIGHT:
                    layoutInfo.addAttr(new MinHeightAttr(pxVal, baseWidth, baseHeight));
                    break;
            }
        }

        array.recycle();
        L.e(" getAutoLayoutInfo " + layoutInfo.toString());
        return layoutInfo;
    }

    /**
     * 单位是否是像素*
     */
    private static boolean isPxVal(TypedValue value) {
        if (value != null && value.type == value.TYPE_DIMENSION && getComplexUnit(value.data) == TypedValue.COMPLEX_UNIT_PX) {
            return true;
        }
        return false;
    }

    /**
     * (data>>COMPLEX_UNIT_SHIFT)&COMPLEX_UNIT_MASK的作用是将该int值与上0xf，以获取其最低4位，这4位是单位。*
     */
    private static int getComplexUnit(int data) {
        return TypedValue.COMPLEX_UNIT_MASK & (data >> TypedValue.COMPLEX_UNIT_SHIFT);
    }

    /**通过传入一个带有单位的数值，看是否像素单位**/
    private static boolean isPxVal(String val) {
        if (val.endsWith("px")) {
            return true;
        }
        return false;
    }

    /**
     * 初始化配置
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

            if (params instanceof AutoLayoutParams) {
                AutoLayoutInfo info = ((AutoLayoutParams) params).getAutoLayoutInfo();
                if (info != null) {
                    info.fillAttrs(view);
                }
            }
        }

    }

    public interface AutoLayoutParams {
        AutoLayoutInfo getAutoLayoutInfo();
    }
}
