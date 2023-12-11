package com.example.contact;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyViewHolder extends RecyclerView.ViewHolder {

    ImageView imageView;
    TextView nameview, numberview;


    public MyViewHolder(@NonNull View contact_view) {
        super(contact_view);
        imageView = contact_view.findViewById(R.id.imageview);
        nameview = contact_view.findViewById(R.id.name);
        numberview = contact_view.findViewById(R.id.number);
    }
}