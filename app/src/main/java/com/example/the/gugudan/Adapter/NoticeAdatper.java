package com.example.the.gugudan.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.the.gugudan.Data.Notice;
import com.example.the.gugudan.R;
import com.example.the.gugudan.Util.GlobalData;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by the on 2017-10-17.
 */

public class NoticeAdatper extends ArrayAdapter<Notice> {


    Context mContext;
    List<Notice> mList;
    LayoutInflater inf;

    public NoticeAdatper(Context context, List<Notice> list){
        super(context, R.layout.notice_item, list);

        mContext = context;
        mList = list;
        inf = LayoutInflater.from(mContext);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View row = convertView;
        if (row == null){
            row = inf.inflate(R.layout.notice_item, null);
        }
        Notice data = mList.get(position);


        TextView numberTxt = (TextView)row.findViewById(R.id.numberTxt);
        TextView titleTxt = (TextView)row.findViewById(R.id.titleTxt);
        TextView dataTxt = (TextView)row.findViewById(R.id.dateTxt);

        numberTxt.setText(mList.size()-position+"");
        titleTxt.setText(data.getTitle());
        SimpleDateFormat myDateFormat = new SimpleDateFormat("yyyy.MM.dd");
        String date = myDateFormat.format(mList.get(position).getCreatDate().getTime());
        dataTxt.setText(date);

        return row;
    }

}
