package com.nightcoder.pubgtips.Models;

public class Grenades {
    private String title;
    private String about;
    private int imageId;

    public Grenades(String title, String about, int imageId) {
        this.title = title;
        this.about = about;
        this.imageId = imageId;
    }

    public String getTitle() {
        return title;
    }

    public String getAbout() {
        return about;
    }

    public int getImageId() {
        return imageId;
    }
}
