package com.example.the.gugudan.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.example.the.gugudan.Adapter.PostAdatper;
import com.example.the.gugudan.Data.Post;
import com.example.the.gugudan.R;
import com.example.the.gugudan.Util.GlobalData;
import com.example.the.gugudan.WriteActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by the on 2017-10-17.
 */

public class QAFrag extends Fragment {

    private android.widget.TextView questionBtn;
    private android.widget.ListView questionListView;
    PostAdatper postAdatper;
    List<Post> postList = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_qa, container, false);
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
    }

    private void setValues() {
        postList.addAll(GlobalData.postList);

        postAdatper = new PostAdatper(getActivity(), postList);
        questionListView.setAdapter(postAdatper);

    }

    @Override
    public void onResume() {
        postList.clear();
//        postList.addAll(GlobalData.postList);
        for (int i = GlobalData.postList.size()-1; i >= 0; i--){
            Post post = GlobalData.postList.get(i);
            postList.add(post);
        }
        postAdatper.notifyDataSetChanged();
        super.onResume();
    }
}
