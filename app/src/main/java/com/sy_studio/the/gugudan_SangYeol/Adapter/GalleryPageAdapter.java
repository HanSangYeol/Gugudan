package com.sy_studio.the.gugudan_SangYeol.Adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.sy_studio.the.gugudan_SangYeol.Fragment.MemberFrag;
import com.sy_studio.the.gugudan_SangYeol.Fragment.NoticeFrag;
import com.sy_studio.the.gugudan_SangYeol.Fragment.PictureFrag;
import com.sy_studio.the.gugudan_SangYeol.Fragment.QAFrag;
import com.sy_studio.the.gugudan_SangYeol.Fragment.ScheduleFrag;
import com.sy_studio.the.gugudan_SangYeol.Fragment.TimeLineFrag;
import com.sy_studio.the.gugudan_SangYeol.Fragment.VideoFrag;

/**
 * Created by the on 2017-10-23.
 */

public class GalleryPageAdapter extends FragmentStatePagerAdapter {

    public GalleryPageAdapter(FragmentManager fm){
        super(fm);
    }

    @Override
    public int getCount() {
        return 2;
    }


    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new PictureFrag();
            case 1:
                return new VideoFrag();
            default:
                return null;
        }
    }
}
