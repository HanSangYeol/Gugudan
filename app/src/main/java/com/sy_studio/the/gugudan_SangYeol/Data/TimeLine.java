package com.sy_studio.the.gugudan_SangYeol.Data;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by the on 2017-10-25.
 */

public class TimeLine {

    private String id;
    private String profileUrl;
    private String name;
    private String date;
    private String contentImg;
    private String contentTxt;

    public TimeLine() {
    }

    public TimeLine(String id, String profileUrl, String name, String date, String contentImg, String contentTxt) {
        this.id = id;
        this.profileUrl = profileUrl;
        this.name = name;
        this.date = date;
        this.contentImg = contentImg;
        this.contentTxt = contentTxt;
    }

    public static TimeLine gettimeLineFromJSON(JSONObject json){
        TimeLine timeLine = new TimeLine();

        try {
            String date = json.getString("created_time").substring(0, 10);
            timeLine.date = date;
            timeLine.contentTxt = json.getString("message");
            timeLine.id = json.getString("id");

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return timeLine;

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
