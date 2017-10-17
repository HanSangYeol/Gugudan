package com.example.the.gugudan.Adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import com.example.the.gugudan.R;

import java.io.File;

/**
 * Created by the on 2017-10-17.
 */

public class GalleryAdapter extends BaseAdapter {
    private Context mContext;

    public GalleryAdapter(Context c) {
        mContext = c;
    }

    public int getCount() {
        return mThumbIds.length;
    }

    public Object getItem(int position) {
        return null;
    }

    public long getItemId(int position) {
        return 0;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;
        if (convertView == null) {
            imageView = new ImageView(mContext);
            imageView.setLayoutParams(new GridView.LayoutParams(240, 180));
            imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
            imageView.setPadding(8, 8, 8, 8);
        } else {
            imageView = (ImageView) convertView;
        }

        imageView.setImageResource(mThumbIds[position]);
        return imageView;
    }

    private Integer[] mThumbIds = {R.drawable.view1, R.drawable.view2, R.drawable.view3,
            R.drawable.view4, R.drawable.view5, R.drawable.view6,
            R.drawable.view7, R.drawable.view8, R.drawable.view9,
            R.drawable.view10, R.drawable.view11, R.drawable.view12,
            R.drawable.view13, R.drawable.view14, R.drawable.view15};
}
