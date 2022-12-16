package com.example.restaurant;

public class Food {
    private String title;
    private double price ;
    private int id_image;

    public Food(int id_image,String title, double price){
        this.id_image=id_image;
        this.title=title;
        this.price=price;
    }

    public String get_title(){return title;}
    public void set_title(String title){
        this.title=title;
    }

    public double get_price(){
        return price;
    }
    public void set_price(double price){
        this.price=price;
    }

    public int get_idImage(){return id_image;}
    public void set_idImage(int id_image){
        this.id_image=id_image;
    }



}
