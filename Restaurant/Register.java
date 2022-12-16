package com.example.restaurant;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Register extends AppCompatActivity {
    TextView login;
    EditText username,email,password;
    Button account;
    Utilisateur utilisateur;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        login=findViewById(R.id.login);
        username=findViewById(R.id.username);
        email=findViewById(R.id.email);
        password=findViewById(R.id.password);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
            }
        });
        account=findViewById(R.id.create_account);
        utilisateur=new Utilisateur(this);
        account.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean res=utilisateur.addUser(username.getText().toString(),email.getText().toString(),password.getText().toString());
                if(res==true){
                    Intent intent=new Intent(getApplicationContext(),Menu_Food.class);
                    startActivity(intent);
                }

            }
        });
    }
}