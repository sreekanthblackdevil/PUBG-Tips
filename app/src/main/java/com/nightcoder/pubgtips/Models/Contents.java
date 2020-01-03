package com.nightcoder.pubgtips.Models;

public class Contents {

    private String titel;
    private String text;
    private String buttonName;
    private int imageId;

    public Contents(String titel, String text, String buttonName, int imageId) {
        this.titel = titel;
        this.text = text;
        this.buttonName = buttonName;
        this.imageId = imageId;
    }

    public Contents() {
    }

    public String getTitel() {
        return titel;
    }

    public void setTitel(String titel) {
        this.titel = titel;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getButtonName() {
        return buttonName;
    }

    public void setButtonName(String buttonName) {
        this.buttonName = buttonName;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }
}
