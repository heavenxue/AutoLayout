package com.lixue.aibei.autolayout;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.util.TypedValue;
import android.view.Display;
import android.view.Menu;
import android.view.MenuItem;
import android.view.WindowManager;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {
    private TextView textView;

    public int sp2dp2(float spVal){
             return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, spVal,getResources().getDisplayMetrics());
        }

    public float sp2dp1(float pxVal){
        //scale是一个约等数，接近密度
        float scale = getResources().getDisplayMetrics().density;
        // 方法1 Android获得屏幕的宽和高
        WindowManager windowManager = getWindowManager();
        Display display = windowManager.getDefaultDisplay();
        int screenWidth = screenWidth = display.getWidth();
        int screenHeight = screenHeight = display.getHeight();

        Log.d("sp2dp1","scale:" + scale );
        Log.d("screen","屏幕的分辨率，宽："+ screenWidth + ",高:" + screenHeight);
        return  (pxVal /scale + 0.5f * (pxVal >= 0 ? 1:-1));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView) findViewById(R.id.tv_show);
        textView.setText("100px转换为dp(第一种方法):" + sp2dp1(100) + "\n" +"第二种方法:" +sp2dp2(100));


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
