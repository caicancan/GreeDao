package com.brioal.ttstest.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.brioal.ttstest.R;

/**
 * Created by n009654 on 2018/3/9.
 */

public class SecondActivity extends Activity implements View.OnClickListener {

    private Button change;
    private TextView tv;
    private int number=864000;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        initView();

    }

    private void initView() {
        change = findViewById(R.id.change);
        change.setOnClickListener(this);
        tv = findViewById(R.id.tv);
    }

    @Override
    public void onClick(View v) {
        tv.setText(""+(float)number/1000);

    }
}
