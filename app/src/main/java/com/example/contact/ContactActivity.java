package com.example.contact;

import static com.google.android.material.snackbar.BaseTransientBottomBar.LENGTH_LONG;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Canvas;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;


public class ContactActivity extends AppCompatActivity {

    List<User> contactos = new ArrayList<>();
    MyAdapter adapter = new MyAdapter(this, contactos);
    RecyclerView recyclerView = findViewById(R.id.recyclerview);
    //RecyclerView recyclerView2 = findViewById(R.id.recyclerview);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contact_list);



        if(getIntent().hasExtra("name") && getIntent().hasExtra("number")){
            String name = getIntent().getStringExtra("name");
            int number = getIntent().getIntExtra("number", 0);
            User user = new User(name, number);
            contactos.add(user);
            adapter.notifyItemInserted(contactos.size()-1);
        }




        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        /*RelativeLayout relatLay = findViewById(R.id.relatLay);
        registerForContextMenu(relatLay);
*/

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_context, menu);
    }

   /* @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.edit:
                editContact();
                return true;
            case R.id.delete:
                deleteContact();
                return true;
            default:
                return super.onContextItemSelected(item);

        }
    }*/

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_back, menu);
        return true;
    }

/*    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.back:
                goBack();
                return true;
            case R.id.settings:
                showSettings();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }*/

    public void goBack(){
        Intent intent = new Intent(this, MainActivity.class );
        startActivity(intent);
    }

    public void showSettings(){

    }

    public void editContact(){

    }

 /*   public void deleteContact(){

        int position = adapter.
        User user = contactos.get(1);
        String nameDelete = user.name;
        contactos.remove(position);
        adapter.notifyItemRemoved(position);
        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        Snackbar.make(recyclerView, nameDelete + " deleted!", LENGTH_LONG)
                .setAction("Undo", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        items.add(position, user);
                        adapter.notifyItemInserted(position);
                    }
                }).show();
    }*/




}
