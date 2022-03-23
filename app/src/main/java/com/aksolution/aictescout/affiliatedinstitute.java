package com.aksolution.aictescout;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.Collections;

public class affiliatedinstitute extends AppCompatActivity {
ArrayList<String> institutetypeList=new ArrayList<> (  );
ArrayList<String> statelist=new ArrayList<> (  );
ArrayList<String>levellist=new ArrayList<> (  );
ArrayList<String> programlist=new ArrayList<> (  );
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
        okbtn=findViewById (R.id.button2);
        String typelist[]={"All","Private","Central University","Deemed to be University(Govt)","Deemed to be University(Pvt)",
                "Deemed University(Government)","Deemed University(Private)","Government",
                "Govt aided","Private-Aided","Private-Self Financing","State Government University","State Private University",
                "Unaided - Private","University Managed","University Managed-Govt","University Managed-Private"
        };
        String state[]={"Andaman and Nicobar Islands", "Andhra Pradesh", "Arunachal Pradesh", "Assam", "Bihar",
                "Chhattisgarh", "Delhi", "Goa", "Gujarat", "Haryana", "Himachal Pradesh", "Jammu and Kashmir", "Jharkhand", "Karnataka", "Kerala", "Madhya Pradesh",
                "Maharashtra", "Manipur", "Meghalaya", "Mizoram", "Nagaland", "Odisha", "Punjab", "Rajasthan", "Sikkim", "Tamil Nadu", "Telangana",
                "Tripura", "Uttar Pradesh", "Uttarakhand", "West Bengal"};
        String program[]={"Applied Arts and Crafts","Architecture and Town Planning", "Architecture and Planning","Architecture", "Planning",
               "Design","Town Planning", "Engineering and Technology,Management", "MCA", "Pharmacy", "Hotel Management and Catering"
        };
        String degree[]={"Diploma","UG","PG"};
//       for(String s:typelist){
//           institutetypeList.add (s);
//       }
//       for(String s:state){
//           statelist.add (s);
//       }
//       for(String s:program){
//           programlist.add (s);
//       }
//       levellist.add ("Diploma");
//       levellist.add ("UG");
//       levellist.add ("PG");
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

    }

    public void didTapButton(Button button) {
        final Animation myAnim = AnimationUtils.loadAnimation(this, R.anim.bounce);

        // Use bounce interpolator with amplitude 0.2 and frequency 20
        MyBounceInterpolar interpolator = new MyBounceInterpolar(0.2, 20);
        myAnim.setInterpolator(interpolator);

        button.startAnimation(myAnim);
    }
}