package com.zhiyuan3g.jiguang;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import cn.jpush.android.api.JPushInterface;

public class MainActivity extends AppCompatActivity {

    Button btnStart, btnStop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        JPushInterface.setDebugMode(true);
        JPushInterface.init(this);

        btnStart = (Button) findViewById(R.id.btnStart);
        btnStop = (Button) findViewById(R.id.btnStop);


        btnStop.setOnClickListener(btnStopListener);
        btnStart.setOnClickListener(btnStartListener);
    }

    View.OnClickListener btnStopListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            JPushInterface.resumePush(getApplicationContext());
        }
    };
    View.OnClickListener btnStartListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            JPushInterface.stopPush(getApplicationContext());
        }
    };
}
