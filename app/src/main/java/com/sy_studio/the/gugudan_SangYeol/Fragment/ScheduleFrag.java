package com.sy_studio.the.gugudan_SangYeol.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sy_studio.the.gugudan_SangYeol.R;

/**
 * Created by the on 2017-10-17.
 */

public class ScheduleFrag extends Fragment{

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_scheduel, container, false);
        return view;
    }
}
