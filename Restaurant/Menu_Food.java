package com.example.restaurant;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.SearchView;

import java.util.ArrayList;
import java.util.List;

public class Menu_Food extends AppCompatActivity {
    Button cmd;
    ListView liste;
    List<Food> liste_food;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_food);

        liste = findViewById(R.id.liste);
        liste_food = new ArrayList<>();

        liste_food.add(new Food(R.drawable.burgger, "Burgger", 55.0));
        liste_food.add(new Food(R.drawable.cocacola, "cocacola", 10.0));
        liste_food.add(new Food(R.drawable.pain_cake, "pain cake", 30.0));
        liste_food.add(new Food(R.drawable.fanta_orange, "fanta orange", 15.0));
        liste_food.add(new Food(R.drawable.jus_citron, "jus de citron", 10.0));
        liste_food.add(new Food(R.drawable.jus_fraise, "jus de fraise", 25.0));
        liste_food.add(new Food(R.drawable.jus_kiwi, "jus de kiwi", 40.0));
        liste_food.add(new Food(R.drawable.orange_jus, "jus d'orange", 10.0));
        liste_food.add(new Food(R.drawable.sandwich_rapide, "sandwich mixte", 20.0));
        liste_food.add(new Food(R.drawable.soupe_chinoise, "soupe chinoise", 80.0));
        liste_food.add(new Food(R.drawable.soupe_fish, "soupe de poisson", 70.0));
        liste_food.add(new Food(R.drawable.soupe_maroccaine, "soupe maroccaine", 40.0));









        MyAdapter adapter = new MyAdapter(getApplicationContext(), liste_food);

        liste.setAdapter(adapter);

        cmd = findViewById(R.id.commander);
        cmd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (MyAdapter.check == true) {
                    Intent intent = new Intent(getApplicationContext(),List_Commander.class);
                    startActivity(intent);
                }
            }
        });





    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.my_menu, menu);//inflates my menu xml and display it in application
        MenuItem menuItem = menu.findItem(R.id.searchMnu);
        SearchView searchView = (SearchView) menuItem.getActionView();//return the object of the class that is specified within the 'actionViewClass' field
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {//it gets called every new input string(newText)
                ArrayList<Food> results = new ArrayList<>();
                for (Food f : liste_food) {
                    if (f.get_title().contains(newText)) {
                        results.add(f);
                    }
                }

                ((MyAdapter) liste.getAdapter()).update(results);//to refresh the listview
                return false;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }
}