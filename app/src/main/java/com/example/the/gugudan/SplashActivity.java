package com.example.the.gugudan;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.the.gugudan.Util.GlobalData;

public class SplashActivity extends BaseActivity {

    private android.widget.ImageView iconImg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splish);
        bindView();
        setupEvents();
        setValues();
    }

    @Override
    public void setupEvents() {

    }

    @Override
    public void setValues() {

        GlobalData.postData();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent intent = new Intent(mContext, MainActivity.class);
                startActivity(intent);
                finish();

            }
        }, 2000);

        Glide.with(mContext).load(R.drawable.gugudan_icon_1).into(iconImg);

    }

    @Override
    public void bindView() {
        this.iconImg = (ImageView) findViewById(R.id.iconImg);
    }
}
