package com.nightcoder.pubgtips.Models;

public class WeaponTypeModel {

    private String title;
    private String text;
    private int imageId;

    public WeaponTypeModel(String title, String text, int imageId) {
        this.title = title;
        this.text = text;
        this.imageId = imageId;
    }

    public WeaponTypeModel() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }
}
