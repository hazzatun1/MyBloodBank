package com.example.user.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class UserHome extends AppCompatActivity {
    private EditText fname,sname,phone,newv;
    private DatabaseHelper db;
    private String f_name,s_name,p_no;
    private ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_home);

        //Instantiate database handler
        db=new DatabaseHelper(this);

        lv = (ListView) findViewById(R.id.list1);

      // ShowRecords(); //etar jonno login page ei break hocche. how can i show the user list to this page???
    }



}
