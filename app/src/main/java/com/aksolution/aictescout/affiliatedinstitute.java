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
import java.util.regex.Pattern;

public class affiliatedinstitute extends AppCompatActivity {
ArrayList<String> institutetypeList=new ArrayList<> (  );
ArrayList<String> statelist=new ArrayList<> (  );
ArrayList<String>levellist=new ArrayList<> (  );
ArrayList<String> programlist=new ArrayList<> (  );
ArrayList<String> institueName=new ArrayList<> (  );
ArrayList<String> instituLink=new ArrayList<> (  );
ArrayList<String> calandeLink=new ArrayList<> (  );
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

//        String instName[]= {"Ali Yavar Jung National Institute For The Hearing Handicapped, Noida", "Ambedkar Institute of Advanced Communication Technologies & Research, Geeta Colony, Delhi – 110092",
//                "Bhai Parmanand Institute of Business Studies, Opp. Madhuban, Shakarpur (Extn.), Delhi - 110092",
//                "ESI - PGIMSR, ESI Hospital, Basaidarpur, New Delhi", "C-DAC, NOIDA (formaly Electronics Research & Development Centre of India) Govt. of India, Anusandhan Bhawan, C - 56/1, Institutional Area, Sector - 62, NOIDA",
//                "Ch. Brahm Prakash Ayurved Charak Sansthan, Khera Dabar, Najafgarh, Delhi - 110073", "College of Nursing, VMMC & Safdarjang Hospital, New Delhi - 110026",
//                "College of Nursing, Dr. Ram Manohar Lohia Hospital, New Delhi - 110001", "Delhi Institute of Heritage Research & Management, 18A, Satsang Vihar Marg, Special Institute Area, New Delhi - 67",
//
//                "Dr.B.R.Sur Homeopathic Medical College and Hospital and Research Centre, Nanakpura, Moti Bagh, New Delhi - 110021",
//                "Dr.Ram Manohar Lohia Hospital, Post Graduate Institute of Medical Education & Research (PGIMER), New Delhi",
//                "Delhi Institute of Tool Engineering, Okhla Industrial Area, Phase - II, Delhi - 20, (Head Office at Wazirpur Industrial Area, Delhi - 110052) ",
//
//        "ESIC Dental College, Rohini, New Delhi - 110085 ",
//        "G.B.Pant Institute of Technology, Okhla, Phase -III, New Delhi ",
//        "G.B.Pant Govt.Engineering College, Okhla, Phase -III, New Delhi ",
//        "Ch.Brahm Prakash Govt.Engineering College, Behind Rao Tula Ram Hospital, Jaffarpur, New Delhi - 110073 ",
//        "National Institute of Labour Economics Research &Development (Formerly IAMR), Narela, Delhi 110040 ",
//        "Integrated Institute of Technology, Sector 9, Dwarka, New Delhi - 110075 ",
//        "Lok Nayak Jayaprakash Narayan National Institute of Criminology and Forensic Science, Sector 3, Outer Ring Road, Rohini, Delhi ",
//        "Meera Bai Integrated Institute of Technology, Maharani Bagh, New Delhi ",
//        "Morarji Desai National Institute of Yoga, 68, Ashoka Road, New Delhi ",
//        "National Institute ofPublic Coorperation and Child Development, 5, Siri",
//        "Institutional Area, Hauz Khas, New Delhi - 110016 ",
//        "Vardhaman Mahavir Medical College &Safdarjang Hospital, New Delhi - 110026 ",
//        "State Council of Education Research & Training, Varun Marg, Defence Colony, New Delhi ",
//        "NDMC Medical college at Hindu Rao Hospital, Malika Ganj, Delhi ",
//        "Ambedkar Institute of Technology, Shakarpur, Opp.Madhuban, Patparganj Road, Delhi - 92(Earlier as Ambedkar Integrated Institute of Engineering &Technology)",
//        "Aryabhatt Institute of Technology, Near Shakti Nagar, Tele Exchange, G.T.Karnal Road, New Delhi ",
//        "Guru Nanak Dev Institute of Technology, Institutional Area, Sector - 15, Rohini, Delhi –110089, Ph .011 - 27567819, 27552645 ",
//        "Kasturba Gandhi Institute of Technology, Pitampura, Muni Maya Ram Marg, New Delhi - 110088",
//        "College of Medical Lab Technology, Hindu Rao Hospital, Malkaganj, Delhi ",
//        "Pusa Institute of Technology ",
//        "Dr.BSA Hospital Medical College Sector 6, Rohini Delhi - 110085 ",
//        "Department of Psychiatric Social Work",
//        };
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