package com.shmilon.professional_interstitialads;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.shmilon.professional_interstitialads.Ads.AdMob;

public class SplashScreen extends MainApp {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent intent = new Intent(SplashScreen.this, MainActivity.class);
                startActivity(intent);
                finish();

            }
        }, 3000);


    }
}