package com.nightcoder.pubgtips.Models;

public class Attachments {

    private String title;
    private String type;
    private int imageId;
    private String about;

    public String getTitle() {
        return title;
    }

    public String getType() {
        return type;
    }

    public int getImageId() {
        return imageId;
    }

    public String getAbout() {
        return about;
    }

    public Attachments(String title, String type, int imageId, String about) {
        this.title = title;
        this.type = type;
        this.imageId = imageId;
        this.about = about;
    }
}
