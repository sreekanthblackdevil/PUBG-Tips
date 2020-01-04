package com.nightcoder.pubgtips.Models;

public class Vehicles {
    private String title;
    private String about;
    private String map;
    private int imageId;
    private int health;
    private int seats;
    private int speed;

    public String getTitle() {
        return title;
    }

    public String getAbout() {
        return about;
    }

    public String getMap() {
        return map;
    }

    public int getImageId() {
        return imageId;
    }

    public int getHealth() {
        return health;
    }

    public int getSeats() {
        return seats;
    }

    public int getSpeed() {
        return speed;
    }

    public Vehicles(String title, String about, String map, int imageId, int health, int seats, int speed) {
        this.title = title;
        this.about = about;
        this.map = map;
        this.imageId = imageId;
        this.health = health;
        this.seats = seats;
        this.speed = speed;
    }
}
