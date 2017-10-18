package com.example.the.gugudan;

import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class MainActivity extends BaseActivity {

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
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
                if (index == 3){

                }

            }
        };

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
//        Glide.with(mContext).load(R.drawable.align_icon).into(allViewBtn);
    }

    @Override
    public void bindView() {
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
        this.homeBtn = (ImageView) findViewById(R.id.homeBtn);
        this.allViewBtn = (ImageView) findViewById(R.id.allViewBtn);
    }
}
