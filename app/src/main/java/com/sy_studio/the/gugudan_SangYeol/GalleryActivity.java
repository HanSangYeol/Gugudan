package com.sy_studio.the.gugudan_SangYeol;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.sy_studio.the.gugudan_SangYeol.Adapter.GalleryPageAdapter;

public class GalleryActivity extends BaseActivity {

    int tempNum;
    private ImageView backBtn;
    private TextView confirmBtn;
    private TextView pictureBtn;
    private TextView videoBtn;
    private android.support.v4.view.ViewPager galleryViewPager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);
        tempNum = getIntent().getIntExtra("ViewPager", 0);
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
                TextView[] text = {pictureBtn, videoBtn};
                for (TextView textView : text) {
                    textView.setTypeface(null, Typeface.NORMAL);
                }
                text[index].setTypeface(null, Typeface.BOLD);
                galleryViewPager.setCurrentItem(index);

            }
        };

        pictureBtn.setOnClickListener(clickListener);
        videoBtn.setOnClickListener(clickListener);

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }

    @Override
    public void setValues() {
        galleryViewPager.setAdapter(new GalleryPageAdapter(getSupportFragmentManager()));
        galleryViewPager.setCurrentItem(tempNum);
        galleryViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                TextView[] text = {pictureBtn, videoBtn};
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


    }

    @Override
    public void bindView() {
        this.galleryViewPager = (ViewPager) findViewById(R.id.galleryViewPager);
        this.videoBtn = (TextView) findViewById(R.id.videoBtn);
        this.pictureBtn = (TextView) findViewById(R.id.pictureBtn);
        this.confirmBtn = (TextView) findViewById(R.id.confirmBtn);
        this.backBtn = (ImageView) findViewById(R.id.backBtn);
    }
}
