package com.example.the.gugudan.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.example.the.gugudan.Adapter.ImageAdapter;
import com.example.the.gugudan.R;

/**
 * Created by the on 2017-10-17.
 */

public class GalleryFrag extends Fragment {

    private android.widget.GridView galleryGridView;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.frag_gallery, container, false);
        this.galleryGridView = (GridView) v.findViewById(R.id.galleryGridView);
        galleryGridView.setAdapter(new ImageAdapter(getActivity()));
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
