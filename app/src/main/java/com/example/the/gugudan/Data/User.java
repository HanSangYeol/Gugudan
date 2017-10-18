package com.example.the.gugudan.Data;

/**
 * Created by the on 2017-10-18.
 */

public class User {
    private String id;
    private String pw;
    private String name;

    public User() {
    }

    public User(String id, String pw, String name) {
        this.id = id;
        this.pw = pw;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPw() {
        return pw;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // 사용자 아이디 중복체크를 위해 equals를 Override
    // User클래스(this)의 id를 비교하려는 오브젝트(obj)의 id를 if문으로 구분
    @Override
    public boolean equals(Object obj) {
        if (this.id.equals(((User)obj).id )){
            return true;
        }else {
            return false;
        }
    }
}
