package com.brioal.ttstest.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;

import com.brioal.ttstest.R;


public class StartLaunchActivity extends Activity implements View.OnClickListener{

    private Button first;
    private Button second;
    private Button third;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_launch);
        initView();



    }

    private void initView() {
        first = findViewById(R.id.first);
        first.setOnClickListener(this);
        second = findViewById(R.id.second);
        second.setOnClickListener(this);
        third = findViewById(R.id.third);
        third.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.first:
                Intent intent = new Intent(this, GreenDaoActivity.class);
                startActivity(intent);
                break;
            case R.id.second:
                Intent intent1 = new Intent(this, LoadImageActivity.class);
                startActivity(intent1);

                break;
            case R.id.third:

                break;
        }
    }
}
