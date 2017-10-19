package com.sy_studio.the.gugudan_SangYeol.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.sy_studio.the.gugudan_SangYeol.Data.Member;
import com.sy_studio.the.gugudan_SangYeol.R;

import java.util.List;

/**
 * Created by the on 2017-10-17.
 */

public class MemberAdapter extends ArrayAdapter<Member> {

    Context mContext;
    int layout;
    List<Member> mList;
    LayoutInflater inf;

    public MemberAdapter(Context context, int layout, List<Member> list) {
        super(context, layout, list);
        // 어댑터 생성자의 인자값으로 layout자체와 img id배열을 받고 이를 토대로
        // getView에서 그려준다
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

        if (convertView == null) {
            convertView = inf.inflate(layout, null);
        }
        ImageView gridImageView = (ImageView) convertView.findViewById(R.id.gridViewImg);
        TextView positionTxt = (TextView) convertView.findViewById(R.id.positonTxt);
        TextView nickNameTxt = (TextView) convertView.findViewById(R.id.nickNameTxt);

        Glide.with(mContext).load(mList.get(position).getProfileImg()).into(gridImageView);
        positionTxt.setText(mList.get(position).getPosition());
        nickNameTxt.setText(mList.get(position).getNickName());


        return convertView;
    }
}
