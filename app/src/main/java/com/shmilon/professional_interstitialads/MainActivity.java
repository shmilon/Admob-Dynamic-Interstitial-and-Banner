package com.shmilon.professional_interstitialads;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.google.android.gms.ads.FullScreenContentCallback;
import com.shmilon.professional_interstitialads.Ads.AdMob;

public class MainActivity extends AppCompatActivity {

    Button ads;
    RelativeLayout bottomBanner,TopBanner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ads = findViewById(R.id.ads);
        bottomBanner = findViewById(R.id.bottomBanner);
        TopBanner = findViewById(R.id.TopBanner);

        // show banner using method
        AdMob.ShowbannerAds(MainActivity.this,TopBanner);
        AdMob.ShowbannerAds(MainActivity.this,bottomBanner);

        ads.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (AdMob.mInterstitialAd != null){

                    AdMob.mInterstitialAd.show(MainActivity.this);

                    AdMob.mInterstitialAd.setFullScreenContentCallback(new FullScreenContentCallback() {
                        @Override
                        public void onAdDismissedFullScreenContent() {
                            super.onAdDismissedFullScreenContent();
                                AdMob.mInterstitialAd = null;
                                AdMob.LoadInterstitialAds(MainActivity.this);
                        }
                    });

                }else{

                    Toast.makeText(MainActivity.this, "Not loaded", Toast.LENGTH_SHORT).show();
                }

            }
        });

    }
}