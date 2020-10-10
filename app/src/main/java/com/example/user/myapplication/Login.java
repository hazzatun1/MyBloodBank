package com.example.user.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Login extends AppCompatActivity {
    EditText mTextUsername;
    EditText mTextPassword;
    Button buserLogin;
    Button bdonorLogin;
    TextView bdonorReg;
    TextView buserReg;

    DatabaseHelper db;
    ViewGroup progressView;
    protected boolean isProgressShowing = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        db = new DatabaseHelper(this);
        mTextUsername = (EditText) findViewById(R.id.edittext_username);
        mTextPassword = (EditText) findViewById(R.id.edittext_password);
        buserLogin = (Button) findViewById(R.id.button_user_login);
        bdonorLogin = (Button) findViewById(R.id.button_donor_login);
        bdonorReg = (TextView) findViewById(R.id.textView_donor_register);
        buserReg = (TextView) findViewById(R.id.textView_user_register);

        if(getIntent().getExtras().containsKey("donor")){
            buserLogin.setVisibility(View.GONE);
            buserReg.setVisibility(View.GONE);

        }
        else if(getIntent().getExtras().containsKey("user")){
           bdonorLogin.setVisibility(View.GONE);
            bdonorReg.setVisibility(View.GONE);
        }
    }

    public void userLogin(View view)
     {

            String user = mTextUsername.getText().toString().trim();
            String pwd = mTextPassword.getText().toString().trim();

            boolean res = db.checkUser(user, pwd);
            if(res == true)
            {
                Toast.makeText(Login.this,"Login match",Toast.LENGTH_SHORT).show();
               // Intent HomePage = new Intent(Login.this, UserHome.class);
             //   startActivity(HomePage);
            }

            else
            {
                Toast.makeText(Login.this,"Login Error",Toast.LENGTH_SHORT).show();
            }
        }


    public void donorLogin(View view)
       {

           String user = mTextUsername.getText().toString().trim();
           String pwd = mTextPassword.getText().toString().trim();
           boolean res = db.checkDonor(user, pwd);
           if(res == true)
           {
               Toast.makeText(Login.this,"Login match",Toast.LENGTH_SHORT).show();
              // Intent HomePage = new Intent(Login.this,DonorHome.class);
             //  startActivity(HomePage);
           }

           else
           {
               Toast.makeText(Login.this,"Login Error",Toast.LENGTH_SHORT).show();
           }

        }

    public void gouserReg(View view) {

        Intent registerIntent = new Intent(Login.this, Registration.class);
        registerIntent.putExtra("user_reg","user");
        startActivity(registerIntent);

    }
    public void godonorReg(View view) {
        Intent registerIntent2 = new Intent(Login.this, Registration.class);
        registerIntent2.putExtra("donor_reg","donor");
        startActivity(registerIntent2);
    }


}

