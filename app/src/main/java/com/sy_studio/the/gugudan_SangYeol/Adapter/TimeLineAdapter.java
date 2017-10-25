package com.sy_studio.the.gugudan_SangYeol.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.sy_studio.the.gugudan_SangYeol.Data.Facebook;
import com.sy_studio.the.gugudan_SangYeol.R;

import java.util.List;

/**
 * Created by the on 2017-10-25.
 */

public class TimeLineAdapter extends ArrayAdapter<Facebook>{


    Context mContext;
    List<Facebook> mList;
    LayoutInflater inf;

    public TimeLineAdapter(Context context, List<Facebook> list) {
        super(context, R.layout.post_item, list);
        this.mContext = context;
        mList = list;

        inf = LayoutInflater.from(mContext);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        if (row == null) {
            row = inf.inflate( R.layout.timeline_item, null);
        }

        Facebook data = mList.get(position);

        ImageView profileImg = (ImageView)row.findViewById(R.id.profileImg);
        TextView nameTxt = (TextView)row.findViewById(R.id.nameTxt);
        TextView dateTxt = (TextView)row.findViewById(R.id.dateTxt);



        return row;
    }
}
