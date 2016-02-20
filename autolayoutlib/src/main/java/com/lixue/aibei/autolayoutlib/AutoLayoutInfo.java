/*
 * Copyright (c) 2016 by xiaoxue. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.lixue.aibei.autolayoutlib;

import android.view.View;

import com.lixue.aibei.autolayoutlib.attr.AutoAttr;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/2/19.
 */
public class AutoLayoutInfo {
    private List<AutoAttr> autoAttrs = new ArrayList<>();

    public void addAttr(AutoAttr autoAttr) {
        autoAttrs.add(autoAttr);
    }


    public void fillAttrs(View view) {
        for (AutoAttr autoAttr : autoAttrs) {
            autoAttr.apply(view);
        }
    }

    @Override
    public String toString() {
        return "AutoLayoutInfo{" +
                "autoAttrs=" + autoAttrs +
                '}';
    }
}
