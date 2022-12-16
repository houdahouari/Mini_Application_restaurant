package com.example.restaurant;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class Utilisateur extends SQLiteOpenHelper {
    public final static String mydataBase="LivraisonFood";
    public final static String table_utilisateur="utilisateur";
    public final static String col_username="username";
    public final static String col_email="email";
    public final static String col_password="password";


    public Utilisateur(@Nullable Context context) {
        super(context, mydataBase, null, 1);
        SQLiteDatabase db=this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table "+table_utilisateur+"("+col_username+" text primary key,"+col_email+" text unique,"+col_password+" text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists "+table_utilisateur+"");
        onCreate(db);
    }

    public boolean addUser(String username,String email,String password){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put(col_username,username);
        cv.put(col_email,email);
        cv.put(col_password,password);
        long res=db.insert(table_utilisateur,null,cv);
        if(res==-1)
        {
            return false;
        }
        else{return true;}
    }


//login get user
    public Cursor VerifyUser(String username, String password){
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor c=db.rawQuery("select * from "+table_utilisateur+" where "+col_email+"=?or" +
                " ("+col_username+"=? and "+col_password+"=?)",new String[]{username,username,password});
        return c;


    }




}
