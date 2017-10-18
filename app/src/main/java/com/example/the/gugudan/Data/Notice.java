package com.example.the.gugudan.Data;

import java.util.Calendar;

/**
 * Created by the on 2017-10-17.
 */

public class Notice {
    private String title;
    private Calendar creatDate;
    private String content;

    public Notice() {
    }

    public Notice(String title, Calendar creatDate, String content) {
        this.title = title;
        this.creatDate = creatDate;
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Calendar getCreatDate() {
        return creatDate;
    }

    public void setCreatDate(Calendar creatDate) {
        this.creatDate = creatDate;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
