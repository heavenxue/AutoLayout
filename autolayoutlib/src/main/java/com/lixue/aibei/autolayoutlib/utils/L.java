/*
 * Copyright (c) 2016 by xiaoxue. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.lixue.aibei.autolayoutlib.utils;

import android.util.Log;

/**
 * Created by Administrator on 2016/2/18.
 * 日志打印
 */
public class L {
    public static boolean debug = false;
    private static final String TAG = "AUTO_LAYOUT";

    public static void e(String msg)
    {
        if (debug)
        {
            Log.e(TAG, msg);
        }
    }

}
