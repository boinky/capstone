package com.example.android.buktogo;

import java.io.Serializable;

/**
 * Created by jan on 12/8/15.
 */
public class Data implements Serializable {
    private String id;
    private String title;
    private String description;
    private String address;
    private String contact;
    private int imageId;
    private double lat;
    private double lon;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public double getLon() {
        return lon;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }


    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Data(String id, String title) {
        this.id = id;
        this.title = title;
    }

    public Data(String id, String title, String description, int imageId) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.imageId = imageId;
    }

    public Data(String id, String title, String address, String contact, int imageId) {
        this.id = id;
        this.title = title;
        this.address = address;
        this.contact = contact;
        this.imageId = imageId;
    }

    public Data(String id, String title, String address, String contact, int imageId, double lat, double lon) {
        this.id = id;
        this.title = title;
        this.address = address;
        this.contact = contact;
        this.imageId = imageId;
        this.lat = lat;
        this.lon = lon;
    }
}





