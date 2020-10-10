package com.example.user.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Registration extends AppCompatActivity {
    DatabaseHelper db;
    EditText mTextUsername;
    EditText mTextPassword;
    EditText mTextCnfPassword;
    EditText bloodGroup;
    EditText contact;
    EditText address;
    Button bdonorReg;
    Button buserReg;
    TextView tuserLogin;
    TextView tdonorLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        db = new DatabaseHelper(this);
        mTextUsername = (EditText) findViewById(R.id.edittext_username);
        mTextPassword = (EditText) findViewById(R.id.edittext_password);
        mTextCnfPassword = (EditText) findViewById(R.id.edittext_cnf_password);
        bloodGroup = (EditText) findViewById(R.id.bloodGroup);
        contact = (EditText) findViewById(R.id.Contact);
        address = (EditText) findViewById(R.id.Address);
        bdonorReg = (Button) findViewById(R.id.button_donor_reg);
        buserReg = (Button) findViewById(R.id.button_user_reg);
        tuserLogin = (TextView) findViewById(R.id.textview_user_login);
        tdonorLogin = (TextView) findViewById(R.id.textview_donor_login);

        if(getIntent().getExtras().containsKey("donor_reg")){
            tuserLogin.setVisibility(View.GONE);
            buserReg.setVisibility(View.GONE);

        }
        else if(getIntent().getExtras().containsKey("user_reg")){
            tdonorLogin.setVisibility(View.GONE);
            bdonorReg.setVisibility(View.GONE);
        }


        tuserLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent LoginIntent = new Intent(Registration.this, Login.class);
                LoginIntent.putExtra("user","userLogin");
                startActivity(LoginIntent);
            }
        });


        tdonorLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent LoginIntent2 = new Intent(Registration.this, Login.class);
                LoginIntent2.putExtra("donor","donorLogin");
                startActivity(LoginIntent2);
            }
        });

    }


    public void inDonorReg(View view) {
        String user = mTextUsername.getText().toString().trim();//trim extra space kete day.
        String pwd = mTextPassword.getText().toString().trim();
        String cnf_pwd = mTextCnfPassword.getText().toString().trim();
        String bg = bloodGroup.getText().toString().trim();//trim extra space kete day.
        String ct = contact.getText().toString().trim();
        String ad = address.getText().toString().trim();
        if (pwd.equals(cnf_pwd)) {
            boolean val = db.addDonor(user, pwd, ct, bg, ad);
            if (val == true && null != db)
                Toast.makeText(Registration.this, "You have registered", Toast.LENGTH_LONG).show();
            else
                Toast.makeText(Registration.this, "Registration Error", Toast.LENGTH_LONG).show();

        }
        else{
            Toast.makeText(Registration.this,"Password is not matching",Toast.LENGTH_SHORT).show();
        }
    }

    public void inUserReg(View view) {
        String user = mTextUsername.getText().toString().trim();//trim extra space kete day.
        String pwd = mTextPassword.getText().toString().trim();
        String cnf_pwd = mTextCnfPassword.getText().toString().trim();
        String bg = bloodGroup.getText().toString().trim();//trim extra space kete day.
        String ct = contact.getText().toString().trim();
        String ad = address.getText().toString().trim();
        if (pwd.equals(cnf_pwd)) {
            boolean val = db.addUser(user, pwd, bg, ct, ad);

            if(val==true && null != db)
                Toast.makeText(Registration.this,"You have registered", Toast.LENGTH_LONG).show();
            else
                Toast.makeText(Registration.this,"Registration Error", Toast.LENGTH_LONG).show();

        }
        else {
            Toast.makeText(Registration.this, "Password is not matching", Toast.LENGTH_SHORT).show();
        }
    }

    }
