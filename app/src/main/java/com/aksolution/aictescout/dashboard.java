package com.aksolution.aictescout;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.transition.Fade;
import android.transition.Slide;
import android.transition.TransitionInflater;
import android.util.Pair;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.ViewFlipper;

import java.util.ArrayList;

public class dashboard extends AppCompatActivity {
        GridView gridView;

        ArrayList<Integer> img=new ArrayList<> (  );
        ArrayList<String> title=new ArrayList<> (  );
        ArrayList<Integer> dashimages=new ArrayList<> (  );
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setupWindowAnimations ();
        setContentView (R.layout.activity_dashboard);
        gridView =findViewById (R.id.gview);

        img.add (R.drawable.university);
        img.add (R.drawable.acalendar);
        img.add (R.drawable.academicsyllabus);
        img.add (R.drawable.statistics);
        title.add ("Affiliated University/Institute");
        title.add ("Academic Calendar");
        title.add ("Syllabus");
        title.add ("Statistics");

        dashimages.add (R.drawable.d1);
        dashimages.add (R.drawable.d2);
        dashimages.add (R.drawable.d3);

        IMGwithTitleAdapter imGwithTitleAdapter=new IMGwithTitleAdapter (dashboard.this,img,title);
        gridView.setAdapter (imGwithTitleAdapter);



        //gridView Item cLick Listner......
        gridView.setOnItemClickListener (new AdapterView.OnItemClickListener ( ) {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//
                Intent intent=new Intent (  );
                    switch (position){
                        case 0:
                            intent=new Intent ( dashboard.this,affiliatedinstitute.class );
                            break;
                        case 1:
                            intent=new Intent ( dashboard.this,academicCalender.class );
                            break;
                        case 2:
                            intent=new Intent ( dashboard.this,syllabus.class );
                            break;
                        case 3:
                            intent=new Intent ( dashboard.this,Statistics.class );
                            break;
                    }
                Pair[] pairs=new Pair[1];
                    pairs[0]=new Pair <View,String>(gridView,"transit");
                ActivityOptions activityOptions=ActivityOptions.makeSceneTransitionAnimation (dashboard.this,pairs);
                    startActivity (intent,activityOptions.toBundle ());
            }
        });

    }

    //Tap Button Animation for View.....
    public void didTapButton(View view) {
        final Animation myAnim = AnimationUtils.loadAnimation(this, R.anim.bounce);

        // Use bounce interpolator with amplitude 0.2 and frequency 20
        MyBounceInterpolar interpolator = new MyBounceInterpolar(0.2, 20);
        myAnim.setInterpolator(interpolator);

        view.startAnimation(myAnim);
    }
    //Tap Button Animation for button.....
    public void didTapButton(Button button) {
        final Animation myAnim = AnimationUtils.loadAnimation(this, R.anim.bounce);

        // Use bounce interpolator with amplitude 0.2 and frequency 20
        MyBounceInterpolar interpolator = new MyBounceInterpolar(0.2, 20);
        myAnim.setInterpolator(interpolator);

        button.startAnimation(myAnim);
    }
    private void setupWindowAnimations() {
        Slide slide = (Slide) TransitionInflater.from(this).inflateTransition(R.transition.slide);
        getWindow().setExitTransition(slide);

     Fade fade = (Fade) TransitionInflater.from(this).inflateTransition(R.transition.fade);
        getWindow().setReturnTransition (fade);
    }
}