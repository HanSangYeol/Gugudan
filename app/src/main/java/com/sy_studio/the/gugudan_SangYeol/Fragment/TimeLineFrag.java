package com.sy_studio.the.gugudan_SangYeol.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.sy_studio.the.gugudan_SangYeol.Adapter.TimeLineAdapter;
import com.sy_studio.the.gugudan_SangYeol.Data.TimeLine;
import com.sy_studio.the.gugudan_SangYeol.R;
import com.sy_studio.the.gugudan_SangYeol.Util.GlobalData;
import com.sy_studio.the.gugudan_SangYeol.Util.ServerUtil;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by the on 2017-10-20.
 */

public class TimeLineFrag extends Fragment {


    private android.widget.ListView timeLineListView;
    TimeLineAdapter timeLineAdapter;
    List<TimeLine> timeLineList = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_timeline, container, false);
        this.timeLineListView = (ListView) view.findViewById(R.id.timeLineListView);
        return view;

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setupEvents();
        setValues();
    }


    public void getAllPosting() {

        ServerUtil.get_facebook_data(getActivity(), new ServerUtil.JsonResponseHandler() {
            @Override
            public void onResponse(JSONObject json) {

                Log.d("FACEBOOK_JSON", json.toString());

                // 가져온 데이터들을 저장하기위해 GlobalData에있는 storeList를 비워둠
                GlobalData.timeLineList.clear();

                try {
                    // JSONArray형태로 저장되있는 데이터들을 stores에 저장
                    JSONArray timeLine = json.getJSONArray("data");
//                    for (int i = timeLine.length()-1; i >= 0 ; i-- ) {
//                        TimeLine facebook = TimeLine.gettimeLineFromJSON(timeLine.getJSONObject(i));
//                        GlobalData.timeLineList.add(facebook);
//                    }
                    for (int i = 0; i < timeLine.length() ; i++ ) {
                        TimeLine facebook = TimeLine.gettimeLineFromJSON(timeLine.getJSONObject(i));
                        GlobalData.timeLineList.add(facebook);
                    }


                } catch (JSONException e) {
                    e.printStackTrace();
                }

                timeLineList.clear();

                timeLineList.addAll(GlobalData.timeLineList);

                timeLineAdapter.notifyDataSetChanged();

                timeLineListView.setSelection(0);


            }
        });
    }


    private void setValues() {
        GlobalData.timeLineData();
        timeLineList.addAll(GlobalData.timeLineList);

        timeLineAdapter = new TimeLineAdapter(getActivity(), timeLineList);
        timeLineListView.setAdapter(timeLineAdapter);
        getAllPosting();
    }

    private void setupEvents() {
    }
}
