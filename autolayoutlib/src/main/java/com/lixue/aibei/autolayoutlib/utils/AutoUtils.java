/*
 * Copyright (c) 2016 by xiaoxue. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.lixue.aibei.autolayoutlib.utils;

import com.lixue.aibei.autolayoutlib.config.AutoLayoutConfig;

/**
 * Created by Administrator on 2016/2/19.
 */
public class AutoUtils {

    /**最大宽度尺寸的百分比**/
    public static int getPercentWidthSizeBigger(int val){
        int screenWidth = AutoLayoutConfig.getInstance().getScreenWidth();
        int designWidth = AutoLayoutConfig.getInstance().getDesignWidth();
        int res= val * screenWidth;
        if (res % designWidth == 0){
            return res / designWidth;
        }else{
            return  res / designWidth + 1;
        }
    }

    public static int getPercentHeightSizeBigger(int val){
        int screenHeight = AutoLayoutConfig.getInstance().getScreenHeight();
        int designHeight = AutoLayoutConfig.getInstance().getDesignHeight();
        int res = val * screenHeight;
        if (res % designHeight == 0){
            return res/designHeight;
        }else {
            return res / designHeight +1 ;
        }
    }

}
