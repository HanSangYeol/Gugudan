package com.sy_studio.the.gugudan_SangYeol.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.sy_studio.the.gugudan_SangYeol.Adapter.NoticeAdatper;
import com.sy_studio.the.gugudan_SangYeol.Data.Notice;
import com.sy_studio.the.gugudan_SangYeol.R;
import com.sy_studio.the.gugudan_SangYeol.Util.GlobalData;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by the on 2017-10-17.
 */

public class NoticeFrag extends Fragment {

    private android.widget.ListView noticeListView;
    List<Notice> noticeList = new ArrayList<>();
    NoticeAdatper noticeAdatper;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_notice, container, false);
        this.noticeListView = (ListView) view.findViewById(R.id.noticeListView);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        GlobalData.noticeData();
        noticeList.addAll(GlobalData.noticeList);

        noticeAdatper = new NoticeAdatper(getActivity(), noticeList);
        noticeListView.setAdapter(noticeAdatper);
    }
}
