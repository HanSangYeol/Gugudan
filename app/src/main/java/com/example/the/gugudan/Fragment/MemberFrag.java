package com.example.the.gugudan.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import com.example.the.gugudan.Adapter.MemberAdapter;
import com.example.the.gugudan.Data.Member;
import com.example.the.gugudan.MemberDetailActivity;
import com.example.the.gugudan.R;
import com.example.the.gugudan.Util.GlobalData;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by the on 2017-10-17.
 */

public class MemberFrag extends Fragment {

    private android.widget.GridView memberGridView;
    List<Member> memList = new ArrayList<>();

    Member member;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_member, container, false);
        this.memberGridView = (GridView) view.findViewById(R.id.memberGridView);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setupEvents();
        setValues();


    }

    private void setValues() {
        GlobalData.memberData();

        memList.addAll(GlobalData.memberList);
        MemberAdapter memberAdapter = new MemberAdapter(getActivity(), R.layout.grid_item, memList);
        memberGridView.setAdapter(memberAdapter);
    }

    private void setupEvents() {
        memberGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent myIntent = new Intent(getActivity(), MemberDetailActivity.class);
                myIntent.putExtra("사진", member.getProfileImg());
                myIntent.putExtra("생일", member.getBirthday());
                myIntent.putExtra("나이", member.getAge());
                myIntent.putExtra("단", member.getGroupPosition());
                myIntent.putExtra("포지션", member.getPosition());
                myIntent.putExtra("이름", member.getName());
                myIntent.putExtra("닉네임", member.getNickName());
                startActivity(myIntent);
            }
        });
    }
}
