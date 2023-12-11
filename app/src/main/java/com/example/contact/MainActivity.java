package com.example.contact;

import static android.widget.Toast.LENGTH_LONG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    TextView title;
    EditText etNumber, etName;
    Button btn;
    ContactActivity contactActivity = new ContactActivity();

    //List<User> contactos = new ArrayList<>();





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        title = findViewById(R.id.title);
        etName = findViewById(R.id.etName);
        etNumber = findViewById(R.id.etNumber);
        btn = findViewById(R.id.btn);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        if(getIntent().hasExtra("name") && getIntent().hasExtra("number")) {
            String nameI = getIntent().getStringExtra("name");
            String numberI = getIntent().getStringExtra("number");
            String tittle = getIntent().getStringExtra("title");
            int position = getIntent().getIntExtra("position", 0);
            title.setText(tittle);
            btn.setText(tittle);
            etName.setText(nameI);
            etNumber.setText(numberI);

            btn.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View view) {

                   String name = "";
                   String number = "";

                   if(etName.getText().toString().equals("") || etNumber.getText().toString().equals("")) {
                       Toast.makeText(getApplicationContext(),"Please Enter Contact Name and numebr", Toast.LENGTH_SHORT).show();
                   }else {
                       name = etName.getText().toString();
                       number = etNumber.getText().toString();
                       //contactActivity.register(name, number);

                       Intent intent = new Intent(getApplicationContext(), ContactActivity.class);
                       intent.putExtra("name", name);
                       intent.putExtra("number", number);
                       intent.putExtra("position", position);
                       startActivity(intent);
                       Toast.makeText(getApplicationContext(), R.string.regisOK, LENGTH_LONG).show();

                       etName.setText("");
                       etNumber.setText("");
                   }

               }

        });
        }else{

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String name = "";
                String number = "";

                if(etName.getText().toString().equals("") || etNumber.getText().toString().equals("")) {
                    Toast.makeText(getApplicationContext(),"Please Enter Contact Name and numebr", Toast.LENGTH_SHORT).show();
                }else {
                    name = etName.getText().toString();
                    number = etNumber.getText().toString();
                    //contactActivity.register(name, number);

                    Intent intent = new Intent(getApplicationContext(), ContactActivity.class);
                    intent.putExtra("name", name);
                    intent.putExtra("number", number);
                    startActivity(intent);
                    Toast.makeText(getApplicationContext(), R.string.regisOK, LENGTH_LONG).show();

                    etName.setText("");
                    etNumber.setText("");
                }

            }
        });
    }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        int id = item.getItemId();

        if(id == R.id.actions_contac){
            showContact();
            return true;
        }else if (id == R.id.actions_settings){
            showSettings();
            return true;
        }else {
            return false;
        }

        /*switch (item.getItemId()){
            case R.id.actions_contact:
                showContact();
                return true;
            case 2:
                showSettings();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }*/
    }

    public void showContact(){
        Intent intent = new Intent(this, ContactActivity.class );
        startActivity(intent);
    }

    public void showSettings(){
        Intent intent = new Intent(Settings.ACTION_SETTINGS);
        startActivity(intent);

    }


}