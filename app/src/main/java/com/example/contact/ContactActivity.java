package com.example.contact;

import static com.google.android.material.snackbar.BaseTransientBottomBar.LENGTH_LONG;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Canvas;
import android.os.Bundle;
import android.provider.Settings;
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
import androidx.appcompat.widget.Toolbar;
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

    //RecyclerView recyclerView2 = findViewById(R.id.recyclerview);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contact_list);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        registerForContextMenu(recyclerView);

        contactos.add(new User("natanael", "9510452", R.drawable.baseline_person_24));
        contactos.add(new User("fernando", "9510452", R.drawable.baseline_person_24));
        contactos.add(new User("claudio", "9510452", R.drawable.baseline_person_24));

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);



        if(getIntent().hasExtra("name") && getIntent().hasExtra("number")){
            String name = getIntent().getStringExtra("name");
            String number = getIntent().getStringExtra("number");
            User user = new User(name, number,R.drawable.baseline_person_24);
            if(getIntent().hasExtra("position")){
                int position = getIntent().getIntExtra("position", contactos.size()-1);
                contactos.add(position, user);
                adapter.notifyItemInserted(position);
            }else {
                contactos.add(user);
                if (contactos.size() == 0) {
                    adapter.notifyItemInserted(0);
                } else {
                    adapter.notifyItemInserted(contactos.size() - 1);
                }
            }
        }






        /*RelativeLayout relatLay = findViewById(R.id.relatLay);
        registerForContextMenu(relatLay);
*/

    }

   /* @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_context, menu);
    }*/

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if(id == R.id.edit){
            editContact();
            return true;
        }else if (id == R.id.delete){
            deleteContact();
            return true;
        }else {
            return false;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_back, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        int id = item.getItemId();

        if(id == R.id.back){
            goBack();
            return true;
        }else if (id == R.id.set){
            showSettings();
            return true;
        }else {
            return false;
        }

        /*switch (item.getItemId()){
            case R.id.back:
                goBack();
                return true;
            case R.id.settings:
                showSettings();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }*/
    }

    public void goBack(){
        Intent intent = new Intent(this, MainActivity.class );
        startActivity(intent);
    }

    public void showSettings(){
        Intent intent = new Intent(Settings.ACTION_SETTINGS);
        startActivity(intent);
    }

    public void editContact(){
        int position = adapter.getPosition();
        String name = contactos.get(position).name;
        String number = contactos.get(position).number;
        contactos.remove(position);
        adapter.notifyItemRemoved(position);
        String title = "Edit";
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("name", name);
        intent.putExtra("number", number);
        intent.putExtra("position", position);
        intent.putExtra("title", title);
        startActivity(intent);


    }

    public void deleteContact(){
        int position = adapter.getPosition();
        contactos.remove(position);
        adapter.notifyItemRemoved(position);

    }

public void register(String name, String number){
    User user = new User(name, number,R.drawable.baseline_person_24);
    contactos.add(user);
    if (contactos.size() == 0){
        adapter.notifyItemInserted(0);
    }else {
        adapter.notifyItemInserted(contactos.size() - 1);
    }
}


}
