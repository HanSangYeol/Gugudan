package com.example.the.gugudan.Util;


import com.example.the.gugudan.Data.Member;
import com.example.the.gugudan.R;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Created by the on 2017-10-17.
 */

public class GlobalData {

    public static List<Member> memberList = new ArrayList<>();

    public static void memberData(){
        memberList.add(new Member(25, Calendar.getInstance(), "신보라", "하나", "A형", "1단", "리더", R.drawable.one));
        memberList.add(new Member(22, Calendar.getInstance(), "장소진", "소이", "AB형", "2단", "리드보컬", R.drawable.two));
        memberList.add(new Member(22, Calendar.getInstance(), "김세정", "세정", "AB형", "3단", "메인보컬", R.drawable.three));
        memberList.add(new Member(23, Calendar.getInstance(), "김나영", "나영", "O형", "4단", "리드보컬", R.drawable.four));
        memberList.add(new Member(18, Calendar.getInstance(), "조혜연", "혜연", "O형", "5단", "리드댄서", R.drawable.five));
        memberList.add(new Member(23, Calendar.getInstance(), "한해빈", "해빈", "B형", "6단", "메인보컬", R.drawable.six));
        memberList.add(new Member(25, Calendar.getInstance(), "정미미", "미미", "B형", "7단", "서브보컬", R.drawable.seven));
        memberList.add(new Member(22, Calendar.getInstance(), "류셰닝", "샐리", "중국인", "8단", "리드래퍼", R.drawable.eight));
        memberList.add(new Member(19, Calendar.getInstance(), "강미나", "미나", "O형", "9단", "메인래퍼, 메인댄서, 서브보컬", R.drawable.nine));
    }




}
