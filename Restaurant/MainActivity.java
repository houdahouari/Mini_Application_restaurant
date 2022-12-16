package com.example.restaurant;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
Button login;
TextView signup;
EditText username,password;
Utilisateur utilisateur;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_main);
        username=findViewById(R.id.user_email);
        password=findViewById(R.id.password);
        login=findViewById(R.id.loginbtn);
        signup=findViewById(R.id.signup);
        utilisateur=new Utilisateur(this);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor c=utilisateur.VerifyUser(username.getText().toString(),password.getText().toString());
                if (c.getCount()==0){
                    Toast.makeText(getApplicationContext(),"try again",Toast.LENGTH_LONG).show();

                }
                else{

                    Intent intent=new Intent(getApplicationContext(),Menu_Food.class);
                    startActivity(intent);
                }
            }
        });
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),Register.class);
                startActivity(intent);
            }
        });

    }
}