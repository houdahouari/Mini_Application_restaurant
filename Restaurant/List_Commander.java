package com.example.restaurant;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class List_Commander extends AppCompatActivity {
    ListView l_remove;
    Button commander,finish;
    Button display_price;
    TextView price;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_commander);
        display_price=findViewById(R.id.display_price);
        l_remove=findViewById(R.id.list_edit);
        price=findViewById(R.id.price_totale);


        List<Food> l=new ArrayList<>();
        l.addAll(MyAdapter.liste_myfood);
        l_remove.setAdapter(new MyAdapter_Commande(getApplicationContext(),l));
        commander=findViewById(R.id.commander);

        commander.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),Menu_Food.class);
                startActivity(intent);
            }
        });
        finish=findViewById(R.id.finish);
        finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(getApplicationContext(),Mode_Payement.class);
                startActivity(intent);
            }
        });
        display_price.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                price.setText(String.valueOf(MyAdapter.totale)+" dh");
            }
        });

    }
}