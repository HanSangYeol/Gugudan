package com.sy_studio.the.gugudan_SangYeol;

import android.os.Bundle;
import android.support.design.widget.TabItem;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.astuetz.PagerSlidingTabStrip;
import com.sy_studio.the.gugudan_SangYeol.Adapter.GalleryPageAdapter;

public class GalleryActivity extends BaseActivity {

    int tempNum;
    private ImageView backBtn;
    private TextView confirmBtn;
    private TextView pictureBtn;
    private TextView videoBtn;
    private android.support.v4.view.ViewPager galleryViewPager;
    private android.support.design.widget.TabItem tabItem;
    private android.support.design.widget.TabItem tabItem2;
    private TabLayout tabs;


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
        galleryViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabs));
        tabs.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(galleryViewPager));

        galleryViewPager.setCurrentItem(tempNum);



    }

    @Override
    public void bindView() {
        this.galleryViewPager = (ViewPager) findViewById(R.id.galleryViewPager);
        this.tabs = (TabLayout) findViewById(R.id.tabs);
        this.tabItem2 = (TabItem) findViewById(R.id.tabItem2);
        this.tabItem = (TabItem) findViewById(R.id.tabItem);
        this.confirmBtn = (TextView) findViewById(R.id.confirmBtn);
        this.backBtn = (ImageView) findViewById(R.id.backBtn);
    }
}
