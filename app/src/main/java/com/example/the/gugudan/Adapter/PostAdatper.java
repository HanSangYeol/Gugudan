package com.example.the.gugudan.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.the.gugudan.Data.Member;
import com.example.the.gugudan.Data.Post;
import com.example.the.gugudan.R;

import java.util.List;

/**
 * Created by the on 2017-10-18.
 */

public class PostAdatper extends ArrayAdapter<Post> {

    Context mContext;
    int layout;
    List<Post> mList;
    LayoutInflater inf;

    public PostAdatper(Context context, List<Post> list) {
        super(context, R.layout.post_item, list);
        this.mContext = context;
        this.layout = layout;
        mList = list;

        inf = LayoutInflater.from(mContext);
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        if (row == null) {
            row = inf.inflate( R.layout.post_item, null);
        }

        return convertView;
    }
}
