package com.sy_studio.the.gugudan_SangYeol;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.sy_studio.the.gugudan_SangYeol.Fragment.VideoFrag;
import com.sy_studio.the.gugudan_SangYeol.Util.ContextUtil;

public class MainActivity extends BaseActivity {

    long backPressedTimeInMillis = 0;

    private android.widget.ImageView allViewBtn;
    private android.widget.ImageView homeBtn;
    private android.widget.TextView galleryBtn;
    private android.widget.TextView videoBtn;
    private android.widget.TextView scheduleBtn;
    private android.widget.TextView qaBtn;
    private android.widget.LinearLayout galleryLayout;
    private LinearLayout scheduleLayout;
    private LinearLayout qaFragLayout;
    private TextView noticeBtn;
    private LinearLayout noticeLayout;
    private LinearLayout videoLayout;
    private TextView memberBtn;
    private LinearLayout memberLayout;
    private ImageView loginBtn;
    private LinearLayout naviLaytout;
    private android.support.design.widget.NavigationView naviView;
    private android.support.v4.widget.DrawerLayout mainDrawLayout;


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
        View.OnClickListener homeClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LinearLayout[] frags = {noticeLayout, memberLayout, galleryLayout, videoLayout, scheduleLayout, qaFragLayout};
                TextView[] text = {noticeBtn, memberBtn, galleryBtn, videoBtn, scheduleBtn, qaBtn};
                for (TextView textView : text) {
                    textView.setTypeface(null, Typeface.NORMAL);
                }
                for (LinearLayout linearLayout : frags) {
                    linearLayout.setVisibility(View.GONE);
                }
                frags[0].setVisibility(View.VISIBLE);
                text[0].setTypeface(null, Typeface.BOLD);
//                VideoFrag.youtubePlayer.pause();
            }
        };

        View.OnClickListener clickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int index = Integer.parseInt(view.getTag().toString());
                LinearLayout[] frags = {noticeLayout, memberLayout, galleryLayout, videoLayout, scheduleLayout, qaFragLayout};
                TextView[] text = {noticeBtn, memberBtn, galleryBtn, videoBtn, scheduleBtn, qaBtn};
                for (TextView textView : text) {
                    textView.setTypeface(null, Typeface.NORMAL);
                }
                for (LinearLayout linearLayout : frags) {
                    linearLayout.setVisibility(View.GONE);
                }
                text[index].setTypeface(null, Typeface.BOLD);
                frags[index].setVisibility(View.VISIBLE);
//                if (!(index == 3)){
//                    VideoFrag.youtubePlayer.pause();
//                }

            }
        };

        homeBtn.setOnClickListener(homeClickListener);
        noticeBtn.setOnClickListener(clickListener);
        memberBtn.setOnClickListener(clickListener);
        galleryBtn.setOnClickListener(clickListener);
        videoBtn.setOnClickListener(clickListener);
        scheduleBtn.setOnClickListener(clickListener);
        qaBtn.setOnClickListener(clickListener);
    }


    @Override
    public void setValues() {
        Glide.with(mContext).load(R.drawable.gugudan_icon_1).into(homeBtn);

    }

    public void homeChange(){
        LinearLayout[] frags = {noticeLayout, memberLayout, galleryLayout, videoLayout, scheduleLayout, qaFragLayout};
        TextView[] text = {noticeBtn, memberBtn, galleryBtn, videoBtn, scheduleBtn, qaBtn};
        for (TextView textView : text) {
            textView.setTypeface(null, Typeface.NORMAL);
        }
        for (LinearLayout linearLayout : frags) {
            linearLayout.setVisibility(View.GONE);
        }
        frags[0].setVisibility(View.VISIBLE);
        text[0].setTypeface(null, Typeface.BOLD);
        VideoFrag.youtubePlayer.pause();
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
        this.qaFragLayout = (LinearLayout) findViewById(R.id.qaFragLayout);
        this.scheduleLayout = (LinearLayout) findViewById(R.id.scheduleLayout);
        this.videoLayout = (LinearLayout) findViewById(R.id.videoLayout);
        this.galleryLayout = (LinearLayout) findViewById(R.id.galleryLayout);
        this.memberLayout = (LinearLayout) findViewById(R.id.memberLayout);
        this.noticeLayout = (LinearLayout) findViewById(R.id.noticeLayout);
        this.qaBtn = (TextView) findViewById(R.id.qaBtn);
        this.scheduleBtn = (TextView) findViewById(R.id.scheduleBtn);
        this.videoBtn = (TextView) findViewById(R.id.videoBtn);
        this.galleryBtn = (TextView) findViewById(R.id.galleryBtn);
        this.memberBtn = (TextView) findViewById(R.id.memberBtn);
        this.noticeBtn = (TextView) findViewById(R.id.noticeBtn);
        this.loginBtn = (ImageView) findViewById(R.id.loginBtn);
        this.homeBtn = (ImageView) findViewById(R.id.homeBtn);
        this.allViewBtn = (ImageView) findViewById(R.id.allViewBtn);
    }
}
