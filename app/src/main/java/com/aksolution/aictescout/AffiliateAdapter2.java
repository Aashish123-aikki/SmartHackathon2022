package com.aksolution.aictescout;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class AffiliateAdapter2 extends ArrayAdapter {
    ArrayList<String> uName;
    ArrayList<String> wLink;
    ArrayList<String> cLink;
    Context context;
    public AffiliateAdapter2(@NonNull Context context, ArrayList<String>uName, ArrayList<String>wLink, ArrayList<String>cLink) {
        super (context, R.layout.layout_affiliatelist,uName);
        this.uName=uName;
        this.cLink=cLink;
        this.wLink=wLink;
        this.context=context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view= LayoutInflater.from (context).inflate (R.layout.layout_affiliatelist,parent,false);
        TextView weblink,calenlink,uniname,count;
        count=view.findViewById (R.id.textView5);
        uniname=view.findViewById (R.id.textView6);
        weblink=view.findViewById (R.id.textView7);
        calenlink=view.findViewById (R.id.textView8);
        LinearLayout layout=view.findViewById (R.id.hidenlayout);
        layout.setVisibility (View.GONE);
        uniname.setOnClickListener (new View.OnClickListener ( ) {
            @Override
            public void onClick(View v) {
                layout.setVisibility (View.VISIBLE);
            }
        });
        weblink.setText (wLink.get (position));
        calenlink.setText (cLink.get (position));
        uniname.setText (uName.get (position));
        weblink.setVisibility (View.GONE);
        count.setText (Integer.toString (position+1));
        weblink.setOnClickListener (new View.OnClickListener ( ) {
            @Override
            public void onClick(View v) {
                Uri uri=Uri.parse (wLink.get (position));
                Intent intent1=new Intent ( Intent.ACTION_VIEW,uri );
                getContext ().startActivity (intent1);
            }
        });
       calenlink.setOnClickListener (new View.OnClickListener ( ) {
            @Override
            public void onClick(View v) {
                Uri uri=Uri.parse (cLink.get (position));
                Intent intent1=new Intent ( Intent.ACTION_VIEW,uri );
                getContext ().startActivity (intent1);
            }
        });
        return view;
    }
}
