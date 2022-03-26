package com.aksolution.aictescout;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;

public class Statistics extends AppCompatActivity {
LinearLayout l1,l2,l3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_statistics);
        l1=findViewById (R.id.l1);
        l2=findViewById (R.id.l2);
        l3=findViewById (R.id.l3);
        didTapButton (l1);
        didTapButton (l2);
        didTapButton (l3);
        l1.setOnClickListener (new View.OnClickListener ( ) {
            @Override
            public void onClick(View v) {
                didTapButton (l1);
            }
        });
        l2.setOnClickListener (new View.OnClickListener ( ) {
            @Override
            public void onClick(View v) {
                didTapButton (l2);
            }
        });
        l3.setOnClickListener (new View.OnClickListener ( ) {
            @Override
            public void onClick(View v) {
                didTapButton (l3);
            }
        });
    }
    public void didTapButton(LinearLayout linearLayout) {
        final Animation myAnim = AnimationUtils.loadAnimation(this, R.anim.bounce);

        // Use bounce interpolator with amplitude 0.2 and frequency 20
        MyBounceInterpolar interpolator = new MyBounceInterpolar(0.2, 20);
        myAnim.setInterpolator(interpolator);

        linearLayout.startAnimation(myAnim);
    }
}