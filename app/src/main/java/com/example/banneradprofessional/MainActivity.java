package com.example.banneradprofessional;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.example.banneradprofessional.monetization.Admob;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        LinearLayout adContainerView = findViewById(R.id.adContainer);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) Button btn1 = findViewById(R.id.btn1);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(MainActivity.this, SecondActivity.class));

            }
        });

        // Initialize the Google Mobile Ads SDK on a background thread.

        Admob.sdkInitialize(this);

        // Set up the banner ad view.
        Admob.setBanner(adContainerView, this);


    }
}