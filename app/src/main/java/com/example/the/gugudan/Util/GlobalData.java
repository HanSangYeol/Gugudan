package com.example.the.gugudan.Util;


import com.example.the.gugudan.Data.Member;
import com.example.the.gugudan.Data.Notice;
import com.example.the.gugudan.Data.User;
import com.example.the.gugudan.R;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Created by the on 2017-10-17.
 */

public class GlobalData {

    public static List<Member> memberList = new ArrayList<>();
    public static List<Notice> noticeList = new ArrayList<>();
    public static List<User> userList = new ArrayList<>();

    public static void userData(){
        userList.add(new User("Mina", "1234", "강미나"));
    }

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

    public static void noticeData(){
        noticeList.add(new Notice("1023 ‘샐리’ 생일 서포트 신청 안내", Calendar.getInstance(), ""));
        noticeList.add(new Notice("2017 추석특집 MBC 아육대 현수막 신청 안내", Calendar.getInstance(), ""));
        noticeList.add(new Notice("구구단 1st Fanmeeting ~9월 9일의 구구단짝~ 공식 굿즈 현장 판매 안내", Calendar.getInstance(), ""));
        noticeList.add(new Notice("구구단 1st Fanmeeting ~9월 9일의 구구단짝~ 기부화환 신청 안내", Calendar.getInstance(), ""));
        noticeList.add(new Notice("구구단 오구오구(OGUOGU) - 'ICE CHU' 공식 굿즈 온라인 판매 안내", Calendar.getInstance(), ""));
        noticeList.add(new Notice("구구단 오구오구 'ICE CHU' 응원법", Calendar.getInstance(), ""));
        noticeList.add(new Notice("구구단 1st Fanmeeting ~9월 9일의 구구단짝~ 티켓오픈 안내 (한/Eng/日)", Calendar.getInstance(), ""));
        noticeList.add(new Notice("구구단 1st 팬미팅 일정 안내", Calendar.getInstance(), ""));
        noticeList.add(new Notice("세정 출연 드라마 ＜학교 2017＞ 제작발표회 기부화환 신청 안내", Calendar.getInstance(), ""));
        noticeList.add(new Notice("세정 출연 드라마 ＜학교 2017＞ 촬영 현장 방문 자제 요청", Calendar.getInstance(), ""));
        noticeList.add(new Notice("Hongkong Mega-K concert 구구단 출연 취소 안내", Calendar.getInstance(), ""));
        noticeList.add(new Notice("세정 출연 드라마 ＜학교2017＞ 현장 서포트 신청 안내", Calendar.getInstance(), ""));
        noticeList.add(new Notice("미나 부상 관련 안내", Calendar.getInstance(), ""));
        noticeList.add(new Notice("제23회 사랑한다 대한민국 2017 드림콘서트 현수막 신청 안내", Calendar.getInstance(), ""));
        noticeList.add(new Notice("제23회 사랑한다 대한민국 2017 드림콘서트 티켓 예매 안내", Calendar.getInstance(), ""));
        noticeList.add(new Notice("＜하나야, 무릎을 피자\uD83C\uDF55＞드레스코드 안내", Calendar.getInstance(), ""));
        noticeList.add(new Notice("＜하나야, 무릎을 피자\uD83C\uDF55＞ 참여 신청 방법 안내", Calendar.getInstance(), ""));
        noticeList.add(new Notice("＜구구단 하나 생일 팬미팅＞ 참여 안내", Calendar.getInstance(), ""));
        noticeList.add(new Notice("0430 ‘하나’ 생일 서포트 신청 안내", Calendar.getInstance(), ""));
        noticeList.add(new Notice("(170421_합정) 구구단 ‘Act.2 Narcissus' 마지막 앵콜 팬사인회", Calendar.getInstance(), ""));
        noticeList.add(new Notice("(170401_대구) 구구단 ‘Act.2 Narcissus' 발매 기념 팬사인회", Calendar.getInstance(), ""));
        noticeList.add(new Notice("(170401_부산) 구구단 ‘Act.2 Narcissus' 발매 기념 팬사인회", Calendar.getInstance(), ""));
        noticeList.add(new Notice("(170326_명동) 구구단 ‘Act.2 Narcissus' 발매 기념 팬사인회", Calendar.getInstance(), ""));
        noticeList.add(new Notice("구구단 악성 댓글 및 루머 유포 관련 안내", Calendar.getInstance(), ""));
        noticeList.add(new Notice("(170325_인천) 구구단 ‘Act.2 Narcissus' 발매 기념 팬사인회", Calendar.getInstance(), ""));
        noticeList.add(new Notice("(170318_코엑스) 구구단 ‘Act.2 Narcissus' 발매 기념 팬사인회", Calendar.getInstance(), ""));
        noticeList.add(new Notice("(170318_수원) 구구단 ‘Act.2 Narcissus' 발매 기념 팬사인회", Calendar.getInstance(), ""));
        noticeList.add(new Notice("구구단(gugudan) 'Act.2 Narcissus' 공식 굿즈 온라인 판매 안내", Calendar.getInstance(), ""));
        noticeList.add(new Notice("(170312_종로) 구구단 ‘Act.2 Narcissus' 발매 기념 팬사인회", Calendar.getInstance(), ""));
        noticeList.add(new Notice("(170311_동대문) 구구단 ‘Act.2 Narcissus' 발매 기념 팬사인회", Calendar.getInstance(), ""));
        noticeList.add(new Notice("(170310_대학로) 구구단 ‘Act.2 Narcissus' 발매 기념 팬사인회", Calendar.getInstance(), ""));
        noticeList.add(new Notice("(170309_신촌) 구구단 ‘Act.2 Narcissus' 발매 기념 팬사인회", Calendar.getInstance(), ""));
        noticeList.add(new Notice("(170305_일산) 구구단 ‘Act.2 Narcissus' 발매 기념 팬사인회", Calendar.getInstance(), ""));
        noticeList.add(new Notice("구구단(gugudan) ‘Rainbow’ 응원법", Calendar.getInstance(), ""));
        noticeList.add(new Notice("구구단(gugudan) ‘나 같은 애’ 응원법", Calendar.getInstance(), ""));





    }




}
