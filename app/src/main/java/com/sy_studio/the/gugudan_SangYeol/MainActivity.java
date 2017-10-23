package com.sy_studio.the.gugudan_SangYeol;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
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
    private android.widget.TextView noticeBtn;
    private android.widget.TextView memberBtn;
    private android.widget.TextView scheduleBtn;
    private TextView timeLineBtn;
    private TextView qaBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO - 동영상 데이터 추가
        // TODO - 갤러리 Glide사용
        // TODO - 햄버거 메뉴(로그인/비로그인), setting 창 추가
        // TODO - 맴버 클릭하면 상세정보창
        // TODO - https://github.com/astuetz/PagerSlidingTabStrip // PagerSlidingTabStrip 메인 TabHost, ViewPager
        // TODO -
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bindView();
        setupEvents();
        setValues();
    }

    @Override
    public void setupEvents() {
        View.OnClickListener clickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int index = Integer.parseInt(view.getTag().toString());
                TextView[] text = {noticeBtn, timeLineBtn, memberBtn, scheduleBtn, qaBtn};
                for (TextView textView : text) {
                    textView.setTypeface(null, Typeface.NORMAL);
                }
                text[index].setTypeface(null, Typeface.BOLD);
                mainViewPager.setCurrentItem(index);

            }
        };

        noticeBtn.setOnClickListener(clickListener);
        timeLineBtn.setOnClickListener(clickListener);
        memberBtn.setOnClickListener(clickListener);
        scheduleBtn.setOnClickListener(clickListener);
        qaBtn.setOnClickListener(clickListener);

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
        mainViewPager.setCurrentItem(0);
        mainViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                TextView[] text = {noticeBtn, timeLineBtn, memberBtn, scheduleBtn, qaBtn};
                for (TextView textView : text) {
                    textView.setTypeface(null, Typeface.NORMAL);
                }
                text[position].setTypeface(null, Typeface.BOLD);
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        Glide.with(mContext).load(R.drawable.gugudan_icon_1).into(homeBtn);

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
        this.qaBtn = (TextView) findViewById(R.id.qaBtn);
        this.scheduleBtn = (TextView) findViewById(R.id.scheduleBtn);
        this.memberBtn = (TextView) findViewById(R.id.memberBtn);
        this.timeLineBtn = (TextView) findViewById(R.id.timeLineBtn);
        this.noticeBtn = (TextView) findViewById(R.id.noticeBtn);
        this.loginBtn = (ImageView) findViewById(R.id.loginBtn);
        this.homeBtn = (ImageView) findViewById(R.id.homeBtn);
        this.allViewBtn = (ImageView) findViewById(R.id.allViewBtn);
    }
}
