package com.sy_studio.the.gugudan_SangYeol.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.sy_studio.the.gugudan_SangYeol.Adapter.PostAdatper;
import com.sy_studio.the.gugudan_SangYeol.Data.WritePost;
import com.sy_studio.the.gugudan_SangYeol.R;
import com.sy_studio.the.gugudan_SangYeol.Util.GlobalData;
import com.sy_studio.the.gugudan_SangYeol.WriteActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by the on 2017-10-17.
 */

public class QAFrag extends Fragment {

    private android.widget.TextView questionBtn;
    private android.widget.ListView questionListView;
    PostAdatper postAdatper;
    List<WritePost> writePostList = new ArrayList<>();
    public static android.widget.EditText inputEdt;
    private TextView searchBtn;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_qa, container, false);
        this.searchBtn = (TextView) view.findViewById(R.id.searchBtn);
        this.inputEdt = (EditText) view.findViewById(R.id.inputEdt);
        this.questionListView = (ListView) view.findViewById(R.id.questionListView);
        this.questionBtn = (TextView) view.findViewById(R.id.questionBtn);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setValues();
        setupEvents();


    }

    private void setupEvents() {
        questionBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(getActivity(), WriteActivity.class);
                startActivity(myIntent);
            }
        });
        searchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                inputEdt.setText("");
            }
        });
    }

    private void setValues() {
        writePostList.addAll(GlobalData.writePostList);

        postAdatper = new PostAdatper(getActivity(), writePostList);
        questionListView.setAdapter(postAdatper);

    }

    @Override
    public void onResume() {
        writePostList.clear();
//        writePostList.addAll(GlobalData.writePostList);
        for (int i = GlobalData.writePostList.size()-1; i >= 0; i--){
            WritePost writePost = GlobalData.writePostList.get(i);
            writePostList.add(writePost);
        }
        postAdatper.notifyDataSetChanged();
        super.onResume();
    }
}
