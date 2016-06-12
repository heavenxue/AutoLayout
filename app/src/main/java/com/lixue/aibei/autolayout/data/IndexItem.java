package com.lixue.aibei.autolayout.data;

import android.view.View;

import com.lixue.aibei.autolayout.R;
import com.lixue.aibei.autolayoutlib.utils.AutoUtils;
import com.lixue.aibei.universaladapterlib.item.AdapterItem;

/**
 * Created by Administrator on 2016/6/12.
 */
public class IndexItem implements AdapterItem<String> {

    @Override
    public int getLayoutResId() {
        return R.layout.list_item;
    }

    @Override
    public void bindViews(View root) {
        AutoUtils.autoSize(root);
    }

    @Override
    public void setViews() {

    }

    @Override
    public void handleData(String s, int postion) {

    }
}
