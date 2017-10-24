package com.sy_studio.the.gugudan_SangYeol.NaviFragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.sy_studio.the.gugudan_SangYeol.Adapter.GalleryAdapter;
import com.sy_studio.the.gugudan_SangYeol.R;

/**
 * Created by the on 2017-10-17.
 */

public class PictureFrag extends Fragment {

    private android.widget.GridView galleryGridView;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.frag_picture, container, false);
        this.galleryGridView = (GridView) v.findViewById(R.id.galleryGridView);
        galleryGridView.setAdapter(new GalleryAdapter(getActivity()));
        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setValues();
    }

    private void setValues() {

    }

}
