package com.example.materialtest;

public class Fruit {
    private String name;
    private int imageID;

    public Fruit(String name, int imageID) {
        this.imageID = imageID;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getImageID() {
        return imageID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setImageID(int imageID) {
        this.imageID = imageID;
    }
}
