package com.aksolution.aictescout;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class IMGwithTitleAdapter extends ArrayAdapter {
ArrayList<Integer>img;
ArrayList<String>title;
Context context;
    public IMGwithTitleAdapter(@NonNull Context context, ArrayList<Integer> img,ArrayList<String>title) {
        super (context, R.layout.imgwithtitle,title);
        this.context=context;
        this.img=img;
        this.title=title;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view= LayoutInflater.from (context).inflate (R.layout.imgwithtitle,parent,false);
        TextView textView=view.findViewById (R.id.textView3);
        ImageView imageView=view.findViewById (R.id.imageView2);
        textView.setText (title.get (position));
        imageView.setImageResource (img.get (position));
        return view;
    }
}
