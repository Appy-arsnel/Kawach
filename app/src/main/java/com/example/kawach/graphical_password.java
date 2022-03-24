package com.example.kawach;

import androidx.appcompat.app.AppCompatActivity;
import androidx.vectordrawable.graphics.drawable.VectorDrawableCompat;

import android.graphics.drawable.VectorDrawable;
import android.os.Bundle;

import com.example.kawach.data.gimglist;

import java.util.ArrayList;
import java.util.List;

public class graphical_password extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graphical_password);
        List<gimglist> gimg=new ArrayList<>();

        gimglist img=new gimglist("1", VectorDrawableCompat.create(getResources(),R.drawable.img1, getApplicationContext().getTheme()));
        gimg.add(0,img);

        gimglist img1=new gimglist("2", VectorDrawableCompat.create(getResources(),R.drawable.img2, getApplicationContext().getTheme()));
        gimg.add(1,img1);

        gimglist img2=new gimglist("3", VectorDrawableCompat.create(getResources(),R.drawable.img3, getApplicationContext().getTheme()));
        gimg.add(2,img2);

        gimglist img3=new gimglist("4", VectorDrawableCompat.create(getResources(),R.drawable.img4, getApplicationContext().getTheme()));
        gimg.add(3,img3);

        gimglist img4=new gimglist("5", VectorDrawableCompat.create(getResources(),R.drawable.img5, getApplicationContext().getTheme()));
        gimg.add(4,img4);

        gimglist img5=new gimglist("6", VectorDrawableCompat.create(getResources(),R.drawable.img6, getApplicationContext().getTheme()));
        gimg.add(5,img5);

        gimglist img6=new gimglist("7", VectorDrawableCompat.create(getResources(),R.drawable.img7, getApplicationContext().getTheme()));
        gimg.add(6,img6);

        gimglist img7=new gimglist("8", VectorDrawableCompat.create(getResources(),R.drawable.img8, getApplicationContext().getTheme()));
        gimg.add(7,img7);

        gimglist img8=new gimglist("9", VectorDrawableCompat.create(getResources(),R.drawable.img9, getApplicationContext().getTheme()));
        gimg.add(8,img8);





    }


}