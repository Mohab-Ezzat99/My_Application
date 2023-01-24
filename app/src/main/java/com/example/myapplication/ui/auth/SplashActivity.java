package com.example.myapplication.ui.auth;


import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.myapplication.R;

public class SplashActivity extends AppCompatActivity {
    ImageView ivtop ,ivbottom ,ivbeat ,ivheart;
    TextView textView;
    CharSequence charSequence;
    int index;
    long delay = 100;
    Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        ivtop = findViewById(R.id.iv_top);
        ivbeat = findViewById(R.id.ivbeat);
        ivbottom = findViewById(R.id.iv_bottom);
        ivheart = findViewById(R.id.iv_heart);
        textView = findViewById(R.id.text_view);

        // set full screen

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        // intialize top Animation

        Animation animation1 = AnimationUtils.loadAnimation(this,R.anim.top_wave);

        ivtop.setAnimation(animation1);

        //intialize oject animator


        ObjectAnimator objectAnimator =ObjectAnimator.ofPropertyValuesHolder(ivheart,
                PropertyValuesHolder.ofFloat("scaleX",1.2f),
                PropertyValuesHolder.ofFloat("scaleY",1.2f)
        );

        // set duration

        objectAnimator.setDuration(300);
        // set repeat count
        objectAnimator.setRepeatCount(ValueAnimator.INFINITE);
        // set repeat mode
        objectAnimator.setRepeatMode(ValueAnimator.REVERSE);
        objectAnimator.start();
        animatText("Doctor Kids");
        Glide.with(this).asGif().load(R.drawable.splash_back)
                .diskCacheStrategy(DiskCacheStrategy.ALL).into(ivbeat);

        // intialize bottom animation

        Animation animation2 = AnimationUtils.loadAnimation(this,R.anim.bottom_wave);

        ivbottom.setAnimation(animation2);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                startActivity(new Intent(SplashActivity.this, LoginActivity.class)
                        .setFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
                finish();

            }
        },4000);


    }

    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            textView.setText(charSequence.subSequence(0,index++));

            if(index<=charSequence.length()){

                handler.postDelayed(runnable,delay);
            }
        }
    };

    public  void animatText(CharSequence cs){

        charSequence = cs;
        index = 0;

        textView.setText("");
        handler.removeCallbacks(runnable);
        handler.postDelayed(runnable,delay);
    }
}
