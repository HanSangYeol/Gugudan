package com.sy_studio.the.gugudan_SangYeol;

import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TabHost;
import android.widget.TabWidget;
import android.widget.TextView;

public class NaviActivity extends BaseActivity {

    private android.widget.ImageView backBtn;
    private android.widget.TextView confirmBtn;
    private android.widget.TabWidget tabs;
    private android.widget.LinearLayout galleryLayout;
    private android.widget.LinearLayout tab1;
    private android.widget.LinearLayout videoLayout;
    private android.widget.LinearLayout tab2;
    private android.widget.FrameLayout tabcontent;
    private android.widget.TabHost myTabHost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navi);
        bindView();
        setupEvents();
        setValues();
    }

    @Override
    public void setupEvents() {

    }

    @Override
    public void setValues() {
        makeTabHost();

    }

    private void makeTabHost() {
        TabHost.TabSpec spec1 = myTabHost.newTabSpec("tab1").setIndicator("사진");
        spec1.setContent(R.id.tab1);
        myTabHost.addTab(spec1);

        TabHost.TabSpec spec2 = myTabHost.newTabSpec("tab2").setIndicator("동영상");
        spec2.setContent(R.id.tab2);
        myTabHost.addTab(spec2);
    }

    @Override
    public void bindView() {
        this.myTabHost = (TabHost) findViewById(R.id.myTabHost);
        this.tabcontent = (FrameLayout) findViewById(android.R.id.tabcontent);
        this.tab2 = (LinearLayout) findViewById(R.id.tab2);
        this.videoLayout = (LinearLayout) findViewById(R.id.videoLayout);
        this.tab1 = (LinearLayout) findViewById(R.id.tab1);
        this.galleryLayout = (LinearLayout) findViewById(R.id.galleryLayout);
        this.tabs = (TabWidget) findViewById(android.R.id.tabs);
        this.confirmBtn = (TextView) findViewById(R.id.confirmBtn);
        this.backBtn = (ImageView) findViewById(R.id.backBtn);
    }
}
