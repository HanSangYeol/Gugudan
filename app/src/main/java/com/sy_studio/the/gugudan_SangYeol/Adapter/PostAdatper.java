package com.sy_studio.the.gugudan_SangYeol.Adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.sy_studio.the.gugudan_SangYeol.Data.Post;
import com.sy_studio.the.gugudan_SangYeol.R;

import java.util.List;

/**
 * Created by the on 2017-10-18.
 */

public class PostAdatper extends ArrayAdapter<Post> {

    Context mContext;
    List<Post> mList;
    LayoutInflater inf;

    public PostAdatper(Context context, List<Post> list) {
        super(context, R.layout.post_item, list);
        this.mContext = context;
        mList = list;

        inf = LayoutInflater.from(mContext);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        if (row == null) {
            row = inf.inflate( R.layout.post_item, null);
        }

        Post data = mList.get(position);

        TextView qaNumberTxt = (TextView)row.findViewById(R.id.qaNumberTxt);
        TextView qatitleTxt = (TextView)row.findViewById(R.id.qatitleTxt);

        qaNumberTxt.setText(mList.size()-position+"");
        qatitleTxt.setText(data.getTitle());
        if (data.getTitle().contains("공지사항")){
            qatitleTxt.setTextColor(Color.parseColor("#6B8EB8"));
        }


        return row;
    }

}
