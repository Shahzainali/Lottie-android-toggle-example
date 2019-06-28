package com.example.lottie;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.content.DialogInterface;
import android.hardware.biometrics.BiometricPrompt;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.airbnb.lottie.LottieAnimationView;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieOnCompositionLoadedListener;

public class MainActivity extends AppCompatActivity {

    LottieAnimationView lav;
    Boolean ischecked = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lav = findViewById(R.id.intro_lottie_animation_view);
        //Set this according tou your animation in my animation there is some extra time in the end so i eliminated it by setting max to 0.75
        lav.setMinAndMaxProgress(0, 0.75f);

        //Animation was slow so I increased speed
        lav.setSpeed(3);



     //These are listeners for animation in my project I dont need these.
        lav.addAnimatorListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationCancel(Animator animation) {
                super.onAnimationCancel(animation);
            }

            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
            }

            @Override
            public void onAnimationRepeat(Animator animation) {
                super.onAnimationRepeat(animation);
            }

            @Override
            public void onAnimationStart(Animator animation) {
                super.onAnimationStart(animation);
            }

            @Override
            public void onAnimationPause(Animator animation) {
                super.onAnimationPause(animation);
            }

            @Override
            public void onAnimationResume(Animator animation) {
                super.onAnimationResume(animation);
            }
        });

        lav.addAnimatorUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                Log.d("LottieLogs", String.valueOf(animation.getAnimatedValue()));
                String s = String.valueOf(animation.getAnimatedValue());
                if((Double.valueOf(s)-0.35)>0.1){
                   if(ischecked) {
                       lav.pauseAnimation();

                   }

                }

            }
        });






    }

    public void onClick(View v){
        if(!lav.isAnimating()) {
            lav.resumeAnimation();
            ischecked = !ischecked;
            Toast.makeText(this, String.valueOf(ischecked), Toast.LENGTH_SHORT).show();
        }
    }






}
