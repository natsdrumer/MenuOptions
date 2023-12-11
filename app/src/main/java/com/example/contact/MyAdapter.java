package com.example.contact;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.contact.User;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyViewHolder> {

    Context context;
    List<User> contactos;

    //MyViewHolder holder;

    public MyAdapter(Context context, List<User> contactos) {
        this.context = context;
        this.contactos = contactos;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.contact_view, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {


        //holder.nameview.setText(contactos.get(position).getName());
        //holder.numberview.setText(contactos.get(position).getNumber());
        //holder.imageView.setImageResource(contactos.get(position).getImage());


    }

    @Override
    public int getItemCount() {
        return contactos.size();
    }
}