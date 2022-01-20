package com.example.nyapp.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ArticlesResponse {
    @Expose
    @SerializedName("uri")
    private String uri;
    @Expose
    @SerializedName("url")
    private String url;
    @Expose
    @SerializedName("source")
    private String source;
    @Expose
    @SerializedName("published_date")
    private String publishedDate;
    @Expose
    @SerializedName("title")
    private String title;
    @Expose
    @SerializedName("byline")
    private String byline;

    public String getByline() {
        return byline;
    }

    public String getPublishedDate() {
        return publishedDate;
    }

    public String getSource() {
        return source;
    }

    public String getTitle() {
        return title;
    }

    public String getUri() {
        return uri;
    }

    public String getUrl() {
        return url;
    }

}
