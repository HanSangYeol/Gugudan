package com.sy_studio.the.gugudan_SangYeol;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TabHost;
import android.widget.Toast;

import com.sy_studio.the.gugudan_SangYeol.Adapter.MainPageAdapter;
import com.sy_studio.the.gugudan_SangYeol.Util.ContextUtil;

public class MainActivity extends BaseActivity {

    long backPressedTimeInMillis = 0;

    TabHost myTabHost;

    private ImageView allViewBtn;
    private ImageView homeBtn;
    private ImageView loginBtn;
    private LinearLayout naviLaytout;
    private NavigationView naviView;
    public static DrawerLayout mainDrawLayout;
    private android.support.v4.view.ViewPager mainViewPager;
    private android.support.design.widget.TabLayout tabs;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO - 햄버거 메뉴(로그인/비로그인), setting 창 추가
        // TODO - 맴버 클릭하면 상세정보창
        // TODO - http://blog.naver.com/prologue/PrologueList.nhn?blogId=bausluv&categoryNo=63
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
                mainViewPager.setCurrentItem(0);
            }
        });
    }


    @Override
    public void setValues() {
        mainViewPager.setAdapter(new MainPageAdapter(getSupportFragmentManager()));
        mainViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabs));
        tabs.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(mainViewPager));
//
//        tabs.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
//            @Override
//            public void onTabSelected(TabLayout.Tab tab) {
//                mainViewPager.setCurrentItem(0);
//            }
//
//            @Override
//            public void onTabUnselected(TabLayout.Tab tab) {
//
//            }
//
//            @Override
//            public void onTabReselected(TabLayout.Tab tab) {
//
//            }
//        });

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
        this.mainViewPager = (ViewPager) findViewById(R.id.mainViewPager);
        this.tabs = (TabLayout) findViewById(R.id.tabs);
        this.loginBtn = (ImageView) findViewById(R.id.loginBtn);
        this.homeBtn = (ImageView) findViewById(R.id.homeBtn);
        this.allViewBtn = (ImageView) findViewById(R.id.allViewBtn);
    }
}
