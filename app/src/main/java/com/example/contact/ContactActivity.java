package com.example.contact;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.contact.utils.Comon;


public class ContactActivity extends AppCompatActivity {
    MyAdapter adapter = new MyAdapter(this, Comon.contactos);

    //RecyclerView recyclerView2 = findViewById(R.id.recyclerview);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contact_list);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        registerForContextMenu(recyclerView);



        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);



        if(getIntent().hasExtra("name") && getIntent().hasExtra("number")){
            String name = getIntent().getStringExtra("name");
            String number = getIntent().getStringExtra("number");
            User user = new User(name, number,R.drawable.baseline_person_24);
            if(getIntent().hasExtra("position")){
                int position = getIntent().getIntExtra("position", Comon.contactos.size()-1);
                Comon.contactos.add(position, user);
                adapter.notifyItemInserted(position);
            }else {
                Comon.contactos.add(user);
                if (Comon.contactos.size() == 0) {
                    adapter.notifyItemInserted(0);
                } else {
                    adapter.notifyItemInserted(Comon.contactos.size() - 1);
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
        String name = Comon.contactos.get(position).name;
        String number = Comon.contactos.get(position).number;
        String title = "Edit";
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("name", name);
        intent.putExtra("number", number);
        intent.putExtra("position", position);
        intent.putExtra("title", title);
        startActivity(intent);


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 1){
            if(resultCode == Activity.RESULT_OK) {
                int position = data.getIntExtra("position", 0);
                adapter.notifyItemChanged(position);
                Toast.makeText(getApplicationContext(),"OK",Toast.LENGTH_LONG);
            }
        }
    }

    public void deleteContact(){
        int position = adapter.getPosition();
        Comon.contactos.remove(position);
        adapter.notifyItemRemoved(position);

    }




}
