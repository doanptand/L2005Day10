package com.ddona.wallpaper.model;

public class Wallpaper {
    private int imageId;
    private String name;
    private String author;

    public Wallpaper() {
    }

    public Wallpaper(int imageId, String name, String author) {
        this.imageId = imageId;
        this.name = name;
        this.author = author;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
