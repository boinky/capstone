package com.example.android.buktogo;

import java.io.Serializable;

/**
 * Created by jan on 12/8/15.
 */
public class Data implements Serializable{
    public String id;
    public String title;
    public String description;
    public int imageId;

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



    public Data(String id, String title){
        this.id = id;
        this.title = title;
    }

    public Data( String id, String title, String description, int imageId) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.imageId = imageId;
    }
}





