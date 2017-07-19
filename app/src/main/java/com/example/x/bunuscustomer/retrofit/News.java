package com.example.x.bunuscustomer.retrofit;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by mobi app on 01.07.2017.
 */

public class News {

    @SerializedName("news_id")
    @Expose
    private String id;
    @SerializedName("time")
    @Expose
    private String time;
    @SerializedName("text")
    @Expose
    private String text;
    @SerializedName("photo")
    @Expose
    private String photo;
    @SerializedName("title")
    @Expose
    private String title;

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
