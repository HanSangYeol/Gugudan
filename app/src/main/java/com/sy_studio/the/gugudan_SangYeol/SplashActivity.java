package com.sy_studio.the.gugudan_SangYeol;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.sy_studio.the.gugudan_SangYeol.Util.ContextUtil;
import com.sy_studio.the.gugudan_SangYeol.Util.GlobalData;
import com.sy_studio.the.gugudan_SangYeol.Util.ServerUtil;

import org.json.JSONException;
import org.json.JSONObject;

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

        GlobalData.userData();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent intent = new Intent(mContext, MainActivity.class);
                startActivity(intent);
                finish();

            }
        }, 2000);

        Glide.with(mContext).load(R.drawable.gugudan_icon_1).into(iconImg);

        ServerUtil.FacebookAccessToken(mContext, new ServerUtil.JsonResponseHandler() {
            @Override
            public void onResponse(JSONObject json) {
                try {
                    ContextUtil.access_token =  json.getString("access_token");
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        });

    }

    @Override
    public void bindView() {
        this.iconImg = (ImageView) findViewById(R.id.iconImg);
    }
}
