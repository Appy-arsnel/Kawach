package com.example.kawach.splashscreen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.kawach.MainActivity;
import com.example.kawach.R;

public class Splashscreen4Activity extends AppCompatActivity {
    private static int SPLASH_SCREEN_TIME_OUT=4000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splashscreen4);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(Splashscreen4Activity.this, MainActivity.class));
                finish();
            }
        },SPLASH_SCREEN_TIME_OUT);

    }
}