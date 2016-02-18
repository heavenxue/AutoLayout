/*
 * Copyright (c) 2016 by xiaoxue. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.lixue.aibei.autolayoutlib.utils;

import android.content.Context;
import android.graphics.Point;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;

/**
 * Created by Administrator on 2016/2/18.
 */
public class ScreenUtils {
    public static int[] getScreenSize(Context context,boolean useDeviceSize){
        int[] size = new int[2];

        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        Display dp = wm.getDefaultDisplay();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        dp.getMetrics(displayMetrics);
        //since SDK_INT = 1 ;
        int widthPixels = displayMetrics.widthPixels;
        int heightPixels = displayMetrics.heightPixels;
        if (!useDeviceSize){
            size[0] = widthPixels;
            size[1] = heightPixels;
            return size;
        }

        //incluedes window decorations(statusbar/menubar)
        if (Build.VERSION.SDK_INT >= 14 && Build.VERSION.SDK_INT <17){
            try
            {
                widthPixels = (Integer) Display.class.getMethod("getRawWidth").invoke(dp);
                heightPixels = (Integer) Display.class.getMethod("getRawHeight").invoke(dp);
            } catch (Exception ignored)
            {
            }
        }
        // includes window decorations (statusbar bar/menu bar)
        if (Build.VERSION.SDK_INT >= 17)
            try
            {
                Point realSize = new Point();
                Display.class.getMethod("getRealSize", Point.class).invoke(dp, realSize);
                widthPixels = realSize.x;
                heightPixels = realSize.y;
            } catch (Exception ignored)
            {
            }
        size[0] = widthPixels;
        size[1] = heightPixels;
        return size;

    }
}
