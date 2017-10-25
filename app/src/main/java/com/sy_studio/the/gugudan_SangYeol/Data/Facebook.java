package com.sy_studio.the.gugudan_SangYeol.Data;

import java.util.Calendar;

/**
 * Created by the on 2017-10-25.
 */

public class Facebook {

    private String profileUrl;
    private String name;
    private String date;
    private String contentImg;
    private String contentTxt;

    public Facebook() {
    }

    public Facebook(String profileUrl, String name, String date, String contentImg, String contentTxt) {
        this.profileUrl = profileUrl;
        this.name = name;
        this.date = date;
        this.contentImg = contentImg;
        this.contentTxt = contentTxt;
    }

    public String getProfileUrl() {
        return profileUrl;
    }

    public void setProfileUrl(String profileUrl) {
        this.profileUrl = profileUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getContentImg() {
        return contentImg;
    }

    public void setContentImg(String contentImg) {
        this.contentImg = contentImg;
    }

    public String getContentTxt() {
        return contentTxt;
    }

    public void setContentTxt(String contentTxt) {
        this.contentTxt = contentTxt;
    }
}
