package com.sy_studio.the.gugudan_SangYeol;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TabHost;
import android.widget.TabWidget;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.sy_studio.the.gugudan_SangYeol.Util.ContextUtil;

public class MainActivity extends BaseActivity {

    long backPressedTimeInMillis = 0;

    TabHost myTabHost;

    private ImageView allViewBtn;
    private ImageView homeBtn;
    private ImageView loginBtn;
    private android.widget.TabWidget tabs;
    private LinearLayout tab1;
    private LinearLayout tab2;
    private LinearLayout tab3;
    private LinearLayout tab4;
    private android.widget.FrameLayout tabcontent;
    private LinearLayout naviLaytout;
    private NavigationView naviView;
    public static DrawerLayout mainDrawLayout;
    private LinearLayout noticeLayout;
    private LinearLayout memberLayout;
    private LinearLayout scheduleLayout;
    private LinearLayout qaFragLayout;
    private LinearLayout tab5;
    private LinearLayout timeLineLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO - 동영상 데이터 추가
        // TODO - 갤러리 Glide사용
        // TODO - 햄버거 메뉴(로그인/비로그인)
        // TODO - 맴버 클릭하면 상세정보창
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bindView();
        setupEvents();
        setValues();
    }

    @Override
    public void setupEvents() {
        allViewBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mainDrawLayout.openDrawer(GravityCompat.START);
            }
        });
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(mContext, SignActivity.class);
                startActivity(myIntent);
            }
        });
        homeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myTabHost.setCurrentTab(0);
            }
        });
    }


    @Override
    public void setValues() {
        Glide.with(mContext).load(R.drawable.gugudan_icon_1).into(homeBtn);
        makeTabHost();

    }

    private void makeTabHost() {
        myTabHost.setup();

        TabHost.TabSpec spec1 = myTabHost.newTabSpec("tab1").setIndicator("공지사항");
        spec1.setContent(R.id.tab1);
        myTabHost.addTab(spec1);


        TabHost.TabSpec spec2 = myTabHost.newTabSpec("tab2").setIndicator("타임라인");
        spec2.setContent(R.id.tab2);
        myTabHost.addTab(spec2);

        TabHost.TabSpec spec3 = myTabHost.newTabSpec("tab3").setIndicator("맴버");
        spec3.setContent(R.id.tab3);
        myTabHost.addTab(spec3);

        TabHost.TabSpec spec4 = myTabHost.newTabSpec("tab4").setIndicator("스케줄");
        spec4.setContent(R.id.tab4);
        myTabHost.addTab(spec4);

        TabHost.TabSpec spec5 = myTabHost.newTabSpec("tab5").setIndicator("게시판");
        spec5.setContent(R.id.tab5);
        myTabHost.addTab(spec5);

    }

    public void homeChange(){
        myTabHost.setCurrentTab(0);
    }

    @Override
    public void onBackPressed() {
        if (this.mainDrawLayout.isDrawerOpen(GravityCompat.START)) {
            this.mainDrawLayout.closeDrawer(GravityCompat.START);
        } else {
            long currentTimeInMillis = System.currentTimeMillis();

            if (currentTimeInMillis - backPressedTimeInMillis < 2000) {
                ContextUtil.logout(mContext);
                finish();
                return;
            } else {
                Toast.makeText(mContext, "한번 더 누르면 앱이 종료됩니다.", Toast.LENGTH_SHORT).show();
            }

            backPressedTimeInMillis = currentTimeInMillis;
        }


    }

    @Override
    public void bindView() {
        this.mainDrawLayout = (DrawerLayout) findViewById(R.id.mainDrawLayout);
        this.naviView = (NavigationView) findViewById(R.id.naviView);
        this.naviLaytout = (LinearLayout) findViewById(R.id.naviLaytout);
        this.myTabHost = (TabHost) findViewById(R.id.myTabHost);
        this.tabcontent = (FrameLayout) findViewById(android.R.id.tabcontent);
        this.tab5 = (LinearLayout) findViewById(R.id.tab5);
        this.qaFragLayout = (LinearLayout) findViewById(R.id.qaFragLayout);
        this.tab4 = (LinearLayout) findViewById(R.id.tab4);
        this.scheduleLayout = (LinearLayout) findViewById(R.id.scheduleLayout);
        this.tab3 = (LinearLayout) findViewById(R.id.tab3);
        this.memberLayout = (LinearLayout) findViewById(R.id.memberLayout);
        this.tab2 = (LinearLayout) findViewById(R.id.tab2);
        this.timeLineLayout = (LinearLayout) findViewById(R.id.timeLineLayout);
        this.tab1 = (LinearLayout) findViewById(R.id.tab1);
        this.noticeLayout = (LinearLayout) findViewById(R.id.noticeLayout);
        this.tabs = (TabWidget) findViewById(android.R.id.tabs);
        this.loginBtn = (ImageView) findViewById(R.id.loginBtn);
        this.homeBtn = (ImageView) findViewById(R.id.homeBtn);
        this.allViewBtn = (ImageView) findViewById(R.id.allViewBtn);
    }
}
