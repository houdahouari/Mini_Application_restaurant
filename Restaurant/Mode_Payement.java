package com.example.restaurant;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Mode_Payement extends AppCompatActivity {
    Button card,cash;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mode_payement);

        card=findViewById(R.id.card);
        cash=findViewById(R.id.cash);

        card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),Card_Payment.class);
                startActivity(intent);
            }
        });
        cash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(getApplicationContext(),PaymentSuccf.class);
                startActivity(intent);
            }
        });
    }
}