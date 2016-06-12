package com.lixue.aibei.autolayout;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.widget.ListView;

import com.lixue.aibei.autolayout.data.IndexItem;
import com.lixue.aibei.autolayoutlib.AutoLayoutActivity;
import com.lixue.aibei.autolayoutlib.utils.L;
import com.lixue.aibei.universaladapterlib.UniversalAdapter;
import com.lixue.aibei.universaladapterlib.item.AdapterItem;

import java.util.ArrayList;
import java.util.List;

public class IndexActivity extends AutoLayoutActivity {
    private ListView listView;
    private List<String> mList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payhub);
        initView();
        initData();
        L.debug = true;
    }

    private void initView(){
        listView = (ListView) findViewById(R.id.listview);
    }

    private void initData(){
        mList = new ArrayList<String>();
        for (int i = 0; i < 50; i++) {
            mList.add(i + "");
        }
//        listView.setAdapter(new MyAdapter());
        listView.setAdapter(new UniversalAdapter<String>(mList) {
            @NonNull
            @Override
            public AdapterItem createItem(Object type) {
                return new IndexItem();
            }
        });
    }
}
