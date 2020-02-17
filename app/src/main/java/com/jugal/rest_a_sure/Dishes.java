package com.jugal.rest_a_sure;

public class Dishes {

    private String name;
    private int Thumbnail;

    public Dishes(){

    }

    public Dishes(String name, int thumbnail) {
        this.name = name;
        Thumbnail = thumbnail;
    }

    public String getName() {
        return name;
    }

    public int getThumbnail() {
        return Thumbnail;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setThumbnail(int thumbnail) {
        Thumbnail = thumbnail;
    }


}
