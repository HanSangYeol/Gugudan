package com.sy_studio.the.gugudan_SangYeol.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.sy_studio.the.gugudan_SangYeol.Data.TimeLine;
import com.sy_studio.the.gugudan_SangYeol.R;
import com.sy_studio.the.gugudan_SangYeol.Util.ServerUtil;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

/**
 * Created by the on 2017-10-25.
 */

public class TimeLineAdapter extends ArrayAdapter<TimeLine>{


    Context mContext;
    List<TimeLine> mList;
    LayoutInflater inf;

    public TimeLineAdapter(Context context, List<TimeLine> list) {
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

        TimeLine data = mList.get(position);

        ImageView profileImg = (ImageView)row.findViewById(R.id.profileImg);
        TextView nameTxt = (TextView)row.findViewById(R.id.nameTxt);
        TextView dateTxt = (TextView)row.findViewById(R.id.dateTxt);
        final ImageView contentImg = (ImageView)row.findViewById(R.id.contentImg);
        TextView contentTxt = (TextView)row.findViewById(R.id.contentTxt);

        dateTxt.setText(data.getDate());
        contentTxt.setText(data.getContentTxt());

        ServerUtil.get_facebook_img(mContext, data.getId(), new ServerUtil.JsonResponseHandler() {
            @Override
            public void onResponse(JSONObject json) {
                try {
                    Glide.with(mContext).load(json.getJSONObject("attachments").getJSONArray("data")
                            .getJSONObject(1).getJSONObject("image").getString("src")).into(contentImg);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });




        return row;
    }

    @Override
    public int getCount() {
        return mList.size();
    }
}
