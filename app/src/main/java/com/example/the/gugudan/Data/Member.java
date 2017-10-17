package com.example.the.gugudan.Data;

import java.util.Calendar;

/**
 * Created by the on 2017-10-17.
 */

public class Member {
    private int age;
    private Calendar birthday;
    private String name;
    private String nickName;
    private String bloodtype;
    private String position;
    private String groupPosition;
    private int profileImg;

    public Member() {
    }

    public Member(int age, Calendar birthday, String name, String nickName, String bloodtype, String position, String groupPosition, int profileImg) {
        this.age = age;
        this.birthday = birthday;
        this.name = name;
        this.nickName = nickName;
        this.bloodtype = bloodtype;
        this.position = position;
        this.groupPosition = groupPosition;
        this.profileImg = profileImg;
    }

    public String getGroupPosition() {
        return groupPosition;
    }

    public void setGroupPosition(String groupPosition) {
        this.groupPosition = groupPosition;
    }

    public int getProfileImg() {
        return profileImg;
    }

    public void setProfileImg(int profileImg) {
        this.profileImg = profileImg;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Calendar getBirthday() {
        return birthday;
    }

    public void setBirthday(Calendar birthday) {
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getBloodtype() {
        return bloodtype;
    }

    public void setBloodtype(String bloodtype) {
        this.bloodtype = bloodtype;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
}
