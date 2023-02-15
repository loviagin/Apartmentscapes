package com.louagin.apartmentscapes.objects;

import android.graphics.drawable.Drawable;

public class PlayItem {
    private String username, name;
    private Drawable drawableImage;
    private int cost;

    public PlayItem(String username, String name, Drawable drawableImage, int cost) {
        this.username = username;
        this.name = name;
        this.drawableImage = drawableImage;
        this.cost = cost;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Drawable getDrawableImage() {
        return drawableImage;
    }

    public void setDrawableImage(Drawable drawableImage) {
        this.drawableImage = drawableImage;
    }
}
