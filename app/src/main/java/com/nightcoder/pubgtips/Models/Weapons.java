package com.nightcoder.pubgtips.Models;

import java.io.Serializable;

public class Weapons implements Serializable {
    private String title;
    private String type;
    private int weaponImageId;
    private String ammoGuage;
    private int ammoImageId;
    private int damage;
    private int magazineCapacity;
    private int range;
    private int bulletSpeed;
    private int rank;
    private float fireRate;
    private String description;

    public Weapons(String title, String type, int weaponImageId, String ammoGuage,
                   int ammoImageId, int damage, int magazineCapacity,
                   int range, int bulletSpeed, float fireRate, int rank, String description) {
        this.title = title;
        this.type = type;
        this.weaponImageId = weaponImageId;
        this.ammoGuage = ammoGuage;
        this.ammoImageId = ammoImageId;
        this.damage = damage;
        this.magazineCapacity = magazineCapacity;
        this.range = range;
        this.bulletSpeed = bulletSpeed;
        this.rank = rank;
        this.fireRate = fireRate;
        this.description = description;
    }

    public Weapons() {
    }

    public String getDescription() {
        return description;
    }

    public int getRank() {
        return rank;
    }

    public float getFireRate() {
        return fireRate;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }


    public int getWeaponImageId() {
        return weaponImageId;
    }

    public String getAmmoGuage() {
        return ammoGuage;
    }


    public int getAmmoImageId() {
        return ammoImageId;
    }


    public int getDamage() {
        return damage;
    }


    public int getMagazineCapacity() {
        return magazineCapacity;
    }


    public int getRange() {
        return range;
    }

    public int getBulletSpeed() {
        return bulletSpeed;
    }

}
