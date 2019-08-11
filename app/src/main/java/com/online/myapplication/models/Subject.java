package com.online.myapplication.models;

public class Subject {

    private String name;
    private String imageUrl;
    private double progressPercent;

    public Subject(String name, String imageUrl, double progressPercent) {
        this.name = name;
        this.imageUrl = imageUrl;
        this.progressPercent = progressPercent;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public double getProgressPercent() {
        return progressPercent;
    }

    public void setProgressPercent(double progressPercent) {
        this.progressPercent = progressPercent;
    }
}
