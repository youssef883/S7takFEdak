package com.kmy.s7takfedak;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class SplashScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        splashScreen();
    }

    public void splashScreen()
    {
        new Handler().postDelayed(() -> {
            Intent intent = new Intent(SplashScreenActivity.this, BMIActivity.class);
            startActivity(intent);
            finish();
        },3000);
    }

}