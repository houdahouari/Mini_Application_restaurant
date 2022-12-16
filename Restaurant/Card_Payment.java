package com.example.restaurant;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Card_Payment extends AppCompatActivity {
    Button btn;
    EditText card,card_num,ccv;
    TextView t1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_payment);
        btn=findViewById(R.id.pay);
        card=findViewById(R.id.nameCard);
        card_num=findViewById(R.id.cardNumber);
        ccv=findViewById(R.id.ccv);

        t1=findViewById(R.id.er1);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), PaymentSuccf.class);
                if (card.getText().toString().isEmpty() || card_num.getText().toString().isEmpty()
                        || ccv.getText().toString().isEmpty()) {
                    Toast.makeText(getApplicationContext(), "fields must be filled", Toast.LENGTH_LONG).show();
                }  else if (!card.getText().toString().equals("visa") || card.getText().toString().equals("mastercard")
              ) {
                    t1.setText("invalid card name!");
                    t1.setTextColor(getResources().getColor(R.color.red));


                } else{
                     t1.setText(" ");
                    startActivity(intent);
                }


            }
        });

    }
}