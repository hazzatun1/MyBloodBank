package com.example.user.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class DonorHome extends AppCompatActivity {

    private EditText amount;
    private DatabaseHelper db;
    private Button free, demand;
    private  ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donor_home);


        db=new DatabaseHelper(this);

        lv = (ListView) findViewById(R.id.donar_listview);
        amount=(EditText) findViewById(R.id.amount);
        demand=(Button) findViewById(R.id.demand);
        free=(Button) findViewById(R.id.free);
       ShowRecords(); //etar jonno login page ei break hocche. how can i show the user list to this page???
    }
    private void ShowRecords(){

    }

    public void dmPlay(View view) { //dm=demand money
        String am = amount.getText().toString().trim();

            long val=db.addBlood(am);
        if(val > 0) {
            Toast.makeText(DonorHome.this, "success", Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(DonorHome.this,"Error",Toast.LENGTH_SHORT).show();
        }
    }


    public void frPlay(View view) { //fr=free donor

        String am = String.valueOf(free);

        long val=db.addBlood(am);
        if(val > 0) {
            Toast.makeText(DonorHome.this, "Success", Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(DonorHome.this,"Error",Toast.LENGTH_SHORT).show();
        }
    }
}
