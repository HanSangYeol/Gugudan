package com.example.the.gugudan.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.example.the.gugudan.Adapter.MemberAdapter;
import com.example.the.gugudan.Data.Member;
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
        GlobalData.memberData();

        memList.addAll(GlobalData.memberList);
        MemberAdapter memberAdapter = new MemberAdapter(getActivity(), R.layout.grid_item, memList);
        memberGridView.setAdapter(memberAdapter);

    }
}
