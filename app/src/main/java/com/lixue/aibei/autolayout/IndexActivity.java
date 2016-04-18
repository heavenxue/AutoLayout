package com.lixue.aibei.autolayout;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;

import com.lixue.aibei.autolayoutlib.AutoLayoutActivity;
import com.lixue.aibei.autolayoutlib.utils.AutoUtils;
import com.lixue.aibei.autolayoutlib.utils.L;

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
        listView.setAdapter(new MyAdapter());
    }

    class MyAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return mList.size();
        }

        @Override
        public Object getItem(int arg0) {
            return mList.get(arg0);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder holder = null;
            if (convertView == null) {
                holder = new ViewHolder();
                convertView = LayoutInflater.from(IndexActivity.this).inflate(R.layout.list_item, parent, false);
                convertView.setTag(holder);
                /**对于listview，注意添加这一行，即可在item上使用高度**/
                AutoUtils.autoSize(convertView);
            } else {
                holder = (ViewHolder) convertView.getTag();
            }

            return convertView;
        }

    }

    class ViewHolder {

    }
}
