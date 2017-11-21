package com.sy_studio.the.gugudan_SangYeol.Adapter;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.sy_studio.the.gugudan_SangYeol.Fragment.MemberFrag;
import com.sy_studio.the.gugudan_SangYeol.Fragment.NoticeFrag;
import com.sy_studio.the.gugudan_SangYeol.Fragment.QAFrag;
import com.sy_studio.the.gugudan_SangYeol.Fragment.ScheduleFrag;
import com.sy_studio.the.gugudan_SangYeol.Fragment.TimeLineFrag;

/**
 * Created by the on 2017-10-23.
 */

public class MainPageAdapter extends FragmentStatePagerAdapter {
    final int PAGE_COUNT = 5;

    public MainPageAdapter(FragmentManager fm){
        super(fm);
    }

    @Override
    public int getCount() {
        return PAGE_COUNT;
    }


    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new NoticeFrag();
            case 1:
                return new TimeLineFrag();
            case 2:
                return new MemberFrag();
            case 3:
                return new ScheduleFrag();
            case 4:
                return new QAFrag();
            default:
                return null;
        }
    }
}
