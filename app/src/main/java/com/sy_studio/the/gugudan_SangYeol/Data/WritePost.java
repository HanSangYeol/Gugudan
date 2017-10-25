package com.sy_studio.the.gugudan_SangYeol.Data;

/**
 * Created by the on 2017-10-18.
 */

public class WritePost {
    private String title;
    private String content;

    public WritePost() {
    }

    public WritePost(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }


}
