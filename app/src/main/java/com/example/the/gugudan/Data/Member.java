package com.example.the.gugudan.Data;

import java.util.Calendar;

/**
 * Created by the on 2017-10-17.
 */

public class Member {
    int id;
    int age;
    int height;
    Calendar birthday;
    String name;
    String nickName;
    String bloodtype;
    String agency;

    public Member() {
    }

    public Member(int id, int age, int height, Calendar birthday, String name, String nickName, String bloodtype, String agency) {
        this.id = id;
        this.age = age;
        this.height = height;
        this.birthday = birthday;
        this.name = name;
        this.nickName = nickName;
        this.bloodtype = bloodtype;
        this.agency = agency;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
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

    public String getAgency() {
        return agency;
    }

    public void setAgency(String agency) {
        this.agency = agency;
    }
}
