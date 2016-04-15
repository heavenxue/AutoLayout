package com.lixue.aibei.autolayout;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class ThirdActivity extends Activity implements View.OnClickListener {
    private Button btn_next;
    private ImageView btn_back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_pay);
        btn_next = (Button) findViewById(R.id.title_next);
        btn_back = (ImageView) findViewById(R.id.title_leftimageview);
        btn_next.setOnClickListener(this);
        btn_back.setOnClickListener(this);
    }
    @Override
    public void onClick(View view) {
        int id = view.getId();
        switch (id){
            case R.id.title_next:
                Intent intent = new Intent();
                intent.setAction("com.lixue.android.pay");
                startActivity(intent);
                break;
            case R.id.title_leftimageview:
                finish();
                break;
            default:
                break;
        }
    }
}
