package com.shmilon.professional_interstitialads.Ads;

import static android.content.ContentValues.TAG;

import android.content.Context;
import android.util.Log;
import android.view.Gravity;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback;

public class AdMob{

    public static InterstitialAd mInterstitialAd;
    public static AdView ShowbannerAds;

    // Admob InterstitialAd Show Method
    public static void LoadInterstitialAds(Context context){

        MobileAds.initialize(context, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {}
        });
        AdRequest adRequest = new AdRequest.Builder().build();
                                    // test interstitial ads unit id
        InterstitialAd.load(context,"ca-app-pub-3940256099942544/1033173712", adRequest,
            new InterstitialAdLoadCallback() {
                @Override
                public void onAdLoaded(@NonNull InterstitialAd interstitialAd) {
                    mInterstitialAd = interstitialAd;
                }

                @Override
                public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                    mInterstitialAd = null;
                }
            });

    }

    // Admob Banner Show Method
    public static void ShowbannerAds(Context context, RelativeLayout relativeLayout){

        AdView AdView = new AdView(context);
                            // test banner ads unit id
        AdView.setAdUnitId("ca-app-pub-3940256099942544/6300978111");
        relativeLayout.addView(AdView);
        AdView.setAdSize(AdSize.BANNER);
        relativeLayout.setHorizontalGravity(Gravity.CENTER);
        relativeLayout.setVerticalGravity(Gravity.CENTER);
        AdRequest adRequest = new AdRequest.Builder().build();
        AdView.loadAd(adRequest);
    }
}
