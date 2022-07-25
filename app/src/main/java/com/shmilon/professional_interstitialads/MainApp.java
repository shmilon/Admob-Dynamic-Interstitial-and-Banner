package com.shmilon.professional_interstitialads;

import android.os.Bundle;
import android.os.PersistableBundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.shmilon.professional_interstitialads.Ads.AdMob;

public class MainApp  extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        AdMob.LoadInterstitialAds(MainApp.this);
    }
}
