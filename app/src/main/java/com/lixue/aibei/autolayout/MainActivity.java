package com.lixue.aibei.autolayout;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;

import com.lixue.aibei.autolayoutlib.AutoLayoutActivity;
import com.lixue.aibei.autolayoutlib.utils.AutoUtils;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AutoLayoutActivity implements View.OnClickListener{
    private ListView mListView;
    private List<String> mList;
    private Button btn_next;
    private ImageView btn_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setImmersionStatus();
        setContentView(R.layout.fragment_list);

        initView();
        initDatas();

    }

    private void setImmersionStatus(){
        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.KITKAT){
            //透明状态栏
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            //透明导航栏
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        }
    }

    private void initView(){
        mListView = (ListView) findViewById(R.id.id_listview);
        btn_next = (Button) findViewById(R.id.title_next);
        btn_back = (ImageView) findViewById(R.id.title_leftimageview);
    }

    private void initDatas(){
        mList = new ArrayList<String>();
        for (int i = 0; i < 50; i++) {
            mList.add(i + "");
        }
        mListView.setAdapter(new MyAdapter());
        btn_next.setOnClickListener(this);
        btn_back.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        switch (id){
            case R.id.title_next:
                Intent intent = new Intent();
                intent.setAction("com.lixue.android.regist");
                startActivity(intent);
                break;
            case R.id.title_leftimageview:
                finish();
                break;
            default:
                break;
        }
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
                convertView = LayoutInflater.from(MainActivity.this).inflate(R.layout.list_item, parent, false);
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
