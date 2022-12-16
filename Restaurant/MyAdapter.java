package com.example.restaurant;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MyAdapter extends BaseAdapter {
    private Context context;
    private List<Food> myListe;
    private LayoutInflater inflater;
    public MyAdapter(Context context,List<Food> l){
        this.context=context;
        myListe=l;
        this.inflater=LayoutInflater.from(context);
    }

    public void update(ArrayList<Food> results){
        myListe=new ArrayList<>();
        myListe.addAll(results);
        notifyDataSetChanged();//this method indicates android that our listview needs to get refreshed and the listview gets refreshed immediatly with the current ArrayList
    }
    @Override
    public int getCount() {
        return myListe.size();
    }

    @Override
    public Food getItem(int position) {
        return myListe.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }
    public static boolean check=false;
    public static int p;
    public static double totale=0;
    public static String titre_f;
    public static List<Food> liste_myfood=new ArrayList<>();


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView=inflater.inflate(R.layout.list_menu_food,null);
        Food element=getItem(position);
        TextView itemTitle=convertView.findViewById(R.id.nameProduct);
        itemTitle.setText(element.get_title());
        TextView itemPrice=convertView.findViewById(R.id.price);
        itemPrice.setText(String.valueOf(element.get_price())+" dh");
        ImageView imageFood=convertView.findViewById(R.id.img1);
        imageFood.setImageResource(element.get_idImage());
        CheckBox ch=convertView.findViewById(R.id.btnAdd);
        Food f=new Food(myListe.get(position).get_idImage(),myListe.get(position).get_title(),myListe.get(position).get_price());

        ch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked){

                if (ch.isChecked()){
                    check=true;
                    totale+=myListe.get(position).get_price();
                    titre_f=myListe.get(position).get_title();
                    liste_myfood.add(f);

                }
                else  {
                    totale-=myListe.get(position).get_price();
                    liste_myfood.remove(f);
                }
            }

        });
        return convertView;
    }
}
