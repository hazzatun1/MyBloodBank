package com.example.user.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       // Button donor= findViewById(R.id.btnDonor);
      //  Button user= findViewById(R.id.btnUser);
     //   Intent intent=getIntent();
    }
    public void donorPlay(View view) {
      //  String value= "donor";
        Intent intent1=new Intent(this,Login.class);
        intent1.putExtra("donor","donor");
        startActivity(intent1);

    }

    public void userPlay(View view) {
       // String value= "user";
        Intent intent3=new Intent(this,Login.class);
        intent3.putExtra("user","user");
        startActivity(intent3);

    }
}

