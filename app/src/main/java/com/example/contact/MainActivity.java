package com.example.contact;

import static android.widget.Toast.LENGTH_LONG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
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

    List<User> contactos = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        title = findViewById(R.id.title);
        etName = findViewById(R.id.etName);
        etNumber = findViewById(R.id.etNumber);
        btn = findViewById(R.id.btn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name;
                int number;
                name = etName.getText().toString();
                number = etNumber.getText().length();
                Intent intent = new Intent(getApplicationContext(), ContactActivity.class);
                intent.putExtra("name", name);
                intent.putExtra("number", number);
                Toast.makeText(getApplicationContext(), R.string.regisOK, LENGTH_LONG).show();
                startActivity(intent);

            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

   /* @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.contac:
                showContact();
                return true;
            case R.id.settings:
                showSettings();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }*/

    public void showContact(){
        Intent intent = new Intent(this, MainActivity.class );
        startActivity(intent);
    }

    public void showSettings(){

    }
}