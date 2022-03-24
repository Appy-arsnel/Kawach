package com.example.kawach.data;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;

import androidx.vectordrawable.graphics.drawable.VectorDrawableCompat;

public class gimglist {
    private String id;
    private ImageView imgId;

    public gimglist(String id, ImageView imgId) {
        this.id = id;
        this.imgId = imgId;
    }
    public  gimglist(String id, VectorDrawableCompat vectorDrawableCompat)
    {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ImageView getImgId() {
        return imgId;
    }

    public void setImgId(ImageView imgId) {
        this.imgId = imgId;
    }
}