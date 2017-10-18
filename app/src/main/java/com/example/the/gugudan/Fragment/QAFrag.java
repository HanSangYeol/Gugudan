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

import com.example.the.gugudan.R;
import com.example.the.gugudan.WriteActivity;

/**
 * Created by the on 2017-10-17.
 */

public class QAFrag extends Fragment {

    private android.widget.TextView questionBtn;
    private android.widget.ListView questionListView;

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

        questionBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(getActivity(), WriteActivity.class);
                startActivity(myIntent);
            }
        });
    }
}
