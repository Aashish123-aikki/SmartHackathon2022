package com.aksolution.aictescout;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.transition.Fade;
import android.transition.Slide;
import android.transition.TransitionInflater;

import com.github.ybq.android.spinkit.SpinKitView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_main);
        setupWindowAnimations ();
        new Handler (  ).postDelayed (new Runnable ( ) {
            @Override
            public void run() {
                startActivity (new Intent ( MainActivity.this, dashboard.class));
            }
        },2000);
    }


    private void setupWindowAnimations() {
        Slide slide = (Slide) TransitionInflater.from(this).inflateTransition(R.transition.slide);
        getWindow().setExitTransition(slide);

        Fade fade = (Fade) TransitionInflater.from(this).inflateTransition(R.transition.fade);
        getWindow().setReturnTransition (fade);
    }
}