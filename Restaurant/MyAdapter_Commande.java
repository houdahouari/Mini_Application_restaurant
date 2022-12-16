package com.example.restaurant;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MyAdapter_Commande extends BaseAdapter {
    private Context context;
    private List<Food> myListe;
    private LayoutInflater inflater;

    public MyAdapter_Commande(Context context,List<Food> l){
        this.context=context;
        myListe=l;
        this.inflater=LayoutInflater.from(context);
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

    private boolean remove(Food f){
//        try{
            myListe.remove(f);
            this.notifyDataSetChanged();
            return true;
//        } catch (Exception e){
//            e.printStackTrace();
//            return false;
//        }
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        convertView=inflater.inflate(R.layout.list_edit,null);
        Food element=getItem(position);

        String getTitle=element.get_title();
        double getPrice=element.get_price();
        TextView itemTitle=convertView.findViewById(R.id.nameProduct2);
        itemTitle.setText(getTitle);
        TextView itemPrice=convertView.findViewById(R.id.price2);
        itemPrice.setText(String.valueOf(getPrice)+" dh");
        ImageView imageFood=convertView.findViewById(R.id.img2);

        imageFood.setImageResource(element.get_idImage());
        ImageView image_remove=convertView.findViewById(R.id.delete_icone);
        image_remove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                remove(getItem(position));
                MyAdapter.totale-=MyAdapter.liste_myfood.get(position).get_price();
                MyAdapter_Commande.this.notifyDataSetChanged();
                MyAdapter.liste_myfood.remove(MyAdapter.liste_myfood.get(position));
            }
        });
        return convertView;
    }
}
