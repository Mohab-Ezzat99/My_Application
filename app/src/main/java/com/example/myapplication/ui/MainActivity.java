package com.example.myapplication.ui;


import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;

public class MainActivity extends AppCompatActivity {
    // Time to Display Splash screen
    private static int SPLASH_SCREEN = 5000;

    // Variables
    Animation topanim;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //To set full screen mode or extends the overly view
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
//====================================================================
        // load animations
        topanim = AnimationUtils.loadAnimation(this, R.anim.top_animation);
        //load image
        imageView = findViewById(R.id.imageView);
        // Apply animation
        imageView.setAnimation(topanim);
//====================================================================
        // Handler and post delay for showing the screen for some time and go to next intent
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // To Move To next intent
                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intent);
                // Finish for Destroy the first activity and don't let user return to splash screen
                finish();
            }
        }, SPLASH_SCREEN);


    }
}
