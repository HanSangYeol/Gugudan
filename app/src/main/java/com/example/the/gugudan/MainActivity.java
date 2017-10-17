package com.example.the.gugudan;

import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class MainActivity extends BaseActivity {

    private android.widget.ImageView allViewBtn;
    private android.widget.ImageView homeBtn;
    private android.widget.TextView galleryBtn;
    private android.widget.TextView videoBtn;
    private android.widget.TextView scheduleBtn;
    private android.widget.TextView eventBtn;
    private android.widget.TextView qaBtn;

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

        View.OnClickListener textStyle = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int index = Integer.parseInt(view.getTag().toString());
                TextView[] text = {galleryBtn, videoBtn, scheduleBtn, eventBtn, qaBtn};
                for (TextView textView : text){
                    textView.setTypeface(null, Typeface.NORMAL);
                }
                text[index].setTypeface(null, Typeface.BOLD);

            }
        };

        galleryBtn.setOnClickListener(textStyle);
        videoBtn.setOnClickListener(textStyle);
        scheduleBtn.setOnClickListener(textStyle);
        eventBtn.setOnClickListener(textStyle);
        qaBtn.setOnClickListener(textStyle);
    }

    @Override
    public void setValues() {
        Glide.with(mContext).load(R.drawable.gugudan_icon_1).into(homeBtn);
        Glide.with(mContext).load(R.drawable.align_icon).into(allViewBtn);
    }

    @Override
    public void bindView() {

        this.qaBtn = (TextView) findViewById(R.id.qaBtn);
        this.eventBtn = (TextView) findViewById(R.id.eventBtn);
        this.scheduleBtn = (TextView) findViewById(R.id.scheduleBtn);
        this.videoBtn = (TextView) findViewById(R.id.videoBtn);
        this.galleryBtn = (TextView) findViewById(R.id.galleryBtn);
        this.homeBtn = (ImageView) findViewById(R.id.homeBtn);
        this.allViewBtn = (ImageView) findViewById(R.id.allViewBtn);
    }
}
