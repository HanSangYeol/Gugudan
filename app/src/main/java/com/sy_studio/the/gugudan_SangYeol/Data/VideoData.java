package com.sy_studio.the.gugudan_SangYeol.Data;

/**
 * Created by the on 2017-10-24.
 */

public class VideoData  {
    private String Title;
    private String VideoId;
    private String Url;
    private String publishedAt;

    public VideoData() {
    }

    public VideoData(String title, String videoId, String url, String publishedAt) {
        Title = title;
        VideoId = videoId;
        Url = url;
        this.publishedAt = publishedAt;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getVideoId() {
        return VideoId;
    }

    public void setVideoId(String videoId) {
        VideoId = videoId;
    }

    public String getUrl() {
        return Url;
    }

    public void setUrl(String url) {
        Url = url;
    }

    public String getPublishedAt() {
        return publishedAt;
    }

    public void setPublishedAt(String publishedAt) {
        this.publishedAt = publishedAt;
    }
}
