package com.lixue.aibei.autolayoutlib;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;

/**
 * Created by Administrator on 2015/12/31.
 */
public class AutoFrameLayout extends FrameLayout{
    private final AutoLayoutHelper mHelper = new AutoLayoutHelper(this);
    public AutoFrameLayout(Context context) {
        super(context);
    }

    public AutoFrameLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public AutoFrameLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

}
