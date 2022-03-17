package com.example.kawach.data;

import android.graphics.drawable.Drawable;

public class applistdata {
    private String description;
    private Drawable imgId;
    public applistdata()
        {}
    public applistdata(String description, Drawable imgId) {
        this.description = description;
        this.imgId = imgId;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public Drawable getImgId() {
        return imgId;
    }
    public void setImgId(Drawable imgId) {
        this.imgId = imgId;
    }
}
