package com.sy_studio.the.gugudan_SangYeol.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.sy_studio.the.gugudan_SangYeol.MainActivity;
import com.sy_studio.the.gugudan_SangYeol.GalleryActivity;
import com.sy_studio.the.gugudan_SangYeol.R;

/**
 * Created by the on 2017-10-19.
 */

public class NavigationFrag extends Fragment {

    int galleryNum = 0;
    int youtubeNum = 1;

    private android.widget.LinearLayout galleryBtn;
    private android.widget.LinearLayout youtubeBtn;
    private android.widget.LinearLayout settingBtn;
    private android.support.design.widget.NavigationView navview;
    private android.support.v4.widget.DrawerLayout naviDrawLayout;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.frag_navigation, container, false);
        this.naviDrawLayout = (DrawerLayout) v.findViewById(R.id.naviDrawLayout);
        this.navview = (NavigationView) v.findViewById(R.id.nav_view);
        this.settingBtn = (LinearLayout) v.findViewById(R.id.settingBtn);
        this.youtubeBtn = (LinearLayout) v.findViewById(R.id.youtubeBtn);
        this.galleryBtn = (LinearLayout) v.findViewById(R.id.galleryBtn);
        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        galleryBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(getActivity(), GalleryActivity.class);
                MainActivity.mainDrawLayout.closeDrawer(GravityCompat.START);
                myIntent.putExtra("ViewPager", galleryNum);
                startActivity(myIntent);
            }
        });
        youtubeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(getActivity(), GalleryActivity.class);
                MainActivity.mainDrawLayout.closeDrawer(GravityCompat.START);
                myIntent.putExtra("ViewPager", youtubeNum);
                startActivity(myIntent);
            }
        });
        settingBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
}
