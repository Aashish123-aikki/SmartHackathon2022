package com.aksolution.aictescout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Collections;
import java.util.regex.Pattern;

public class affiliatedinstitute extends AppCompatActivity {
ArrayList<String> institutetypeList=new ArrayList<> (  );
ArrayList<String> statelist=new ArrayList<> (  );
ArrayList<String>levellist=new ArrayList<> (  );
ArrayList<String> programlist=new ArrayList<> (  );
ArrayList<String> institueName=new ArrayList<> (  );
ArrayList<String> instituLink=new ArrayList<> (  );
ArrayList<String> calandeLink=new ArrayList<> (  );
DatabaseReference databaseReference= FirebaseDatabase.getInstance ().getReference ("institutelist");
ListView clglistview;
    AffiliateAdapter affiliateAdapter;
Spinner itypeSpinner,stateSpinner,lSpinner,programSpinner;
Button okbtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_affiliatedinstitute);
        itypeSpinner=findViewById (R.id.spinnerInstituteType);
        stateSpinner=findViewById (R.id.spinnerstate);
        lSpinner=findViewById (R.id.spinnerlevel);
        programSpinner=findViewById (R.id.spinner);
        clglistview=findViewById (R.id.listcolg);
        okbtn=findViewById (R.id.button2);
        okbtn.setOnClickListener (new View.OnClickListener ( ) {
            @Override
            public void onClick(View v) {
                didTapButton (okbtn);
            }
        });
        String typelist[]={"All","Private","Central University","Deemed to be University(Govt)","Deemed to be University(Pvt)",
                "Deemed University(Government)","Deemed University(Private)","Government",
                "Govt aided","Private-Aided","Self Financing","State Government University","State Private University",
                "Unaided - Private","University Managed","University Managed-Govt","University Managed-Private"
        };
        String state[]={"All","Andaman and Nicobar Islands", "Andhra Pradesh", "Arunachal Pradesh", "Assam", "Bihar",
                "Chhattisgarh", "Delhi", "Goa", "Gujarat", "Haryana", "Himachal Pradesh", "Jammu and Kashmir", "Jharkhand", "Karnataka", "Kerala", "Madhya Pradesh",
                "Maharashtra", "Manipur", "Meghalaya", "Mizoram", "Nagaland", "Odisha", "Punjab", "Rajasthan", "Sikkim", "Tamil Nadu", "Telangana",
                "Tripura", "Uttar Pradesh", "Uttarakhand", "West Bengal"};
        String program[]={"All","Applied Arts and Crafts","Architecture and Town Planning", "Architecture and Planning","Architecture", "Planning",
               "Design","Town Planning", "Engineering and Technology,Management", "MCA", "Pharmacy", "Hotel Management and Catering"
        };
        String degree[]={"All","Diploma","UG","PG"};

        databaseReference.addListenerForSingleValueEvent (valulisner);
        ArrayAdapter<String> stateadapter=new ArrayAdapter<> (this, android.R.layout.simple_spinner_item,state);
        ArrayAdapter<String> typeadapter=new ArrayAdapter<> (this, android.R.layout.simple_spinner_item,typelist);
        ArrayAdapter<String> programadapter=new ArrayAdapter<> (this, android.R.layout.simple_spinner_item,program);
        ArrayAdapter<String> degreeadapter=new ArrayAdapter<> (this, android.R.layout.simple_spinner_item,degree);
        //Adapter setting//
        stateSpinner.setAdapter (stateadapter);
        lSpinner.setAdapter (degreeadapter);
        programSpinner.setAdapter (programadapter);
        itypeSpinner.setAdapter (typeadapter);
        //Adapter over............
        clglistview.setOnTouchListener (new View.OnTouchListener ( ) {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction ( )) {
                    case MotionEvent.ACTION_DOWN:
                        v.getParent ( ).requestDisallowInterceptTouchEvent (true);
                    case MotionEvent.ACTION_UP:
                        v.getParent ( ).requestDisallowInterceptTouchEvent (true);
                }
                v.onTouchEvent (event);
                return  true;
            }
        });
      affiliateAdapter  =new AffiliateAdapter (affiliatedinstitute.this,institueName,instituLink,calandeLink);
        clglistview.setAdapter (affiliateAdapter);
    }
    ValueEventListener valulisner=new ValueEventListener ( ) {
        @Override
        public void onDataChange(@NonNull DataSnapshot snapshot) {
            if(snapshot.exists ()){
                for(DataSnapshot snapshot1:snapshot.getChildren ()){
                    for(DataSnapshot snapshot2:snapshot1.getChildren ()) {
                        institutelist institutelisT = snapshot2.getValue (institutelist.class);
                        institueName.add (institutelisT.getUniversity ( ));
                        calandeLink.add (institutelisT.getAcademicCalender ( ));
                        instituLink.add (institutelisT.getWebsitelink ( ));
                    }affiliateAdapter.notifyDataSetChanged ();
                }
            }
            else{
                Toast.makeText (affiliatedinstitute.this, "No Data!", Toast.LENGTH_SHORT).show ( );
            }
        }

        @Override
        public void onCancelled(@NonNull DatabaseError error) {

        }
    };
    public void didTapButton(Button button) {
        final Animation myAnim = AnimationUtils.loadAnimation(this, R.anim.bounce);

        // Use bounce interpolator with amplitude 0.2 and frequency 20
        MyBounceInterpolar interpolator = new MyBounceInterpolar(0.2, 20);
        myAnim.setInterpolator(interpolator);

        button.startAnimation(myAnim);
    }
}