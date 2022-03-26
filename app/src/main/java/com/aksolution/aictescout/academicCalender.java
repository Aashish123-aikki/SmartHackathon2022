package com.aksolution.aictescout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class academicCalender extends AppCompatActivity {
    ArrayList<String> institueName=new ArrayList<> (  );

    ArrayList<String> instituLink=new ArrayList<> (  );
    DatabaseReference databaseReference= FirebaseDatabase.getInstance ().getReference ("institutelist");
    ListView clglistview;
    AffiliateAdapter2 affiliateAdapter2;
    ArrayList<String> calandeLink=new ArrayList<> (  );
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_academic_calender);
        databaseReference.addListenerForSingleValueEvent (valulisner);
        clglistview=findViewById (R.id.listcal);
        affiliateAdapter2 =new AffiliateAdapter2 (academicCalender.this,institueName,instituLink,calandeLink);
        clglistview.setAdapter (affiliateAdapter2);
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
                instituLink.add (institutelisT.getWebsitelink ());
                }affiliateAdapter2.notifyDataSetChanged ();
            }
        }
        else{
            Toast.makeText (academicCalender.this, "No Data!", Toast.LENGTH_SHORT).show ( );
        }
    }

    @Override
    public void onCancelled(@NonNull DatabaseError error) {

    }
};
}