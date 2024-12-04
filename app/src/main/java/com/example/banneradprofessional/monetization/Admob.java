package com.example.banneradprofessional.monetization;

import android.content.Context;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

public class Admob {

    public static void sdkInitialize(Context context) {

        if (!Constant.IS_AD_ENABLE) return;


        new Thread(() -> {
            // Initialize the Google Mobile Ads SDK on a background thread.
            MobileAds.initialize(context, initializationStatus -> {
            });
        }).start();


    }

    public static void setBanner(LinearLayout adContainerView, Context context) {


        if (!Constant.IS_AD_ENABLE) return;

        // Create a new ad view.
        AdView adView = new AdView(context);

        adView.setAdListener(new AdListener() {
            @Override
            public void onAdClicked() {
                Toast.makeText(context, "Add has clicked", Toast.LENGTH_SHORT).show();
            }
        });

        adView.setAdUnitId(Constant.BANNER_AD);
        adView.setAdSize(AdSize.BANNER);

// Replace ad container with new ad view.
        adContainerView.removeAllViews();
        adContainerView.addView(adView);


        // Start loading the ad in the background.
        AdRequest adRequest = new AdRequest.Builder().build();
        adView.loadAd(adRequest);


    }

}
